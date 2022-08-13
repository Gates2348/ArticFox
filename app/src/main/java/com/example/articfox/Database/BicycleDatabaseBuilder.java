package com.example.articfox.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.articfox.DAO.PartDAO;
import com.example.articfox.DAO.ProductDAO;
import com.example.articfox.Entity.Part;
import com.example.articfox.Entity.Product;

@Database(entities = {Product.class, Part.class}, version = 1, exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context){
        synchronized (BicycleDatabaseBuilder.class) {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BicycleDatabaseBuilder.class, "myBicycleDatabase.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
