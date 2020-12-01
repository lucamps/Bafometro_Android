package android.lucamps.bafometro_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Double peso;
    String sexo;
    int copos;
    String jejum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextPeso = findViewById(R.id.editTextPeso);
        EditText editTextSexo = findViewById(R.id.editTextSexo);
        EditText editTextCopos = findViewById(R.id.editTextCopos);
        EditText editTextJejum = findViewById(R.id.editTextJejum);
        Button buttonEnviar = findViewById(R.id.buttonEnviarDados);

        buttonEnviar.setOnClickListener(view -> {
            try {
                peso = Double.parseDouble(editTextPeso.getText().toString());
                copos = Integer.getInteger(editTextCopos.getText().toString(),0);
                jejum = editTextJejum.getText().toString();
                sexo = editTextSexo.getText().toString();

                Intent it = new Intent(getBaseContext(), SecondActivity.class);
                it.putExtra("peso", peso);
                it.putExtra("sexo", sexo);
                it.putExtra("copos", copos);
                it.putExtra("jejum", jejum);
                startActivity(it);
            }
            catch (NumberFormatException e){
                Toast.makeText(this,"Favor preencha os campos numéricos",Toast.LENGTH_LONG).show();
            }

        });
    }
}