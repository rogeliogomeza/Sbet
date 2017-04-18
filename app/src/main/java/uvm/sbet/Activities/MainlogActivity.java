package uvm.sbet.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import uvm.sbet.Links.SocialNetworks;
import uvm.sbet.MainActivity;
import uvm.sbet.R;

public class MainlogActivity extends AppCompatActivity {

    String User;
    TextView TextViewMainlogLogin;
    ImageButton ButtonInstagram, ButtonTwitter, ButtonFacebook;
    Context context;
    Button ButtonLogout, ButtonResults, ButtonBets, ButtonLives, ButtonMBets, ButtonNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        User = intent.getStringExtra("user"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlog);
        ConfigCode();
    }

    void ConfigCode(){

        ButtonInstagram = (ImageButton) findViewById(R.id.imageButtonInstagram);
        ButtonTwitter= (ImageButton) findViewById(R.id.imageButtonTwitter);
        ButtonFacebook = (ImageButton) findViewById(R.id.imageButtonFacebook);
        context=this;
        new SocialNetworks(context,ButtonInstagram,ButtonTwitter,ButtonFacebook);

        ButtonLogout = (Button) findViewById(R.id.buttonMainlogLogout);
        ButtonLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainlogActivity.this.finish();
            }
        });

        TextViewMainlogLogin = (TextView) findViewById(R.id.textViewMainlogLogin);
        TextViewMainlogLogin.setText(TextViewMainlogLogin.getText().toString()+User);

        ButtonResults = (Button) findViewById(R.id.buttonMainlogResults);
        ButtonResults.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainlogActivity.this, ResultsActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainlogActivity.this.startActivity(myIntent);
            }
        });

        ButtonBets = (Button) findViewById(R.id.buttonMainlogBets);
        ButtonBets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainlogActivity.this, BetsActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainlogActivity.this.startActivity(myIntent);
            }
        });

        ButtonLives = (Button) findViewById(R.id.buttonMainlogLives);
        ButtonLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainlogActivity.this, LivesActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainlogActivity.this.startActivity(myIntent);
            }
        });

        ButtonMBets = (Button) findViewById(R.id.buttonMainlogMBets);
        ButtonMBets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainlogActivity.this, MBetsActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainlogActivity.this.startActivity(myIntent);
            }
        });

        ButtonNews = (Button) findViewById(R.id.buttonMainlogNews);
        ButtonNews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainlogActivity.this, NewsActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainlogActivity.this.startActivity(myIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);

    }


}
