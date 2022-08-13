package com.example.articfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.articfox.Database.Repository;
import com.example.articfox.Entity.Part;
import com.example.articfox.Entity.Product;
import com.example.articfox.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnterHere(View view) {
        Intent intent = new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());
        Product product = new Product(2, "bicycle", 10.0);
        repo.insert(product);
        Part part = new Part(2, "brake", 10.0, 1);
        repo.insert(part);




    }
}