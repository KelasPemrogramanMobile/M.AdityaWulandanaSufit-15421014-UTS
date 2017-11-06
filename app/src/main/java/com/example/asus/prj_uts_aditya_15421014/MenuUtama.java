package com.example.asus.prj_uts_aditya_15421014;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuUtama extends AppCompatActivity {

    EditText edNama,edNpm,edTugas,edQuis,edUts,edUas;
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        edNama  = (EditText) findViewById(R.id.edNama);
        edNpm   = (EditText) findViewById(R.id.edNpm);
        edTugas = (EditText) findViewById(R.id.edTugas);
        edQuis  = (EditText) findViewById(R.id.edQuis);
        edUts   = (EditText) findViewById(R.id.edUts);
        edUas   = (EditText) findViewById(R.id.edUas);

        btnProses = (Button) findViewById(R.id.btnProses);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edNama.getText().toString();
                String npm = edNpm.getText().toString();
                double tugas = Double.parseDouble(edTugas.getText().toString());
                double quis = Double.parseDouble(edQuis.getText().toString());
                double uts = Double.parseDouble(edUts.getText().toString());
                double uas = Double.parseDouble(edUas.getText().toString());
                double nilaiAkhir = (0.15 * tugas) + (0.20 * quis) + (0.30 * uts) + (0.35 * uas);

                String grade;
                String keterangan;
                if (nilaiAkhir >= 85 && nilaiAkhir <= 100) {
                    grade = "A";
                    keterangan = "Lulus";
                } else if (nilaiAkhir > 75 && nilaiAkhir < 85) {
                    grade = "B";
                    keterangan = "Lulus";
                } else if (nilaiAkhir > 65 && nilaiAkhir < 75) {
                    grade = "C";
                    keterangan = "Lulus";
                } else if (nilaiAkhir > 50 && nilaiAkhir < 65) {
                    grade = "D";
                    keterangan = "Tidak Lulus";
                } else {
                    grade = "E";
                    keterangan = "Tidak Lulus";
                }

                Intent next = new Intent(MenuUtama.this, LihatNilai.class);
                next.putExtra("nama", nama);
                next.putExtra("npm", npm);
                next.putExtra("nilai", String.valueOf(nilaiAkhir));
                next.putExtra("grade", grade);
                next.putExtra("keterangan", keterangan);
                startActivity(next);
                finish();
            }
        });
    }
}