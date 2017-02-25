package mx.edu.utng.primaria.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

import mx.edu.utng.primaria.R;

/**
 * Created by Santana on 2/1/2017.
 */
public class Videos extends Activity {
    private VideoView video;
    private Resources r;
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.video);

        video = (VideoView) findViewById(R.id.video);
        Bundle bundle = this.getIntent().getExtras();
        //Toast.makeText(this,"dato  "+bundle.getInt("Video"),Toast.LENGTH_LONG).show();
        switch (bundle.getInt("Video")) {
            case 1:
                r = this.getResources();

                Uri direcc = Uri.parse("android.resource://mx.edu.utng.primaria/" + R.raw.abecedario);
                video.setVideoURI(direcc);
                video.start();

                //AMPLIACIÓN
                MediaController mc = new MediaController(this);
                video.setMediaController(mc);
                video.setVideoURI(direcc);
                video.start();
                break;
            case 2:
                r = this.getResources();

                Uri direc = Uri.parse("android.resource://mx.edu.utng.primaria/" + R.raw.numbrers);
                video.setVideoURI(direc);
                video.start();

                //AMPLIACIÓN
                MediaController meco = new MediaController(this);
                video.setMediaController(meco);
                video.setVideoURI(direc);
                video.start();
                break;
            case 3:
                r = this.getResources();

                Uri dire = Uri.parse("android.resource://mx.edu.utng.primaria/" + R.raw.colors);
                video.setVideoURI(dire);
                video.start();

                //AMPLIACIÓN
                MediaController mdco = new MediaController(this);
                video.setMediaController(mdco);
                video.setVideoURI(dire);
                video.start();
                break;

        }

    }

}
