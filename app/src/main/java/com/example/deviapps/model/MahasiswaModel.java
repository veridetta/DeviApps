package com.example.deviapps.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbmahasiswa")
public class MahasiswaModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="nim")
    public String nim;
    @ColumnInfo(name = "nama")
    public String nama;
    @ColumnInfo(name = "alamat")
    public String alamat;

    public MahasiswaModel(int id, String nim, String nama, String alamat){
        this.id=id;
        this.nim =nim;
        this.nama = nama;
        this.alamat = alamat;
    }
    @Ignore
    public MahasiswaModel(String nim, String nama, String alamat){
        this.nim =nim;
        this.nama = nama;
        this.alamat = alamat;
    }
}
