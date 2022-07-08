package com.example.deviapps.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.deviapps.model.MahasiswaModel;

@Database(entities = MahasiswaModel.class, exportSchema = false, version = 1)
public abstract class MahasiswaDB extends RoomDatabase {
    private static final String DB_Name = "mahasiswa_db";
    private static MahasiswaDB instance;

    public static synchronized MahasiswaDB getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MahasiswaDB.class, DB_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract MahasiswaDao mahasiswaDao();
}
