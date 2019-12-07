package com.example.rewardcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.rewardcalculator.Constant.CHASE_URL;
import static com.example.rewardcalculator.Constant.CITI_URL;


public class citi extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private TextView moneycash;
    private TextView moneytravel;
    private Button convert;
    private EditText point;
    private Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chase);

        back = findViewById(R.id.Return1);
        back.setOnClickListener(this);

        convert = findViewById(R.id.amex_clikcer);
        convert.setOnClickListener(this);

        apply = findViewById(R.id.apply_amex );
        apply.setOnClickListener(this);

        point = findViewById(R.id.totalpoints);

        moneycash = findViewById(R.id.money_chase);
        moneytravel = findViewById(R.id.trvael_chase);

//        money.setVisibility(View.GONE);

//        EditText point = findViewById(R.id.totalpoints);
//        String txt = point.getText().toString();
//        if (!txt.isEmpty()) {
//            int number = Integer.parseInt(point.getText().toString());
//            money = findViewById(R.id.textout_amex);
//            money.setText(String.valueOf(number));
//        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.amex_clikcer:
                String txt = point.getText().toString();
                if (!txt.isEmpty()) {
                    double number = Double.valueOf(point.getText().toString());
                    number = number * 0.01;
                    double numbertravel = Double.valueOf(point.getText().toString());
                    numbertravel = numbertravel *0.0125;
                    moneycash.setText("$" + String.valueOf(number) + " In Cash");
                    moneycash.setVisibility(View.VISIBLE);
                    moneytravel.setText("$" + String.valueOf(numbertravel) + " For Travel");
                } else {
                    moneycash.setVisibility(View.GONE);
                    moneytravel.setVisibility(View.GONE);
                }
                break;
            case R.id.Return1:
                finish();
                break;
            case R.id.apply_amex:

                intent = new Intent(this,WebActivity.class);
                intent.putExtra("URL",CITI_URL);
                break;

        }
        if (intent != null){
            startActivity(intent);
        }
    }

}
