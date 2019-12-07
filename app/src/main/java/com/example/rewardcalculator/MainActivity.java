package com.example.rewardcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.rewardcalculator.Constant.CHASE_URL;
import static com.example.rewardcalculator.Constant.CITI_URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button amex;
    private Button chase;
    private Button citi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        amex = findViewById(R.id.amex);
        amex.setOnClickListener(this);
        chase = findViewById(R.id.chase);
        chase.setOnClickListener(this);

        citi = findViewById(R.id.citi);
        citi.setOnClickListener(this);
        /*final Button chase = findViewById(R.id.chase);
        Amex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, chase.class);
                startActivity(intent);
            }
        });*/
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.amex:
                intent = new Intent(MainActivity.this, Amex.class);
                break;
            case R.id.chase:
                intent = new Intent(this,chase.class);
                break;
            case R.id.citi:
                intent = new Intent(this,citi.class);
                intent.putExtra("URL",CITI_URL);
                break;
            default:
                break;
        }
        if (intent != null){
            startActivity(intent);
        }
    }
}
