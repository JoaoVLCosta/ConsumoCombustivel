package br.edu.fateczl.consumocombustivel;

import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private EditText etInd;
    private EditText etComb;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etInd = findViewById(R.id.etInd);
        etInd.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        etComb = findViewById(R.id.etComb);
        etComb.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btCalc = findViewById(R.id.btCalc);
        btCalc.setOnClickListener(op -> calcular());
    }

    private void calcular(){
        float indice = Float.parseFloat(etInd.getText().toString());
        float tanque = Float.parseFloat(etComb.getText().toString());

        String resultado = getString(R.string.resultado) + "\n" + (indice*1000*tanque) + " m";

        tvRes.setText(resultado);
    }

}