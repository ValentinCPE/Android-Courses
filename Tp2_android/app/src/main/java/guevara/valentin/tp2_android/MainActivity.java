package guevara.valentin.tp2_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.HashMap;

import static guevara.valentin.tp2_android.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    Calendar myCalendar = Calendar.getInstance();
    EditText dateNaiss;
    RadioButton masc,fem;
    EditText nom,prenom,numero,mail;
    Button valid;
    HashMap<String,String> mapErreur = new HashMap<>();
    HashMap<String,String> mapInfos = new HashMap<>();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };


    private void updateLabel() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        dateNaiss.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dateNaiss = (EditText) findViewById(R.id.editTextdateNaiss);
        masc = (RadioButton) findViewById(R.id.radioButton);
        fem = (RadioButton) findViewById(R.id.radioButton2);
        nom = (EditText) findViewById(R.id.editText2);
        prenom = (EditText) findViewById(R.id.editText3);
        numero = (EditText) findViewById(R.id.editText4);
        mail =  (EditText) findViewById(R.id.editText5);
        valid = (Button) findViewById(R.id.button);

        dateNaiss.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!masc.isChecked() && !fem.isChecked()){
                    mapErreur.put("genre","Vous devez sélectionner votre sexe");
                }else{
                    if(masc.isChecked()){
                        mapInfos.put("genre", masc.toString());
                    }else{
                        mapInfos.put("genre", fem.toString());
                    }

                }

                if(nom.getText().toString().equals("")){
                    mapErreur.put("nom","Saisir votre nom");
                }else{
                    mapInfos.put("nom", nom.getText().toString());
                }

                if(prenom.getText().toString().equals("")){
                    mapErreur.put("prenom","Saisir votre prenom");
                }else{
                    mapInfos.put("prenom", prenom.getText().toString());
                }

                if(numero.getText().toString().equals("")){
                    mapErreur.put("numero","Numéro obligatoire");
                }else{
                    mapInfos.put("numero", numero.getText().toString());
                }

                if(dateNaiss.getText().toString().equals("")){
                    mapErreur.put("dateNaiss","Quelle est votre date de naissance ?");
                }else{
                    mapInfos.put("dateNaiss", dateNaiss.getText().toString());
                }

                if(mail.getText().toString().equals("")){
                    mapErreur.put("mail","mail nécessaire");
                }else{
                    mapInfos.put("mail", mail.getText().toString());
                }

                if(!mapErreur.isEmpty()){
                    alert();
                }else{
                    Intent myIntent2 = new Intent(MainActivity.this,ActivityC.class);
                    myIntent2.putExtra("infos", mapInfos);
                    startActivity(myIntent2);
                }

            }
        });
    }

    private void alert() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Remplir tous les champs")
                .setMessage("Il est impossible de laisser des champs vides")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(MainActivity.this, ActivityB.class);
                        myIntent.putExtra("erreur", mapErreur);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}
