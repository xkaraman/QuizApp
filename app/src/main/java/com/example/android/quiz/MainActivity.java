package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        RadioGroup radioGroup;
        RadioButton radioButton;
        CheckBox checkBox;
        EditText inputEditText;
        String str;
        String err0 = "Check your answer in Question/s: ";
        String err = "";
        int radioid;
        double score = 0;
        boolean error = false;
        boolean atLeastOne = false;

        // Question1
        inputEditText = findViewById(R.id.editTextQuestion1);
        str = inputEditText.getText().toString();

        if (str.equalsIgnoreCase("world wide web")) {
            score += 1;
        } else if (str.equalsIgnoreCase("")) {
            // Do nothing
        } else {
            err += "1 ";
        }

        // Question 2
        radioGroup = findViewById(R.id.radioGroup1);

        radioid = radioGroup.getCheckedRadioButtonId();
        if (radioid != -1) {
            radioButton = findViewById(radioid);
            str = radioButton.getText().toString();
            if (str.equalsIgnoreCase("Nokia")) {
                score += 1;
            } else {
                err += "2 ";
            }
        }

        // Question 3
        inputEditText = findViewById(R.id.editTextQuestion3);
        str = inputEditText.getText().toString();

        if (str.equalsIgnoreCase("penguin")) {
            score += 1;
        } else if (str.equalsIgnoreCase("")) {
            // Do nothing
        } else {
            err += "3 ";
        }

        // Question 4
        checkBox = findViewById(R.id.checkBoxChrome);
        if (checkBox.isChecked()) {
            score += .33;
            atLeastOne = true;
        } else
            error = true;

        checkBox = findViewById(R.id.checkBoxFirefox);
        if (checkBox.isChecked()) {
            score += .33;
            atLeastOne = true;
        } else
            error = true;

        checkBox = findViewById(R.id.checkBoxOpera);
        if (checkBox.isChecked()) {
            score += .34;
            atLeastOne = true;
        } else
            error = true;

        checkBox = findViewById(R.id.checkBoxVlc);
        if (checkBox.isChecked()) {
            error = true;
            atLeastOne = true;
        }

        if (error && atLeastOne) {
            err += "4 ";
        }

        // Question 5
        radioGroup = findViewById(R.id.radioGroup2);
        radioid = radioGroup.getCheckedRadioButtonId();
        if (radioid != -1) {
            radioButton = findViewById(radioid);
            str = radioButton.getText().toString();
            if (str.equalsIgnoreCase("1024")) {
                score += 1;
            } else {
                err += "5 ";
            }
        }

        // Show Results on Toast Message
        Context context = getApplicationContext();
        String text;
        if (score == 0 && err.isEmpty()) {
            text = "Please choose some answers!!";
        } else if (score == 5.0 && err.isEmpty()) {
            text = "Score: " + String.valueOf(score) + "/5.0\n";
            text += "You answered correctly to all questions!\nBRAVO!!";

        } else {
            if (!err.isEmpty()) {
                err0 += err;
                text = "Score: " + String.valueOf(score) + "/5.0\n" + err0;
            } else
                text = "Score: " + String.valueOf(score) + "/5.0";

        }

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }
}
