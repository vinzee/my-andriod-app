package com.example.vinzee.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonDollarToEuro, buttonEuroToDollar, buttonOpenActivity;
    private EditText editTextDollar, editTextEuro;
//    private View Main2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDollarToEuro = findViewById(R.id.buttonDollarToEuro);
        buttonEuroToDollar = findViewById(R.id.buttonEuroToDollar);
        buttonOpenActivity = findViewById(R.id.buttonOpenActivity);
//        buttonOpenActivity.setTooltipText("Open new activity");

        editTextDollar = findViewById(R.id.editTextDollar);
        editTextEuro = findViewById(R.id.editTextEuro);

        buttonEuroToDollar.setOnClickListener(this);
        buttonDollarToEuro.setOnClickListener(this);
        buttonOpenActivity.setOnClickListener(this);
    }

    protected void onStart() { super.onStart(); }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonDollarToEuro:
                if (editTextDollar.getText().toString() != null) {
                    float dollar = Float.valueOf(editTextDollar.getText().toString()).floatValue();
                    if(dollar < 0){
                        Toast.makeText(getApplicationContext(), "Positive Values Only!", Toast.LENGTH_LONG).show();
                    }
                    float euros = (float) (dollar * 0.82);
                    editTextEuro.setText(new Float(euros).toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Fill in the Dollars", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.buttonEuroToDollar:
                if (editTextEuro.getText().toString() != null) {
                    float euros = Float.valueOf(editTextEuro.getText().toString()).floatValue();
                    if(euros < 0){
                        Toast.makeText(getApplicationContext(), "Positive Values Only!", Toast.LENGTH_LONG).show();
                    }
                    float dollars = (float) (euros / 0.82);
                    editTextDollar.setText(new Float(dollars).toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Fill in the Euros", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.buttonOpenActivity:
                Intent myIntent = new Intent(this, Main2Activity.class);
                startActivity(myIntent);

                break;

            default:
                Toast.makeText(getApplicationContext(), "Not a valid option!", Toast.LENGTH_LONG).show();
        }
    }

}
