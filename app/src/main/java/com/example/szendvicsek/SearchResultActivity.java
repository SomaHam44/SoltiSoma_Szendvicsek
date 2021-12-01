package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    private TextView textKereso;
    private Button btnVisszateres;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        textKereso.setMovementMethod(new ScrollingMovementMethod());


        btnVisszateres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visszamenni = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(visszamenni);
                finish();
            }
        });
    }

    private void init() {
        textKereso = findViewById(R.id.text_szendvicsek);
        btnVisszateres = findViewById(R.id.btn_visszatero);
        adatbazis = new DBHelper(this);
    }
}