package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static android.widget.Toast.*;

public class ContactoActivity extends AppCompatActivity {

    TextView etNombre;
    TextView etEmail;
    EditText etMensaje;
    Button btnEnviarMensaje;
    String correo;
    String contrasena;
    javax.mail.Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etMensaje = findViewById(R.id.etMensaje);
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviarMensaje = findViewById(R.id.btnEnviarMensaje);

        Toolbar toolbar_contacto = findViewById(R.id.toolbar_contacto);
        setSupportActionBar(toolbar_contacto);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        correo = "petagram.ejemplo@gmail.com";
        contrasena = "petagram";

        btnEnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try {
                    session = javax.mail.Session.getDefaultInstance(properties, new Authenticator(){
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasena);
                        }
                    });

                    if(session != null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Petagram javamail");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("r.rovira08@gmail.com"));
                        message.setContent("NOMBRE: " + etNombre.getText().toString() + " | EMAIL: " + etEmail.getText().toString()  + " | MENSAJE: " + etMensaje.getText().toString(),
                                "text/html; charset=utf-8");
                        Transport.send(message);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(getBaseContext()
                        ,getResources().getString(R.string.toast_email), LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                Intent i = new Intent(this, FavoritosActivity.class);
                startActivity(i);
                break;
            case R.id.mContacto:
                Intent intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intento = new Intent(this, AcercaDeActivity.class);
                startActivity(intento);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}