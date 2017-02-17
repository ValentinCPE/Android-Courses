package guevara.valentin.introduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt;
    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.button);
        t = (TextView) findViewById(R.id.textView);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Click performed");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "Restart");
    }
}
