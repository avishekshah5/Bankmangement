package com.avh.class1;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signupactivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText name,password,email,address,phone;
    RadioGroup gender;
    DatePicker dob;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        databaseHelper=new DatabaseHelper(this);
        name=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        email=(EditText) findViewById(R.id.email1);
        address=(EditText) findViewById(R.id.address1);
        phone=(EditText) findViewById(R.id.phone1);
        register=(Button) findViewById(R.id.register);
        gender=(RadioGroup)findViewById(R.id.gender);
        dob=(DatePicker)findViewById(R.id.dob1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(signupactivity.this,menu_activity.class);
                String namevalue=name.getText().toString();
                String passwordvalue =password.getText().toString();
                String emailvalue=email.getText().toString();
                String addressvalue=address.getText().toString();
                String phonevalue=phone.getText().toString();

                RadioButton checkedRB=(RadioButton) findViewById(gender.getCheckedRadioButtonId());
                String gendervalue=checkedRB.getText().toString();
                String dobvalue=dob.getYear()+"-"+dob.getMonth()+"-"+dob.getDayOfMonth();

                ContentValues cv=new ContentValues();
                cv.put("username",namevalue);
                cv.put("password",passwordvalue);
                cv.put("email",emailvalue);
                cv.put("address",addressvalue);
                cv.put("phone",phonevalue);
                cv.put("gender",gendervalue);
                cv.put("dob",dobvalue);
                databaseHelper.insertUser(cv);
                Toast.makeText(signupactivity.this,"User info inserted Sign up completed",Toast.LENGTH_LONG).show();


                startActivity(intent1);


            }
        });
         
    }
}
