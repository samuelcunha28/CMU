package pt.ipp.estg.firstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView TextViewResultado = findViewById(R.id.TextViewResultado);
        final EditText colocarNumero = findViewById(R.id.colocarNumero);
        Button verificaBtn = findViewById(R.id.verificaBtn);

        verificaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText primeiroNumero = (EditText) findViewById(R.id.primeiroNumero);
                EditText segundoNumero = (EditText) findViewById(R.id.segundoNumero);


                int num1 = Integer.parseInt(primeiroNumero.getText().toString());
                int num2 = Integer.parseInt(segundoNumero.getText().toString());
                int resultado = num1 + num2;
                int numero = Integer.parseInt(colocarNumero.getText().toString());

                if (resultado == numero ) {
                    TextViewResultado.setText("O Resultado está correto!");
                } else {
                    TextViewResultado.setText("O Resultado está incorreto!");
                }
            }
        });
    }
}
