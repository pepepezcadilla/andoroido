package com.example.apiminimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textointro = (EditText)findViewById(R.id.introNum);
        String texto =textointro.getText().toString();
        final int num = Integer.parseInt(texto);
        final TextView TextoAMostrar = (TextView) findViewById(R.id.introNum);
        Button btn = (Button) findViewById(R.id.btnAceptar);
        TextoAMostrar.setText(" ");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num <= 1){
                    String aviso = "introduzca un valor superior a 1";
                    TextView TextoAMostrar = (TextView) findViewById(R.id.introNum);
                    TextoAMostrar.setText(aviso);
                }else {
                    int i=0;
                    while (i<= num){
                        if (i%2==0){
                            TextoAMostrar.setText(num+", ");
                        }
                    }
                }
            }
        });
    }
}