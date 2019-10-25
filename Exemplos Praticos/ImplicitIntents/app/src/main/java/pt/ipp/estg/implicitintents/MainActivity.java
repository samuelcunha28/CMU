package pt.ipp.estg.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this); // button for web address
        findViewById(R.id.button2).setOnClickListener(this); // button for maps
        findViewById(R.id.button3).setOnClickListener(this); // button for phone number
    }

    @Override
    public void onClick(View v) {
        Uri uri = null;
        Intent intent = null;

        switch (v.getId()) {
            case R.id.button1:
                uri = Uri.parse("http://www.google.com"); // opens web browser and goes to the url displayed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.button2:
                uri = Uri.parse("geo:40.7113399, -74.0263469"); // opens maps and goes to the location displayed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.button3:
                uri = Uri.parse("tel:911941397"); // opens dialer and prints the number displayed
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
             default:
                 Log.i(getClass().getName(), "Cannot resolve button click");
        }
    }
}
