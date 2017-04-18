package uvm.sbet.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import uvm.sbet.R;

public class ResultsActivity extends AppCompatActivity {


    String User;
    Button ButtonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        User = intent.getStringExtra("user"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ConfigCode();
    }

    void ConfigCode(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButtonSend = (Button) findViewById(R.id.buttonResultsSend);
        ButtonSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ResultsActivity.this);

                dialog.setContentView(R.layout.dialogresults);
                dialog.setTitle("Resultados");
                Button ButtonAccept = (Button) dialog.findViewById(R.id.buttonDialogResultsAccept);

                ButtonAccept.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
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
