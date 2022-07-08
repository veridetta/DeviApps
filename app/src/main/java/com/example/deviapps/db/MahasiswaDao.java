package com.example.deviapps.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.deviapps.model.MahasiswaModel;

import java.util.List;

@Dao
public interface MahasiswaDao {
    //mengambil data user
    String tb_mahasiswa = "tbmahasiswa";
    @Query("SELECT * FROM "+tb_mahasiswa)
    MahasiswaModel getMahasiswa();

    //menginput data
    @Insert
    void insertMahsiswa(MahasiswaModel userModel);
    //mengupdate data
    @Update
    void updateMahasiswa(MahasiswaModel userModel);
    //menghapus data
    @Delete
    void deleteMahasiswa(MahasiswaModel userModel);
}
