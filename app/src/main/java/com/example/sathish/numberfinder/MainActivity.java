package com.example.sathish.numberfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class Shape {
        int number;

        public boolean isTriangle() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isSquare() {
            double root = Math.sqrt(number);
            if (root == Math.floor(root)) {
                return true;
            } else {
                return false;
            }
        }
    }



   public void testNumber(View view) {

       Log.i("Info", "Button clicked");

        EditText inputNumber = (EditText) findViewById(R.id.input);
        String message;

       if(inputNumber.getText().toString().isEmpty()) {

           message = "Please enter a valid number";
       }
       else{

        Shape myNumber = new Shape();

        myNumber.number = Integer.parseInt(inputNumber.getText().toString());
            message = inputNumber.getText().toString();


                if (myNumber.isSquare() && myNumber.isTriangle()) {
                message += " is Square and Triangular number";
                } else if (myNumber.isTriangle()) {
                message += " is a Triangular number";
                } else if (myNumber.isSquare()) {
                message += " is a Square number";
                } else {
                message += " is not a Square or Triangular number";
                }


    }
       Toast.makeText(this, message, Toast.LENGTH_LONG).show();
}






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
