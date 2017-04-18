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

public class LivesActivity extends AppCompatActivity {

    String User;
    Button ButtonAcceptLives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        User = intent.getStringExtra("user"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lives);
        ConfigCode();
    }

    void ConfigCode(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButtonAcceptLives = (Button) findViewById(R.id.buttonLivesSend);
        ButtonAcceptLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(LivesActivity.this, Lives2Activity.class);
                myIntent.putExtra("key", "cool"); //Optional parameters
                LivesActivity.this.startActivity(myIntent);
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
