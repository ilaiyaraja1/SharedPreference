package com.example.ilaiyaraja.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button logout;
    EditText editText_name,editText_email;
    Button button_save;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       TextView editView_email=findViewById(R.id.editView_email);
        TextView textView_name=findViewById(R.id.textView_name);

        logout=findViewById(R.id.button_logout);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);

        if (name!=null||email!=null){

            textView_name.setText("Full Name -"+name);
            editView_email.setText("Email id -"+email);

        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(MainActivity2.this,"logout",Toast.LENGTH_LONG).show();

            }
        });

    }
}