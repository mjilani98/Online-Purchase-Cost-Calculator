package com.example.hw2q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonHandler handler = new ButtonHandler();
        Button button = findViewById(R.id.btnCalculate);
        button.setOnClickListener(handler);

    }

    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            //get the price
            EditText priceInput = findViewById(R.id.priceInput);
            String strPrice = priceInput.getText().toString();
            double price=0;
            try
            {
                price = Double.parseDouble(strPrice);
            }
            catch (NumberFormatException e)
            {
                //if the user enters an invalid input show an error message
                Toast toast = Toast.makeText(getApplicationContext(),"Price:\n\tInvalid input",Toast.LENGTH_LONG);
                toast.show();
            }

            //get the state of warranty
            ToggleButton warrantyToggle = findViewById(R.id.toggleBtn);
            boolean warranty;
            if(warrantyToggle.isChecked())
                warranty = true;
            else
                warranty = false;


            //get the insurance
            Switch insuranceSwitch = findViewById(R.id.switch1);
            boolean insurance;
            if(insuranceSwitch.isChecked())
                insurance = true;
            else
                insurance = false;


            //get the delivery
            Spinner spinnerDelivery = findViewById(R.id.spinner1);
            String strDelivery = (String)spinnerDelivery.getSelectedItem();
            String str = "";
            if(strDelivery.equals("Normal"))
                str = "Normal";
            if(strDelivery.equals("Second day"))
                str = "Second day";
            if(strDelivery.equals("Next day"))
                str = "Next day";

            //calculate the cost
            //creating a DeliveryCost object
            DeliveryCost deliveryCost = new DeliveryCost(price,warranty,insurance,str);
            double cost = deliveryCost.getCost();

            //display the cost
            TextView output = findViewById(R.id.txtViewCostOutput);
            output.setText("$"+cost);

        }
    }
}