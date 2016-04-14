package com.example.pc.kyodai;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Runnable {
    ImageButton btnplay,btnscore,btnabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnplay=(ImageButton)findViewById(R.id.btnplay);
        btnscore=(ImageButton)findViewById(R.id.btnscore);
        btnabout=(ImageButton)findViewById(R.id.btnabout);
        btnplay.setOnClickListener(this);
        btnscore.setOnClickListener(this);
        btnabout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnplay:
                Intent startGameActivity = new Intent(this, GameActivity.class);
                startActivity(startGameActivity);
                break;

            case R.id.btnscore:
                Intent startScoreActivity = new Intent(this, ScoreActivity.class);
                startActivity(startScoreActivity);
                break;
            case R.id.btnabout:
                Intent startAboutActivity = new Intent(this, AboutActivity.class);
                startActivity(startAboutActivity);

        }

    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void run() {

    }
}