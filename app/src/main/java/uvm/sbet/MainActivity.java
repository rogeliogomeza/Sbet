package uvm.sbet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import uvm.sbet.Activities.LoginActivity;
import uvm.sbet.Activities.RegisterActivity;
import uvm.sbet.Links.SocialNetworks;


public class MainActivity extends AppCompatActivity {

    ImageButton ButtonInstagram, ButtonTwitter, ButtonFacebook;
    Context context;
    Button ButtonLogin, ButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConfigCode();

    }

    void ConfigCode(){

        ButtonInstagram = (ImageButton) findViewById(R.id.imageButtonInstagram);
        ButtonTwitter= (ImageButton) findViewById(R.id.imageButtonTwitter);
        ButtonFacebook = (ImageButton) findViewById(R.id.imageButtonFacebook);
        context=this;
        new SocialNetworks(context,ButtonInstagram,ButtonTwitter,ButtonFacebook);

        ButtonLogin = (Button) findViewById(R.id.buttonMainLogin);
        ButtonSignUp = (Button) findViewById(R.id.buttonMainSignUp);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, RegisterActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

    }


}

