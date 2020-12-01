package android.lucamps.bafometro_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    double getCoeficiente(String jejum, String sexo){
        if(jejum.equals("s") || jejum.equals("S")){
            if(sexo.equals("m") || sexo.equals("M"))
                return 0.7;
            else
                return 0.6;
        }
        return 1.1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Intent it = getIntent();

        final double peso = it.getDoubleExtra("peso",1.0);
        final String sexo = it.getStringExtra("sexo");
        final int copos = it.getIntExtra("copos",0);
        final String jejum = it.getStringExtra("jejum");

        Button buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(view -> {
            double taxaAlc = (copos * 4.8) / (peso * getCoeficiente(jejum,sexo) );
            boolean alcoolizada = false;

            if(taxaAlc > 0.2)
                alcoolizada = true;

            Intent itResult = new Intent();

            itResult.putExtra("taxaAlc",taxaAlc);
            itResult.putExtra("alcoolizada",alcoolizada);

            setResult(1, itResult);

            finish();
        });
    }
}