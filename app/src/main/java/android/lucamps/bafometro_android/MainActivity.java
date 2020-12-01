package android.lucamps.bafometro_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 100;

    private double peso;
    private int copos;
    private String sexo;
    private String jejum;

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
                copos = Integer.parseInt(editTextCopos.getText().toString());
                jejum = editTextJejum.getText().toString();
                sexo = editTextSexo.getText().toString();

                Intent it = new Intent(getBaseContext(), SecondActivity.class);
                it.putExtra("peso", peso);
                it.putExtra("sexo", sexo);
                it.putExtra("copos", copos);
                it.putExtra("jejum", jejum);
                startActivityForResult(it, REQUEST_CODE);
            }
            catch (NumberFormatException e){
                Toast.makeText(this,"Favor preencha os campos numéricos",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) {
            Log.i("Activity_Result", "nenhuma Intent recebida.");
        }
        else if(requestCode == REQUEST_CODE){

            final double taxaAlc = data.getDoubleExtra("taxaAlc",0.0);
            final boolean alcoolizada = data.getBooleanExtra("alcoolizada",false);

            if(resultCode == 1){
                Log.i("Activity_Result", "código para exibit Toast recebido.");
                if(alcoolizada)
                    Toast.makeText(this, "Taxa de Alcoolemia: " + taxaAlc + "\nClassificação: Pessoa Alcoolizada", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, "Taxa de Alcoolemia: " + taxaAlc + "\nClassificação: Pessoa NÃO Alcoolizada", Toast.LENGTH_LONG).show();
            }
            else{
                Log.i("Activity_Result", "código de resultado inválido.");
            }
        }

    }
}