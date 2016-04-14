package com.example.pc.kyodai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by PC on 13/04/2016.
 */
public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text,text2;
    ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        text=(TextView)findViewById(R.id.text);
        text2=(TextView)findViewById(R.id.text2);
        home=(ImageButton)findViewById(R.id.home);
        home.setOnClickListener(this);
}
    @Override
    public void onClick(View v) {
        v.getId();
        Intent startMainActivity = new Intent(this, MainActivity.class);
        startActivity(startMainActivity);
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
}