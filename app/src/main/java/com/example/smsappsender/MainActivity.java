package com.example.smsappsender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    //Pptés qui vont faire le lien
    private EditText phone;
    //cet EditText elt va nous permet de recuperer le num tel
    private EditText message;
    //cet EditText elt va nous permet de recuperer le msg a envoyer
    private Button envoi ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }
    /*
    initiatizations
     */
    private void initActivity(){
        //recuperation objs graphiques(faire le lien avec les objs graphiques)
        phone= (EditText)findViewById(R.id.txtPhone);
        message= (EditText)findViewById(R.id.txtMessage);
        envoi=(Button)findViewById(R.id.btnSend);
        //gestion de  l evt clic sur le btn envoi
        createOnClickEnvoiButton();

    }

    /**
     * maintenant on gere l evt du clic sur le bouton
     * clic sur le btn envoi : encoi SMS
     */
    private void createOnClickEnvoiButton(){
        envoi.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                //controler si la permission est OK
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {
                    SmsManager.getDefault(

                    ).sendTextMessage(phone.getText().toString(), null, message.getText().toString(), null, null);
                //msg pour informer l'utilisateur que l sms est envoyé avec succes
                    Toast.makeText(MainActivity.this,"SMS envoyé avec succes",Toast.LENGTH_SHORT).show();
                 //vider le txt
                 message.setText("");
                }else{
                    //demande de donner la permission
                    if(!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.SEND_SMS)){
                        String[] permissions={Manifest.permission.SEND_SMS};
                        //afficher la demande de permission
                       ActivityCompat.requestPermissions(MainActivity.this,permissions,2);

                    }else{
                        //afficher que la permission est obligatoire
                    }
                }
            }
        });

    }
}