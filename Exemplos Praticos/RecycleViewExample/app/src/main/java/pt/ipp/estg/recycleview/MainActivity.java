package pt.ipp.estg.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create contact list
        //List<Contact> contacts = createContactsList(200);

        // Create contacts adapter
        //mAdapter = new ContactAdapter(this, Contact);

        // Set RecyclerView adapter
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        // Set LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
