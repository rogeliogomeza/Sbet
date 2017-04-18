package uvm.sbet.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import uvm.sbet.R;

public class MBetsActivity extends AppCompatActivity {

    String User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        User = intent.getStringExtra("user"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbets);
        ConfigCode();
    }

    void ConfigCode(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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
