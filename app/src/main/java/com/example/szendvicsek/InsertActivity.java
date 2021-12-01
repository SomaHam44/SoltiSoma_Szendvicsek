package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private EditText editNev, editLeiras, editElkeszitesiIdo, editAr;
    private Button btnFelvesz, btnVissza;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vissza = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });

        btnFelvesz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nev = editNev.getText().toString().trim();
                String leiras = editLeiras.getText().toString().trim();
                String elkeszitesiIdoString = editElkeszitesiIdo.getText().toString().trim();
                String arString = editAr.getText().toString().trim();
                if (nev.isEmpty() || elkeszitesiIdoString.isEmpty() || arString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "A leíráson kívül minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        int keszitesiIdo = Integer.parseInt(elkeszitesiIdoString);
                        int ar = Integer.parseInt(arString);
                        if (adatbazis.rogzites(nev, leiras, keszitesiIdo, ar)) {
                            Toast.makeText(getApplicationContext(), "Sikeres felvétel", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Sikertelen felvétel", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (NumberFormatException ex) {
                        Toast.makeText(getApplicationContext(),"Az elkészítési időnek és az árnak számnak kell lennie!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void init() {
        editNev = findViewById(R.id.edit_nev);
        editLeiras = findViewById(R.id.edit_leiras);
        editElkeszitesiIdo = findViewById(R.id.edit_elkeszitesiIdo);
        editAr = findViewById(R.id.edit_ara);
        btnFelvesz = findViewById(R.id.btn_felvesz);
        btnVissza = findViewById(R.id.btn_visszater);
        adatbazis = new DBHelper(this);
    }
}