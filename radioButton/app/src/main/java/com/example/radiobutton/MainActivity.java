package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  aceptar(View view){
        RadioGroup radiogrupo = (RadioGroup)findViewById(R.id.radiogrupo);
        int seleccion = radiogrupo.getCheckedRadioButtonId();
        RadioButton checked = (RadioButton)findViewById(seleccion);
        TextView texto = (TextView)findViewById(R.id.texto);
        texto.setText(checked.getContentDescription());
    }
}