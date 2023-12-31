package com.example.classification;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classification.gpdao.ClassificationDao;
import com.example.classification.gpdao.Mydatabase;

public class login extends AppCompatActivity {
    EditText username, password;
    TextView reg;
    Button loginbtn;
    Boolean checkuserpass;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        reg = (TextView) findViewById(R.id.reg);

        DB = new DBHelper(this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                     checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(login.this, MainFunctions.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

//                else {
//                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
//                    if (checkuserpass == true) {
//                        Toast.makeText(login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(login.this, MainFunctions.class);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,register.class);
                startActivity(intent);
            }
        });

    }
}