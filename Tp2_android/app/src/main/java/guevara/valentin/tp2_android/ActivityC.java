package guevara.valentin.tp2_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        final Intent intent = getIntent();
        HashMap<String,String> infos = (HashMap<String, String>) intent.getSerializableExtra("infos");
        TextView nom = (TextView) findViewById(R.id.nom);
        TextView prenom = (TextView) findViewById(R.id.prenom);
        TextView age = (TextView) findViewById(R.id.age);
        TextView numero = (TextView) findViewById(R.id.numero);
        TextView mail = (TextView) findViewById(R.id.mail);
        Button valid = (Button) findViewById(R.id.valider);

        nom.setText(infos.get("nom"));
        prenom.setText(infos.get("prenom"));
        age.setText(infos.get("dateNaiss"));
        numero.setText(infos.get("numero"));
        mail.setText(infos.get("mail"));

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
