package mx.edu.utng.primaria.menu;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import mx.edu.utng.primaria.activities.Objects;
import mx.edu.utng.primaria.login.PrefManager;
import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.test.Test;
import mx.edu.utng.primaria.activities.AlphabetNumbers;
import mx.edu.utng.primaria.activities.AnimalsColors;
import mx.edu.utng.primaria.activities.FamilyClothes;
import mx.edu.utng.primaria.activities.GeoFigSports;
import mx.edu.utng.primaria.fragments.FragmentCamera;
import mx.edu.utng.primaria.fragments.FragmentGallery;
import mx.edu.utng.primaria.sqlite.DbHelper;
import mx.edu.utng.primaria.login.LoginActivity;
import mx.edu.utng.primaria.login.Session;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentCamera.OnFragmentInteractionListener, FragmentGallery.OnFragmentInteractionListener{
    private ImageButton fabActivity1;
    private ImageButton fabActivity2;
    private ImageButton fabActivity3;
    private ImageButton fabActivity4;
    private ImageButton fabActivity5;
    private ImageView ivTest;
    private TextView tvAbNu;
    private TextView tvAnCo;
    private TextView tvFaRo;
    private TextView tvFgDe;
    private TextView tvObCa;
    private Session session;

    private final static String SETTING_USER = "setting_user";
    private final static String SETTING_PASS = "setting_pass";
    private String user;
    private String pass;
    SharedPreferences sharedPreferences;

    private int califTest=8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
        user = sharedPreferences.getString(SETTING_USER,"");
        pass = sharedPreferences.getString(SETTING_PASS,"");

        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(R.layout.activity_main, null);

        fabActivity1 = (ImageButton)findViewById(R.id.fab_activity_1);
        fabActivity2 = (ImageButton)findViewById(R.id.fab_activity_2);
        fabActivity3 = (ImageButton)findViewById(R.id.fab_activity_3);
        fabActivity4 = (ImageButton)findViewById(R.id.fab_activity_4);
        fabActivity5 = (ImageButton)findViewById(R.id.fab_activity_5);
        ivTest =(ImageView)findViewById(R.id.bt_certificate);
        tvAbNu = (TextView)findViewById(R.id.tv_al_nu);
        tvAnCo = (TextView)findViewById(R.id.tv_an_co);
        tvFaRo = (TextView)findViewById(R.id.tv_fa_ro);
        tvFgDe = (TextView)findViewById(R.id.tv_fg_de);
        tvObCa = (TextView)findViewById(R.id.tv_ob_ca);



        tvAbNu.setText("Alphabet\nNumbers");
        tvAnCo.setText("Animal\nColors");
        tvFaRo.setText("Family\nClothes");
        tvFgDe.setText("Geometric Figures\nSports");
        tvObCa.setText("Objects");
        //ivTest.setBackgroundResource(R.color.dot_dark_screen4);

       // Toast.makeText(this, "logins is: "+ user +"--"+ pass , Toast.LENGTH_SHORT).show();

        int score = 0;
        try{
            SQLiteDatabase db = new DbHelper(MainActivity.this).getReadableDatabase();
            String selectQueryScore = "select COLUMN_SCORE_SCORE from SCORE_TABLE where COLUMN_SCORE_SCORE >= " +
                    "" + "'"+califTest+"'" + " and  COLUMN_EMAIL = " + "'"+user+"'" + " and COLUMN_PASSWORD = " + "'"+pass+"'";

            Cursor cursor = db.rawQuery(selectQueryScore, null);
            cursor.moveToFirst();
            //score=cursor.getCount();
            score=cursor.getInt(califTest);
        }catch (Exception e){
            Log.d("Exception ->", score +  "");
        }

        fabActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fabActivity1.isPressed()){
                    fabActivity1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                startActivity(new Intent(getApplicationContext(),AlphabetNumbers.class));
            }
        });

        final int finalScore = score;
        fabActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random r = new Random();
                int calif = r.nextInt(10);

                if (calif >= califTest) {
                    startActivity(new Intent(getApplicationContext(),AnimalsColors.class));
                    // fabActivity2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    // fabActivity2.setBackgroundResource(R.color.verde);
                    Toast.makeText(MainActivity.this, "Calif= "+calif, Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 2").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }
        });

        fabActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int calif = r.nextInt(10);

                if (calif >= califTest) {
                    startActivity(new Intent(getApplicationContext(),FamilyClothes.class));
                    Toast.makeText(MainActivity.this, "Calif= "+calif, Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 3").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }
        });

        fabActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int calif = r.nextInt(10);

                if (calif >= califTest) {
                    startActivity(new Intent(getApplicationContext(),GeoFigSports.class));
                    Toast.makeText(MainActivity.this, "Calif= "+calif, Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 4").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }
        });

        fabActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int calif = r.nextInt(10);

                if (calif >= califTest) {
                    startActivity(new Intent(getApplicationContext(),Objects.class));
                    Toast.makeText(MainActivity.this, "Calif= "+calif, Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 5").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }
        });

        ivTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int calif = r.nextInt(10);

                if (calif >= califTest) {
                    startActivity(new Intent(getApplicationContext(),Test.class));
                    Toast.makeText(MainActivity.this, "Calif= "+calif, Toast.LENGTH_SHORT).show();
                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Perform the previous activities first, to perform the final test")
                            .setTitle("Final test blocked").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }
        });




        session = new Session(this);

        if(!session.loggedin()){
            logout();
        }


        FloatingActionButton fab =(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawer, toolbar,(R.string.open_drawer),(R.string.close_drawer));
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        boolean fragmentTransaction=false;
        Fragment fragment = null;
        if(id==R.id.nav_camera){
            fragment = new FragmentCamera();
            fragmentTransaction= true;

        } else if(id==R.id.nav_gallery){
            fragment = new FragmentGallery();
            fragmentTransaction= true;

        }else if(id==R.id.nav_slideshow){
            Log.i("Navegation Drawer","Entering in option slideshow");
            getSupportActionBar().setTitle("Slideshow");

        } else if(id==R.id.nav_manage){
            Log.i("Navegation Drawer","Entering in option manage");
            getSupportActionBar().setTitle(session.getClass().getClass().getName());
//jeje aqui cambiarle
        }else if(id==R.id.nav_view){
            Log.i("Navegation View","Entering in option view");
            getSupportActionBar().setTitle("View");

        }else if(id==R.id.nav_share){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            Log.i("Navegation Drawer","Option 1: "+preferences.getBoolean("option1", false));
            Log.i("Navegation Drawer","Option 2: "+preferences.getString("option2", ""));
            Log.i("Navegation Drawer","Option 3: "+preferences.getString("option3", ""));

        } else if(id==R.id.nav_send){
            startActivity(new Intent(this, Preferences.class));
            Log.i("Navigation Dreawer", "Enterinf in option Preferences");

        }else if (id==R.id.nav_instructions){
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();


        }else if (id==R.id.nav_exit){
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            session.setLoggedin(false);
            finish();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));

        }
        if (fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
        //********************************************************



}
