package uvm.sbet.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import uvm.sbet.R;

public class Lives2Activity extends AppCompatActivity {

    String User;
    Button ButtonWatch, ButtonStats, ButtonComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        User = intent.getStringExtra("user"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lives2);
        ConfigCode();
    }


    void ConfigCode(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButtonWatch = (Button) findViewById(R.id.buttonLives2Watch);
        ButtonWatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Lives2Activity.this, "No se puede colocar en pantalla completa. No hay video disponible",
                        Toast.LENGTH_LONG).show();
            }
        });

        ButtonStats = (Button) findViewById(R.id.buttonLives2Stats);
        ButtonStats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Lives2Activity.this);

                dialog.setContentView(R.layout.dialoglives);
                dialog.setTitle("Estadisticas");
                Button ButtonAccept = (Button) dialog.findViewById(R.id.buttonDialogLivesAccept);
                ButtonAccept.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

        ButtonComments = (Button) findViewById(R.id.buttonMainLives2Comments);
        ButtonComments.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Lives2Activity.this);

                dialog.setContentView(R.layout.dialoglives2);
                dialog.setTitle("Comenta");
                Button ButtonAccept = (Button) dialog.findViewById(R.id.buttonDialogLives2Accept);
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
