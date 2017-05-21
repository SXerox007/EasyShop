package com.example.dell.boo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.paperdb.Paper;

public class AddToCart extends AppCompatActivity {

    private TextView tvName, tvPlace, tvInfo, tvPrice;
    private Button btnBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        init();
        setData();
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(AddToCart.this, AddressActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * initilization
     */
    private void init() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvPlace = (TextView) findViewById(R.id.tvLocation);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        btnBuyNow = (Button) findViewById(R.id.btnBuy);
    }

    /**
     * set date
     */
    private void setData() {
        tvName.setText((CharSequence) Paper.book().read("Name"));
        tvPlace.setText((CharSequence) Paper.book().read("Location"));
        tvInfo.setText((CharSequence) Paper.book().read("Info"));
        tvPrice.setText((CharSequence) Paper.book().read("Price"));
    }
}
