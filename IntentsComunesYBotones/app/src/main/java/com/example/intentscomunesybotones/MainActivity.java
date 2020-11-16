package com.example.intentscomunesybotones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView crono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crono = (TextView)findViewById(R.id.crono);
        crono.setText("00:00:000");
    }

    public  void web (View view){
        Uri uri = Uri.parse("https://www.palomafp.org/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void llamar (View view){
        Uri uri = Uri.parse("tel:629043960");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void mapa (View view){
        Uri uri = Uri.parse("geo:40.4596813,-3.7172108");
        Intent intent =new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void mail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"pepepezpelagatos@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "holaesperoquefuncione");
        intent.putExtra(Intent.EXTRA_TEXT, "slkdchjklxhzvkzjxhvcx");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void agenda(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
    public void camara(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {//este if es para que no pete
            startActivityForResult(intent, 0);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
        int min=0,seg=0,mili=0;
        Thread hilo;
        Boolean encendido = false;

        public void iniciarCrono(View view) {
            Button iniciar = (Button)findViewById(R.id.iniciar);
            Button reiniciar = (Button)findViewById(R.id.reiniciar);

            if (iniciar.getText().equals("Iniciar"))
            {
                //-----------------------INICIAMOS EL CRONO
                encendido = true;
                hiloCrono(view);

                iniciar.setText("Parar");
            }
            else
            {
                //-----------------------PARAMOS EL CRONO
                encendido = false;

                reiniciar.setEnabled(true);
                iniciar.setEnabled(false);
            }

        }

        public void reiniciarCrono(View view)
        {
            crono = (TextView)findViewById(R.id.crono);

            Button iniciar = (Button)findViewById(R.id.iniciar);
            Button reiniciar = (Button)findViewById(R.id.reiniciar);

            //-----------------------INICIAMOS EL CRONO
            encendido = true;

            min=0;
            seg=0;
            mili=0;
            crono.setText("00:00:000");

            hiloCrono(view);
            iniciar.setEnabled(true); //text en modo PARAR
            reiniciar.setEnabled(false);
        }

        Handler h = new Handler(); // sirve para modificar el textview

        private void hiloCrono(View view) {

            hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){ // while infinito
                        if(encendido){ // se activa la variable encendido si se presiona el boton iniciar
                            try {
                                Thread.sleep(1);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            mili++;
                            if(mili >= 999){
                                seg++;
                                mili=0;
                            }if(seg>=59){
                                min++;
                                seg=0;
                            }
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    String m="",s="",mi="";
                                    if(mili<10){ //Modificar la variacion de los 0
                                        m="00"+mili;
                                    }else if (mili<=100){
                                        m="0"+mili;
                                    }else{
                                        m=""+mili;
                                    }
                                    if (seg<=10){
                                        s="0"+seg;
                                    }else{
                                        s=""+seg;
                                    }
                                    if(min<=10){
                                        mi="0"+min;
                                    }else{
                                        mi=""+min;
                                    }
                                    crono.setText(mi+":"+s+":"+m);
                                }
                            });
                        }
                    }
                }
            });
            hilo.start();
        }

}