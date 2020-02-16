package com.example.myapplication.navigation.ui.tips;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;


public class Calculator extends Activity {





    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);

        final TextView calculation_result = this.findViewById(R.id.calculate_result);
        final EditText et1 = this.findViewById(R.id.general_input);
        final EditText et2 = this.findViewById(R.id.garden_input);
        final EditText et3 = this.findViewById(R.id.hardcore_input);
        Button btn = this.findViewById(R.id.calculate_btn);

        calculation_result.setText("0");

        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // add a button listener
                // when user click the calculate button, the calculation method will be involved, then the result will be transfer to the textView

                String inputText1 = et1.getText().toString();
                String inputText2 = et2.getText().toString();
                String inputText3 = et3.getText().toString();
                if (inputText1.trim().isEmpty() || inputText2.trim().isEmpty() || inputText3.trim().isEmpty())
                {
                    Toast.makeText(Calculator.this, "One or more than one box is empty, Please enter the weight correctly.", Toast.LENGTH_SHORT).show();
                    calculation_result.setText("ERROR");
                }
                else
                {
                    float num1 = Float.valueOf(inputText1).intValue();
                    float num2 = Float.valueOf(inputText2).intValue();
                    float num3 = Float.valueOf(inputText3).intValue();

                    float num4 = (num1*25)+(num2*20)+(num3*16);

                    // contain the labour price depending on the weight
                    if (num1+num2+num3<250) {
                        inputText1 = String.valueOf(num4/100+35);
                    }
                    else{
                        inputText1 = String.valueOf(num4/100+70);
                    }

                    calculation_result.setText("€ "+inputText1);
                }
            }
        });


        final TextView prices = this.findViewById(R.id.prices);
        prices.setText("General Rubbish: 25c per/KG \nGarden Waste: 20c per/KG \nHardcore / Soil: 16c per/KG \nLabour: <250kg: €35   ;   >250kg: €70");
    }
}


