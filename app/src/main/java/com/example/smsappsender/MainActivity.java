package com.example.smsappsender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                SmsManager.getDefault(

                ).sendTextMessage(phone.getText().toString(),null,message.getText().toString(),null,null);
            }
        });

    }
}