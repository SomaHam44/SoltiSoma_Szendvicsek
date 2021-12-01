package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        btnFelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent felvetelre = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(felvetelre);
                finish();
            }
        });

        btnKeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String arString = editAr.getText().toString().trim();
                if (arString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "A mező kitöltése kötelező!", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        if (!arString.isEmpty()) {
                            Intent keresesre = new Intent(MainActivity.this, SearchResultActivity.class);
                            startActivity(keresesre);
                            finish();
                        }

                    }
                    catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Az árnak számnak kell lennie!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void init() {
        btnFelvetel = findViewById(R.id.btn_felvetel);
        btnKeres = findViewById(R.id.btn_kereses);
        editAr = findViewById(R.id.edit_ar);
        adatbazis = new DBHelper(this);
    }
}