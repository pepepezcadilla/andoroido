package com.example.casillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkedButton(View view){
        TextView res = (TextView) findViewById(R.id.domingo);
        boolean check= ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkBox1:
                if (check) {
                    Toast.makeText(getApplicationContext(), "Lunes añadido", Toast.LENGTH_SHORT).show();
                    break;
                }
                else break;
            case R.id.checkBox2:
                if (check) {
                Toast.makeText(getApplicationContext(), "Martes añadido", Toast.LENGTH_SHORT).show();
                    break;
                }
                else break;
            case R.id.checkBox3:
                if (check) {
                Toast.makeText(getApplicationContext(), "Miercoles añadido", Toast.LENGTH_SHORT).show();
                    break;
                }
                else break;
            case R.id.checkBox4:
                if (check) {
                Toast.makeText(getApplicationContext(), "Jueves añadido", Toast.LENGTH_SHORT).show();
                    break;
                }
                else break;
            case R.id.checkBox5:
                if (check) {
                Toast.makeText(getApplicationContext(), "Viernes añadido", Toast.LENGTH_SHORT).show();
                    break;
                }
                else break;
            case R.id.checkBox6:
                if (check) {
                Toast.makeText(getApplicationContext(), "Sabado añadido", Toast.LENGTH_SHORT).show();
                    break;
                }
                else break;
            case R.id.checkBox7:
                if (check) {
                Toast.makeText(getApplicationContext(), "Domingo añadido", Toast.LENGTH_SHORT).show();
                    res.setVisibility(View.VISIBLE);
                    break;
                }
                else {
                    res.setVisibility(View.INVISIBLE);
                    break;
                }
        }
    }
}