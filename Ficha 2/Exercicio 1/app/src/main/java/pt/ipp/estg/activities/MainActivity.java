package pt.ipp.estg.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "pt.ipp.estg.activities";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_toast = (Button) findViewById(R.id.button1);
        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });


        Button button_intent = (Button) findViewById(R.id.button2);
        button_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Faz alguma coisa em resposta ao botão
                Intent startIntent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();

                // mostrar como passar informação para outra atividade
                startIntent.putExtra(EXTRA_MESSAGE, message);
                startActivity(startIntent);
            }
        });
    }
}
