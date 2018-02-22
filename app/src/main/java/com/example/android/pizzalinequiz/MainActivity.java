package com.example.android.pizzalinequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitScore(View view) {
        int rawScore = 0;
        CheckBox checkBox = findViewById(R.id.checkBox1a);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;
        checkBox = findViewById(R.id.checkBox1b);
        if (checkBox.isChecked()) rawScore--;
        checkBox = findViewById(R.id.checkBox1c);
        if (checkBox.isChecked()) rawScore--;
        checkBox = findViewById(R.id.checkBox1d);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;

        checkBox = findViewById(R.id.checkBox2a);
        if (checkBox.isChecked()) rawScore--;
        checkBox = findViewById(R.id.checkBox2b);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;
        checkBox = findViewById(R.id.checkBox2c);
        if (checkBox.isChecked()) rawScore--;
        checkBox = findViewById(R.id.checkBox2d);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;

        RadioButton radioButton = findViewById(R.id.radio3);
        if (radioButton.isChecked()) rawScore++;
        else rawScore--;

        radioButton = findViewById(R.id.radio4);
        if (radioButton.isChecked()) rawScore++;
        else rawScore--;

        radioButton = findViewById(R.id.radio5);
        if (radioButton.isChecked()) rawScore++;
        else rawScore--;

        checkBox = findViewById(R.id.checkBox6a);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;
        checkBox = findViewById(R.id.checkBox6b);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;
        checkBox = findViewById(R.id.checkBox6c);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;
        checkBox = findViewById(R.id.checkBox6d);
        if (checkBox.isChecked()) rawScore++;
        else rawScore--;

        String answer7 = getResources().getString(R.string.answer7);
        TextView textView = findViewById(R.id.etAnswer7);
        String etAnswer7 = textView.getText().toString();
        if (answer7.equals(etAnswer7)) rawScore++; // TIL don't use (x == y) for Strings
        else rawScore--;

        displayScore(rawScore);
    }

    private void displayScore(int rawScore) {
        int scoreVal = Math.abs(rawScore * 17); //rough estimate what a pizza is worth
        String message;
        // TODO: Convert these to strings.xml in preparation for translation
        if (rawScore < 1) {
            message = "FAIL: You have ruined " + Math.abs(rawScore) + " pizzas at a value of $" + (scoreVal);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (rawScore < 12) {
            message = "PASS: Barely. You only made $" + scoreVal + " worth of pizzas";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (rawScore == 12) {
            message = "WIN: 100% No errors. $" + scoreVal + " worth of pizzas made.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Log.e("displayScore", "an impossible score has been achieved");
            Toast.makeText(this, "(error)", Toast.LENGTH_SHORT).show();
        }

    }
}
