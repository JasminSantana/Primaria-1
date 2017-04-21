package mx.edu.utng.primaria.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import mx.edu.utng.primaria.R;

@SuppressLint("SetJavaScriptEnabled") 
public class TableroLogros extends ActionBarActivity {

	WebView webView;
	int test1, test2, test3, test4, test5, testFinal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTitle("Tablero de Logros");
        setContentView(R.layout.tablero_logors);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		test1=10;
		test2=10;
		test3=10;
		test4=10;
		test5=10;
		testFinal=10;
        Intent intent = getIntent();
        test1 = intent.getIntExtra("Test One", 0);
        test2 = intent.getIntExtra("Test Two", 0);
        test3 = intent.getIntExtra("Test Three", 0);
        test4 = intent.getIntExtra("Test FOur", 0);
        test5 = intent.getIntExtra("Test Five", 0);
        testFinal = intent.getIntExtra("Test finish", 0);

        webView = (WebView)findViewById(R.id.wb_tablero_logros);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.getSettings().setJavaScriptEnabled(true); 
        webView.loadUrl("file:///android_asset/index.html");
	}

	public class WebAppInterface {

	    @JavascriptInterface
		public int getTest1() {
			return test1;
		}
		
		@JavascriptInterface
		public int getTest2() {
			return test2;
		}
		
		@JavascriptInterface
		public int getTest3() {
			return test3;
		}
		
		@JavascriptInterface
		public int getTest4() {
			return test4;
		}
		
		@JavascriptInterface
		public int getTest5() {
			return test5;
		}

		@JavascriptInterface
		public int getTestFinal() {
			return testFinal;
		}
	}

}
