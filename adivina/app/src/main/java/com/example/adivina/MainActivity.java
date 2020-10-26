package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int numero = (int)(Math.random()*100);
    TextView adivinacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView adivinacion = (TextView) findViewById((R.id.mensaje));
    }

    public void comprobar(View view) throws InterruptedException {
        EditText number = (EditText) findViewById(R.id.numero);
        int num = Integer.parseInt(number.getText().toString());
        if (num < numero){
            adivinacion = (TextView) findViewById((R.id.mensaje));
            //Thread.sleep(1000);

            adivinacion.setText("Fallaste!");
            adivinacion.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        adivinacion.setText("Prueba con uno mayor");

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 1000);


        }else if (num > numero){
            adivinacion = (TextView) findViewById((R.id.mensaje));
            //Thread.sleep(1000);

            adivinacion.setText("Fallaste!");
            adivinacion.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        adivinacion.setText("Prueba con uno menor");

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 1000);
        }else if (num == numero){
            TextView adivinacion = (TextView) findViewById((R.id.mensaje));
            adivinacion.setText("YAHOOO HAS ACERTADO MAQUINA FIERA MASTODONTE");
        }
    }
}