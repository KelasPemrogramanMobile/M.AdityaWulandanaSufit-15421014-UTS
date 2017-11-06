package com.example.asus.prj_uts_aditya_15421014;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LihatNilai extends AppCompatActivity {

    EditText edNama,edNpm,edGrade,edKeterangan,edNilaiAkhir;
    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_nilai);

        Intent intent = getIntent();
        edNama = (EditText) findViewById(R.id.edNama);
        edNpm  = (EditText) findViewById(R.id.edNpm);
        edGrade= (EditText) findViewById(R.id.edGrade);
        edKeterangan = (EditText) findViewById(R.id.edKeterangan);
        edNilaiAkhir = (EditText) findViewById(R.id.edNilai);
        btnKembali   = (Button) findViewById(R.id.btnKembali);

        String nama = intent.getStringExtra("nama");
        String npm  = intent.getStringExtra("npm");
        String grade= intent.getStringExtra("grade");
        String keterangan = intent.getStringExtra("keterangan");
        String nilai = intent.getStringExtra("nilai");

        edNama.setText(nama);
        edNpm.setText(npm);
        edGrade.setText(grade);
        edKeterangan.setText(keterangan);
        edNilaiAkhir.setText(nilai);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(LihatNilai.this, MenuUtama.class);
                startActivity(back);
                finish();
            }
        });

    }
}
