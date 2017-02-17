package guevara.valentin.tp2_android;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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

import static guevara.valentin.tp2_android.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    Calendar myCalendar = Calendar.getInstance();
    EditText dateNaiss;
    RadioButton masc,fem;
    EditText nom,prenom,numero,mail;
    Button valid;

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

        String myFormat = "dd/MM/yy"; //In which you need put here
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
                if((!masc.isChecked() && !fem.isChecked()) || nom.getText().toString() == "" || prenom.getText().toString() == "" || dateNaiss.getText().toString() == "" || mail.getText().toString() == ""){
                    //nom.setText(prenom.getText().toString());
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Remplir tous les champs")
                            .setMessage("Il est impossible de laisser des champs vides")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else{

                }
            }
        });
    }
}
