package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class LabTestBookActivity extends AppCompatActivity {
    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edname=findViewById(R.id.editTextLTBFullName);
        edaddress=findViewById(R.id.editTextLTBAdress);
        edcontact=findViewById(R.id.editTextLTBContactNumber);
        edpincode=findViewById(R.id.editTextLTBPinCode);
        btnBooking=findViewById(R.id.buttonLTBBooking);
        Intent intent=getIntent();
        String[] price = intent.getStringArrayExtra("price");
        if (price != null) {
            String priceString = Arrays.toString(price); // Convert the array to a string if it's not null
            String[] priceArray = priceString.split(java.util.regex.Pattern.quote(":"));
            
        }

        String date =intent.getStringExtra("date");
        String time =intent.getStringExtra("time");





       btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(),
                        edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()),
                        date.toString(), time.toString(), 999, "lab");
                db.removeCart(username, "lab");

                startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));

            }


        });

    }
}