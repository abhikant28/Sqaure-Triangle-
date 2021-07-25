package com.example.numbershapes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void check(View view) {
        Button check_btn = findViewById(R.id.button);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(check_btn.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        TextView output =  findViewById(R.id.textView);

        EditText input = findViewById(R.id.editTextNumber);
        if(input.getText().toString().isEmpty()){
            output.setText("Enter a number");
            return;
        }

        int number = Integer.parseInt(input.getText().toString());
        String result = "The number is ";

        int var = (int) Math.sqrt(number);

        if ((var * var) == number) {

            result= result.concat("a Square Number");
        }

        for(int i =0; i<number; i++){

            if (i * (i + 1) == (2 * number)) {

                if (result.length()!=14) {result=result.concat(" & ");}

                result = result.concat("a Triangular Number");

            }
        }
        if(result.length()==14){result=result.concat("Neither");}
        output.setText(String.valueOf(result));
    }
}