package pt.ipp.estg.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static pt.ipp.estg.activities.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        if (getIntent().hasExtra(EXTRA_MESSAGE)) {
            Intent intent = getIntent();
            String message = intent.getStringExtra(EXTRA_MESSAGE);
            TextView textView2 = findViewById(R.id.textView2);
            textView2.setText(message);
        }
    }
}
