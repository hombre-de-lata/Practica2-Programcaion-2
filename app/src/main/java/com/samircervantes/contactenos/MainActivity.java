package com.samircervantes.contactenos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_mail, et_telefono, et_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mail = (EditText)findViewById(R.id.txt_mail);
        et_telefono = (EditText)findViewById(R.id.txt_telefono);
        et_mensaje = (EditText)findViewById(R.id.txt_mensaje);
    }
    //Metodo para el boton guardar
    public void  Guardar (View view){
        String mail = et_mail.getText().toString();
        String telefono = et_telefono.getText().toString();
        String mensaje = et_mensaje.getText().toString();

        SharedPreferences preferencias =getSharedPreferences("agenda", Context. MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(mail,telefono);
        obj_editor.commit();

        Toast.makeText(this, "El usuario ha sido guardado", Toast.LENGTH_SHORT).show();

    }


    //Metodo para el boton Buscar
    public void Buscar(View view){
        String mail = et_mail.getText().toString();

        SharedPreferences preferencias =getSharedPreferences("agenda", Context .MODE_PRIVATE);
        String telefono =preferencias.getString(mail,"");
        if(mail.length() == 0){
            Toast.makeText(this, "No se encontro ningun E-mail", Toast.LENGTH_SHORT).show();

        }else{

            et_telefono.setText(telefono);

        }
    }
}