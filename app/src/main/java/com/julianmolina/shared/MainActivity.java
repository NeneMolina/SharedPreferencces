package com.julianmolina.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, cc, tel, user, password;
    Button guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        guardar = findViewById(R.id.Guardar);
        name =findViewById(R.id.TextNombre);
        cc =findViewById(R.id.TextCedula);
        tel =findViewById(R.id.TextTelefono);
        user =findViewById(R.id.TextUsuario);
        password =findViewById(R.id.TextContraseña);


        SharedPreferences preferences = getSharedPreferences("datos_persona", Context.MODE_PRIVATE);
        name.setText(preferences.getString("nombre",""));
        cc.setText(preferences.getString("cedula",""));
        tel.setText(preferences.getString("telefono",""));
        user.setText(preferences.getString("usuario",""));
        password.setText(preferences.getString("pass",""));

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref =getSharedPreferences("datos_persona", Context.MODE_PRIVATE);

                SharedPreferences.Editor ObjetoEditor = pref.edit();
                //Guardamos lo que tenemos en edit text con id usuario
                ObjetoEditor.putString("nombre", name.getText().toString());
                ObjetoEditor.putString("cedula", cc.getText().toString());
                ObjetoEditor.putString("telefono", tel.getText().toString());
                ObjetoEditor.putString("usuario", user.getText().toString());
                ObjetoEditor.putString("pass", password.getText().toString());
                //guardamos los datos
                ObjetoEditor.commit();
                //Terminar la aplicacion
                //finish();
            }
        });

    }
}