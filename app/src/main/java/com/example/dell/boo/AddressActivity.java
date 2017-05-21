package com.example.dell.boo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.paperdb.Paper;

public class AddressActivity extends AppCompatActivity {

    private EditText etName, etPhoneNumber, etAddress, etPin, etState;
    private Button btnProceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        init();
        Paper.init(this);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (check()) {
                    Toast.makeText(getBaseContext(), "Sucess", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddressActivity.this, FinalActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    /**
     * initilization
     */
    private void init() {
        btnProceed = (Button) findViewById(R.id.btnProceedTocheckout);
        etName = (EditText) findViewById(R.id.edit_text_Name);
        etPhoneNumber = (EditText) findViewById(R.id.edit_text_contact_number);
        etAddress = (EditText) findViewById(R.id.edit_text_Address);
        etPin = (EditText) findViewById(R.id.edit_text_pin);
        etState = (EditText) findViewById(R.id.edit_text_State);
    }

    /**
     * check
     */
    private boolean check() {
        String mName, mPhoneNumber, mAddress, mPin, mState;
        mName = etName.getText().toString();
        mPhoneNumber = etPhoneNumber.getText().toString();
        mAddress = etAddress.getText().toString();
        mPin = etPin.getText().toString();
        mState = etState.getText().toString();
        if (mName.isEmpty() || mPhoneNumber.isEmpty() || mAddress.isEmpty() || mPin.isEmpty() || mState.isEmpty()) {
            Toast.makeText(getBaseContext(), "All fields are required.", Toast.LENGTH_LONG).show();
            return false;
        } else {
            Paper.book().write("UserName", mName);
            Paper.book().write("PhoneNumber", mPhoneNumber);
            Paper.book().write("Address", mAddress);
            Paper.book().write("Pin", mPin);
            Paper.book().write("State", mState);
            return true;
        }

    }

}
