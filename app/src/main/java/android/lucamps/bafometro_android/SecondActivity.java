package android.lucamps.bafometro_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Intent it = getIntent();

        final Double peso = it.getDoubleExtra("peso",1.0);
        final String sexo = it.getStringExtra("sexo");
        final int copos = it.getIntExtra("copos",0);
        final String jejum = it.getStringExtra("jejum");

        Toast.makeText(this, "Peso: " + peso + ", sexo: "
                + sexo + ", copos: " + copos +", jejum: " + jejum , Toast.LENGTH_LONG).show();

    }
}