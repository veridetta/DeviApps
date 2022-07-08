package com.example.deviapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deviapps.db.MahasiswaDB;
import com.example.deviapps.model.MahasiswaModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tx_nim, tx_nama, tx_alamat;
    private Button btn_simpan, btn_tampil, btn_hapus;
    private TextView tv_nim, tv_nama, tv_alamat;
    String Tnim, Tnama,Talamat;
    Integer Tid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tx_nim = findViewById(R.id.tx_nim);
        tx_nama = findViewById(R.id.tx_nama);
        tx_alamat = findViewById(R.id.tx_alamat);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_tampil = findViewById(R.id.btn_tampil);
        btn_hapus = findViewById(R.id.btn_hapus);
        tv_nim = findViewById(R.id.tv_nim);
        tv_nama = findViewById(R.id.tv_nama);
        tv_alamat = findViewById(R.id.tv_alamat);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim, nama,alamat;
                nim = tx_nim.getText().toString();
                nama = tx_nama.getText().toString();
                alamat = tx_alamat.getText().toString();
                MahasiswaDB mahasiswaDB = MahasiswaDB.getInstance(MainActivity.this);
                MahasiswaModel mahasiswaModel = new MahasiswaModel(nim,nama,alamat);
                mahasiswaDB.mahasiswaDao().insertMahsiswa(mahasiswaModel);

                tx_nama.setText("");
                tx_nim.setText("");
                tx_alamat.setText("");
                Toast.makeText(MainActivity.this,"Berhasil menyimpan data",Toast.LENGTH_LONG).show();
            }
        });

        btn_tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MahasiswaDB mahasiswaDB = MahasiswaDB.getInstance(MainActivity.this);
                MahasiswaModel mahasiswaModelList = mahasiswaDB.mahasiswaDao().getMahasiswa();
                if (mahasiswaModelList!= null){
                    tv_nama.setText(mahasiswaModelList.nama);
                    tv_nim.setText(mahasiswaModelList.nim);
                    tv_alamat.setText(mahasiswaModelList.alamat);
                    Tnim = mahasiswaModelList.nim;
                    Tnama = mahasiswaModelList.nama;
                    Talamat = mahasiswaModelList.alamat;
                    Tid = mahasiswaModelList.id;
                }else {
                    Toast.makeText(MainActivity.this,"Tidak ada data",Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_nama.getText().length()>0){
                    MahasiswaDB mahasiswaDB = MahasiswaDB.getInstance(MainActivity.this);
                    MahasiswaModel mahasiswaModel = new MahasiswaModel(Tid,Tnim,Tnama,Talamat);
                    mahasiswaDB.mahasiswaDao().deleteMahasiswa(mahasiswaModel);
                    tv_nama.setText("");
                    tv_nim.setText("");
                    tv_alamat.setText("");
                    Toast.makeText(MainActivity.this,"Berhasil menghapus data",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Tidak ada data",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}