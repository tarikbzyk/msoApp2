package com.example.tarikbozyak.prouygulama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Button btnSignIn, btnSignUp;


    DataBaseHelper helper = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // create a instance of SQLite Database


            // Get The Refference Of Buttons
           // btnSignIn = (Button) findViewById(R.id.buttonGiris);
           // btnSignUp = (Button) findViewById(R.id.buttonKaydol);

            // Set OnClick Listener on SignUp button

        }

    }
    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.buttonGiris) {
            EditText a=(EditText)findViewById(R.id.editTextUserName);
            String str = a.getText().toString();
            EditText b= (EditText)findViewById(R.id.editTextPassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
           if(pass.equals(password)){
                Intent intentGiris = new Intent(getApplicationContext(), Menu.class);
                startActivity(intentGiris);
            }
            else{
                Toast temp=Toast.makeText(MainActivity.this, "Kullanıcı Adı ve Şifre eşleşmedi.", Toast.LENGTH_SHORT);
                temp.show();
            }


        }

        if(v.getId()==R.id.buttonKaydol){

            Intent intentKaydol = new Intent(getApplicationContext(), Kullanici.class);
            startActivity(intentKaydol);
        }
    }

}
