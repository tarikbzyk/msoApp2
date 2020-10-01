package com.example.tarikbozyak.prouygulama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kullanici extends Activity
{
  //  EditText editTextKayıtUserName,editTextKayıtPassword,editTextConfirmPassword;
    Button btnCreateAccount;


    DataBaseHelper helper = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kx1);



        // Get Refferences of Views
      //  editTextKayıtUserName=(EditText)findViewById(R.id.editTextKayıtKullaniciAdi);
       // editTextKayıtPassword=(EditText)findViewById(R.id.editTextKayıtSifre);
       // editTextConfirmPassword=(EditText)findViewById(R.id.editTextKayıtConfirm);

        btnCreateAccount=(Button)findViewById(R.id.buttonkxKaydol);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                EditText name = (EditText) findViewById(R.id.editTextKayıtAd);
                EditText email = (EditText) findViewById(R.id.editTextKayıtMail);
                EditText uname = (EditText) findViewById(R.id.editTextKayıtKullaniciAdi);
                EditText pass1 = (EditText) findViewById(R.id.editTextKayıtSifre);
                EditText pass2 = (EditText) findViewById(R.id.editTextKayıtConfirm);

                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String unamestr = uname.getText().toString();
                String pass1str = pass1.getText().toString();
                String pass2str = pass2.getText().toString();

                String username1=helper.searchUser();

                if (!pass1str.equals(pass2str)) {

                    //popup mesajı
                    Toast pass = Toast.makeText(Kullanici.this, "Şifreler eşleşmedi.", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else if (unamestr.equals(username1)){

                    Toast pass = Toast.makeText(Kullanici.this, "Kullanıcı adı zaten kullanılıyor.", Toast.LENGTH_SHORT);
                    pass.show();
                }
               else if(pass1str.length()<4){
                    Toast pass = Toast.makeText(Kullanici.this, "Şifre en az 4 karakter içermelidir.", Toast.LENGTH_SHORT);
                    pass.show();

                }
                else if (pass1str.equals("")) {

                    //popup mesajı
                    Toast pass = Toast.makeText(Kullanici.this, "Şifrenizi Girmeyi Unuttunuz", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else if (!emailstr.contains("@")) {

                    //popup mesajı
                    Toast pass = Toast.makeText(Kullanici.this, "Mail Geçerli Değil", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else {
                    Contact c = new Contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setUname(unamestr);
                    c.setPass(pass1str);

                    helper.insertContact(c);

                    Toast kaydol = Toast.makeText(Kullanici.this, "Kayıt tamamlandı.", Toast.LENGTH_SHORT);
                    kaydol.show();


                }

            }
        });

        Button buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Kullanici.this, MainActivity.class);
                startActivities(new Intent[]{i});
            }
        });
    }

}
