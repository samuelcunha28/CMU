package pt.ipp.estg.namelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    EditText et_addname;
    ListView lv_listofnames;

    List<String> friends = new ArrayList<String>();
    String[] startingList = {"Anselmo", "Beatriz", "Carla", "Daniel"};
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        et_addname = findViewById(R.id.et_addname);
        lv_listofnames = findViewById(R.id.lv_listofnames);

        // initialize the list of names
        friends = new ArrayList<String>(Arrays.asList(startingList));
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,friends);
        lv_listofnames.setAdapter(ad);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = et_addname.getText().toString();
                friends.add(newName);
                Collections.sort(friends);
                ad.notifyDataSetChanged();
            }
        });

        // when clicking the names on the list show a toast that texts the position and the name
        // also this click listener could make another things like another activity (another screen)
        lv_listofnames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pos=" + position + " name=" + friends.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }
}
