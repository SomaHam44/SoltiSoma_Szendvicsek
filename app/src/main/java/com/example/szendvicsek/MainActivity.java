package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnFelvetel;
    private Button btnKeres;
    private EditText editAr;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnFelvetel = findViewById(R.id.btn_felvetel);
        btnKeres = findViewById(R.id.btn_kereses);
        editAr = findViewById(R.id.edit_ar);
        adatbazis = new DBHelper(this);
    }
}