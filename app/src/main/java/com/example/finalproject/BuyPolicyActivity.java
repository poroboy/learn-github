package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class BuyPolicyActivity extends AppCompatActivity {

    Spinner insuranceTypeSpinner;
    TextView costTextView;
    CheckBox coverage1CheckBox;
    CheckBox coverage2CheckBox;
    int[] insuranceCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_policy);



        // Initialize the views
        insuranceTypeSpinner = findViewById(R.id.spinner_insurance_type);
        costTextView = findViewById(R.id.tv_cost);
        coverage1CheckBox = findViewById(R.id.cb_coverage1);
        coverage2CheckBox = findViewById(R.id.cb_coverage2);
        insuranceCosts = getResources().getIntArray(R.array.insurance_costs);
        Button loginButton = findViewById(R.id.btn_submit);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyPolicyActivity.this, MyPlanActivity.class);
                startActivity(intent);

        }
    });


                coverage1CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateTotalCost());
        coverage2CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateTotalCost());

        // Set the listener for the spinner
        insuranceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selectedCost = insuranceCosts[position];
                costTextView.setText("ราคา: " + selectedCost + " .-");
                costTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                costTextView.setVisibility(View.GONE);
            }
        });
    }

    private void updateTotalCost() {
        int baseCost = insuranceCosts[insuranceTypeSpinner.getSelectedItemPosition()];
        if (coverage1CheckBox.isChecked()) {
            baseCost += 300;  // Additional cost for Coverage 1
        }
        if (coverage2CheckBox.isChecked()) {
            baseCost += 300;  // Additional cost for Coverage 2
        }
        costTextView.setText("ราคา: " + baseCost + " .-");
    }
}



