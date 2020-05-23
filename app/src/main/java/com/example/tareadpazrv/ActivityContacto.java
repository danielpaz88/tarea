package com.example.tareadpazrv;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContacto extends AppCompatActivity {
    String correo; String contrasena;
    EditText txtNombre3; Button btnEnviarMensaje;EditText txtNombre2;EditText txtNombre1;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        txtNombre1=(EditText) findViewById(R.id.txtNombre1);
        txtNombre2=(EditText) findViewById(R.id.txtNombre2);
        txtNombre3=(EditText) findViewById(R.id.txtNombre3);
        btnEnviarMensaje=(Button) findViewById(R.id.btnEnviarMensaje);
        /* Acá debajo debe colocar el email suyo, con el que va a enviar el mensaje. También deberá escribir su contraseña.
        * Deberá ser una cuenta de GMAIL la suya.
        * En esa cuenta suya, deberá ir a administrar cuenta, en la opción "Less secure app access" o "Permitir el acceso de aplicaciones menos seguras"
        * y darle ON*/
        correo="@gmail.com";
        contrasena="";
        btnEnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties =new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");
                
                try{
                     session=Session.getDefaultInstance(properties, new Authenticator() {
                         @Override
                         protected PasswordAuthentication getPasswordAuthentication() {
                             return new PasswordAuthentication(correo,contrasena);
                         }
                     });
                     if(session!=null){
                         Message message=new MimeMessage(session);
                         message.setFrom(new InternetAddress(correo));
                         message.setSubject(txtNombre1.getText().toString());
                         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(txtNombre2.getText().toString()));
                         message.setContent(txtNombre3.getText().toString(),"text/html;charset=utf-8");
                         Transport.send(message);
                     }
                }catch(Exception e){e.printStackTrace();}
            }
        });
    }
}
