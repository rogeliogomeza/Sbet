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

public class RegisterActivity extends AppCompatActivity {


    ImageButton ButtonInstagram, ButtonTwitter, ButtonFacebook;
    Context context;
    EditText EditTextName, EditTextLastname,EditTextDate,EditTextCountry,EditTextEmail,EditTextNickname, EditTextPassword;
    Button ButtonRegister, ButtonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

        EditTextName = (EditText) findViewById(R.id.editTextRegisterNames);
        EditTextName.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextName.getText().toString().length() <= 0) {
                    EditTextName.setError("Este campo no puede estar vacio");
                } else {
                    EditTextName.setError(null);
                }
            }
        });

        EditTextLastname = (EditText) findViewById(R.id.editTextRegisterLastname);
        EditTextLastname.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextLastname.getText().toString().length() <= 0) {
                    EditTextLastname.setError("Este campo no puede estar vacio");
                } else {
                    EditTextLastname.setError(null);
                }
            }
        });

        EditTextDate = (EditText) findViewById(R.id.editTextRegisterDate);
        EditTextDate.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextDate.getText().toString().length() <= 0) {
                    EditTextDate.setError("Este campo no puede estar vacio");
                } else {
                    EditTextDate.setError(null);
                }
            }
        });

        EditTextCountry = (EditText) findViewById(R.id.editTextRegisterCountry);
        EditTextCountry.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextCountry.getText().toString().length() <= 0) {
                    EditTextCountry.setError("Este campo no puede estar vacio");
                } else {
                    EditTextCountry.setError(null);
                }
            }
        });

        EditTextEmail = (EditText) findViewById(R.id.editTextRegisterEmail);
        EditTextEmail.addTextChangedListener(new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (EditTextEmail.getText().toString().length() <= 0) {
                    EditTextEmail.setError("Este campo no puede estar vacio");
                } else {
                    EditTextEmail.setError(null);
                }
            }
        });

        EditTextNickname = (EditText) findViewById(R.id.editTextRegisterNickname);
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

        EditTextPassword = (EditText) findViewById(R.id.editTextRegisterPassword);
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



        ButtonRegister = (Button) findViewById(R.id.buttonRegisterRegister);
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(RegisterActivity.this);

                dialog.setContentView(R.layout.dialogregisteruser);
                dialog.setTitle("Terminos y Condiciones");
                Button ButtonCancel = (Button) dialog.findViewById(R.id.buttonDialogRegisterUserCancel);

                ButtonCancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                Button ButtonAccept = (Button) dialog.findViewById(R.id.buttonDialogRegisterUserAccept);

                ButtonAccept.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                        myIntent.putExtra("key", "cool"); //Optional parameters
                        RegisterActivity.this.startActivity(myIntent);
                        dialog.cancel();
                        RegisterActivity.this.finish();
                    }
                });

                dialog.show();
            }
        });

        ButtonClear = (Button) findViewById(R.id.buttonRegisterClear);
        ButtonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonClear.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        EditTextName.setText("");
                        EditTextLastname.setText("");
                        EditTextDate.setText("");
                        EditTextCountry.setText("");
                        EditTextEmail.setText("");
                        EditTextNickname.setText("");
                        EditTextPassword.setText("");
                    }
                });
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
