package uvm.sbet.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import uvm.sbet.Links.SocialNetworks;
import uvm.sbet.MainActivity;
import uvm.sbet.R;

public class BetsActivity extends AppCompatActivity {


    Button ButtonAcceptBet, ButtonMBets;;
    String User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        User = intent.getStringExtra("user"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);
        ConfigCode();
    }

    void ConfigCode(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButtonAcceptBet = (Button) findViewById(R.id.buttonBetsAccept);
        ButtonAcceptBet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(BetsActivity.this);

                dialog.setContentView(R.layout.dialogbets);
                dialog.setTitle("Apostar");
                Button ButtonCancel = (Button) dialog.findViewById(R.id.buttonDialogBetsCancel);
                ButtonCancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                Button ButtonAccept = (Button) dialog.findViewById(R.id.buttonDialogBetsAccept);
                ButtonAccept.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                        final Dialog dialog2 = new Dialog(BetsActivity.this);
                        dialog2.setContentView(R.layout.dialogbets2);
                        dialog2.setTitle("Recibo");
                        Button ButtonAccept2 = (Button) dialog2.findViewById(R.id.buttonDialogBetsAccept2);
                        ButtonAccept2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                dialog2.cancel();
                            }
                        });
                        dialog2.show();
                    }
                });

                dialog.show();
            }
        });

        ButtonMBets = (Button) findViewById(R.id.buttonBetsMyBets);
        ButtonMBets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(BetsActivity.this, MBetsActivity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                BetsActivity.this.startActivity(myIntent);
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
