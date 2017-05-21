package com.example.dell.boo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.paperdb.Paper;

public class FinalActivity extends AppCompatActivity {

    private TextView tvName, tvPrice, tvLocation, tvAddress, tvContactNumber, tvPin, tvState, tvInfo;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        init();
        tvName.setText((CharSequence) Paper.book().read("UserName"));
        tvPrice.setText((CharSequence) Paper.book().read("Price"));
        tvLocation.setText((CharSequence) Paper.book().read("Location"));
        tvAddress.setText((CharSequence) Paper.book().read("Address"));
        tvContactNumber.setText((CharSequence) Paper.book().read("PhoneNumber"));
        tvPin.setText((CharSequence) Paper.book().read("Pin"));
        tvState.setText((CharSequence) Paper.book().read("State"));
        tvInfo.setText((CharSequence) Paper.book().read("Info"));
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(FinalActivity.this, Details.class);
                startActivity(intent);
            }
        });


    }

    private void init() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvContactNumber = (TextView) findViewById(R.id.tvContactNumber);
        tvPin = (TextView) findViewById(R.id.tvPin);
        tvState = (TextView) findViewById(R.id.tvState);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        btnContinue = (Button) findViewById(R.id.btnContinue);
    }
}
