package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class input_mhs extends AppCompatActivity {
    Button btnsave,btnView;
    EditText xnim,xnama;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_mhs);
        xnim=findViewById(R.id.nimmhs);
        xnama=findViewById(R.id.namamhs);

        btnView=findViewById(R.id.tombol_view);

        dbh=new DatabaseHelper(this);

        btnsave=findViewById(R.id.tombolsimpan);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh.tambah_data(xnim.getText().toString(),xnama.getText().toString());
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(input_mhs.this,MainActivity.class);
                startActivity(it);
            }
        });

    }
}