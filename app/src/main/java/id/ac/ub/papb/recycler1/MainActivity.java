package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv1;
    MahasiswaAdapter adapter;
    ArrayList<Mahasiswa> data;
    public static String TAG = "RV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);
        data = getData();
        adapter = new MahasiswaAdapter(this, data);

        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));

        Button saveButton = findViewById(R.id.bt1);
        saveButton.setOnClickListener(view -> {
            String nim = ((EditText) findViewById(R.id.etNim)).getText().toString();
            String nama = ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString();

            if (!nim.isEmpty() && !nama.isEmpty()) {
                Mahasiswa newMhs = new Mahasiswa();
                newMhs.nim = nim;
                newMhs.nama = nama;

                adapter.addItem(newMhs);

                ((EditText) findViewById(R.id.etNim)).setText("");
                ((EditText) findViewById(R.id.editTextTextPersonName2)).setText("");
            } else {
                Log.d(TAG, "NIM atau Nama tidak boleh kosong");
            }
        });
    }

    public ArrayList<Mahasiswa> getData() {
        ArrayList<Mahasiswa> data = new ArrayList<>();
        Mahasiswa mhs1 = new Mahasiswa();
        mhs1.nim = "123456";
        mhs1.nama = "Tiara";
        data.add(mhs1);

        return data;
    }
}