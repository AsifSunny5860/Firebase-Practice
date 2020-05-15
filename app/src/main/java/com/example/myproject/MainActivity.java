package com.example.myproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText editTextCountryCode, editTextPhone,FirstnameET,LastnameET;
    ImageView logoIV;
    CheckBox AcceptCB;
    Button buttonContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoIV=findViewById(R.id.logoIV);
        FirstnameET = findViewById(R.id.FirstnameET);
        LastnameET = findViewById(R.id.LastnameET);
        AcceptCB = findViewById(R.id.AcceptCB);
        editTextCountryCode = findViewById(R.id.editTextCountryCode);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonContinue = findViewById(R.id.buttonContinue);

        AcceptCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (AcceptCB.isChecked()){
                    buttonContinue.setVisibility(View.VISIBLE);
                }else {
                    buttonContinue.setVisibility(View.GONE);
                }
            }
        });

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Firstname=FirstnameET.getText().toString().trim();
                String Lastname=LastnameET.getText().toString().trim();
                String code = editTextCountryCode.getText().toString().trim();
                String number = editTextPhone.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10 ) {
                    editTextPhone.setError("Valid number is required");
                    editTextPhone.requestFocus();
                    return;
                }else if (FirstnameET==null){
                    FirstnameET.setError("First name is required");
                    FirstnameET.requestFocus();
                    return;
                }else if (LastnameET==null) {
                    LastnameET.setError("Last name is required");
                    LastnameET.requestFocus();
                    return;
                }


                String phoneNumber = code + number;
                String Name= Firstname + " " + Lastname;

                Intent intent = new Intent(MainActivity.this, VerifyActivity.class);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

    }
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }
}
