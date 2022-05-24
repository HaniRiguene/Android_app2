package com.example.myapplication91;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication91.R;

public class MainActivity extends Activity {
    public static final String PROTOCOLE = "http";
    public static final String SERVEUR = "10.0.2.2";
    public static final String PORT = "80";
    public static final String PAGE = "index.html";
    private EditText edProtocole;
    private EditText edServeur;
    private EditText edPort;
    private EditText edPage;
    private Button btnEnregistrer;
    private Button btnAfficher;
    private Button btnEffacer;
    private Button btnParamUsine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        edProtocole = (EditText) findViewById(R.id.edProtocole);
        edServeur = (EditText) findViewById(R.id.edServeur);
        edPort = (EditText) findViewById(R.id.edPort);
        edPage = (EditText) findViewById(R.id.edPage);
        btnEnregistrer = (Button) findViewById(R.id.btnEnregistrer);
        btnAfficher = (Button) findViewById(R.id.btnAfficher);
        btnEffacer = (Button) findViewById(R.id.btnEffacer);
        btnParamUsine = (Button) findViewById(R.id.btnParamUsine);
        ajouterEcouteur();

    }

    private void ajouterEcouteur() {
   btnEnregistrer.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           enregister();
       }
   });
   btnAfficher.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           afficher();
       }
   });
   btnEffacer.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           effacer();
       }
   });
   btnParamUsine.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           paramusine();
       }
   });
    }

    private void effacer() {
        edProtocole.setText("");
        edServeur.setText("");
        edPort.setText("");
        edPage.setText("");
    }

    private void paramusine() {
        edProtocole.setText(""+PROTOCOLE);
        edServeur.setText(""+SERVEUR);
        edPort.setText(""+PORT);
        edPage.setText(""+PAGE);
    }

    private void afficher() {
        String a=edProtocole.getText().toString();
        String b=edServeur.getText().toString();
        String c=edPort.getText().toString();
        String d=edPage.getText().toString();
        if (!a.isEmpty() && !b.isEmpty() && !c.isEmpty() && !d.isEmpty()){
            Toast.makeText(this, a+"://"+b+":"+c+"/"+d, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, PROTOCOLE+"://"+SERVEUR+":"+PORT+"/"+PAGE, Toast.LENGTH_LONG).show();
    }

    private void enregister() {
        SharedPreferences p= getSharedPreferences("Réseau",MODE_PRIVATE);
        SharedPreferences.Editor ed=p.edit();
        ed.putString("utilisateur",edProtocole.getText().toString());
        ed.putString("utilisateur",edServeur.getText().toString());
        ed.putString("utilisateur",edPort.getText().toString());
        ed.putString("utilisateur",edPage.getText().toString());
        ed.commit();
    }

}