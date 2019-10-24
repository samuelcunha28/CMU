package pt.ipp.estg.gcf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText fno;
    private EditText sno;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fno = (EditText) findViewById(R.id.firstno);
        sno = (EditText) findViewById(R.id.secondno);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        boolean a = TextUtils.isEmpty(fno.getText()); // checks if the textview doesn't have any text inside
        boolean b = TextUtils.isEmpty(sno.getText());

        if (!a & !b) { // making sure that both text fields are not empty

            int firstnumber = Integer.parseInt(fno.getText().toString());
            int secondnumber = Integer.parseInt(sno.getText().toString());

            Intent intent = new Intent(this, Calculate.class);
            Bundle bundle = new Bundle(); // store data
            bundle.putInt("fno", firstnumber);
            bundle.putInt("sno", secondnumber);
            intent.putExtra("gcfdata", bundle);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        fno.setText("");
        sno.setText("");
    }
}
