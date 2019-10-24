package pt.ipp.estg.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int numberToGuess = 0;
    EditText e;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Is initialized during onCreate but it was declared as a member variable
         * and not as a local variable of onCreate
         * We need to reference this variable from the onClick method
         * That's the reason it was declared as a member variable
         */
        numberToGuess = initNumberToGuess();

        /** These variables are also initialized here but declared as members as well
         * Like numberToGuess. we need to reference this variable from the onClick method
         */
        e = (EditText) findViewById(R.id.editText);
        t = (TextView) findViewById(R.id.textView);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // convert the return value of getText to String
        int number = Integer.parseInt(e.getText().toString());
        if (number == numberToGuess) {
            t.setText(number + " is the right number");
        } else if (number < numberToGuess) {
            t.setText("Guess higher");
        } else {
            t.setText("Guess Lower");
        }
        Log.i("Samuel",numberToGuess + "");
    }

    int initNumberToGuess() {
        Random r = new Random(); // random number
        numberToGuess = r.nextInt(100) + 50; // range of number
        Log.i("Samuel", numberToGuess + "");
        return numberToGuess;
    }
}
