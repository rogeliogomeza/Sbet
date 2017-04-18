package uvm.sbet.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import uvm.sbet.Links.SocialNetworks;
import uvm.sbet.MainActivity;
import uvm.sbet.R;

public class LoginActivity extends AppCompatActivity {

    ImageButton ButtonInstagram, ButtonTwitter, ButtonFacebook;
    Context context;
    EditText EditTextNickname, EditTextPassword;
    TextView TextViewRequestUser;
    Button ButtonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConfigCode();

    }


    void ConfigCode(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButtonInstagram = (ImageButton) findViewById(R.id.imageButtonInstagram);
        ButtonTwitter= (ImageButton) findViewById(R.id.imageButtonTwitter);
        ButtonFacebook = (ImageButton) findViewById(R.id.imageButtonFacebook);
        context=this;
        new SocialNetworks(context,ButtonInstagram,ButtonTwitter,ButtonFacebook);

        EditTextNickname = (EditText) findViewById(R.id.editTextLoginNickname);
        EditTextNickname.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextNickname.getText().toString().length() <= 0) {
                    EditTextNickname.setError("Este campo no puede estar vacio");
                } else {
                    EditTextNickname.setError(null);
                }
            }
        });

        EditTextPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        EditTextPassword.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextPassword.getText().toString().length() <= 0) {
                    EditTextPassword.setError("Este campo no puede estar vacio");
                } else {
                    EditTextPassword.setError(null);
                }
            }
        });

        TextViewRequestUser = (TextView) findViewById(R.id.textViewRequestUser);
        TextViewRequestUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(LoginActivity.this);

                dialog.setContentView(R.layout.dialogrequestuser);
                dialog.setTitle("Pedir nombre de usuario y contraseña");
                Button ButtonSend = (Button) dialog.findViewById(R.id.buttonDialogRequestUserSend);

                ButtonSend.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

        ButtonLogin = (Button) findViewById(R.id.buttonLoginLogin);
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, MainlogActivity.class);
                myIntent.putExtra("user",EditTextNickname.getText().toString()); //Optional parameters
                LoginActivity.this.startActivity(myIntent);
                LoginActivity.this.finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
