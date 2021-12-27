package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    ListView listView;
    ArrayList <String> listitem;
    ArrayAdapter adapter;
    Button btninput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh= new DatabaseHelper(this);
        listView =findViewById(R.id.list_data);
        listitem=new ArrayList<>();
        btninput=findViewById(R.id.tombolinput);
      //input data kedalam tablemahasiswa
        /*String nim="A11.2020.13084";
        String nama="Rosalia Natal Silalahi";
        dbh.tambah_data(nim,nama);*/
       //gtampilkan data  mahasiswa
        Cursor cursor = dbh.baca_data();
        listitem.clear();
        while (cursor.moveToNext()){
            listitem.add(cursor.getString(0)+" "+cursor.getString(1));
        }
        adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,listitem);
        listView.setAdapter(adapter);

        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, input_mhs.class);
                startActivity(intent);
            }
        });

    }
}