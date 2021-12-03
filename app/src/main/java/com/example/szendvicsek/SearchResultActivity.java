package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {
    private TextView textKereso;
    private EditText ar;
    private Button btnKeres;
    private Button btnVisszateres;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        textKereso.setMovementMethod(new ScrollingMovementMethod());

        btnKeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szendvicskereso();

            }
        });


        btnVisszateres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visszamenni = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(visszamenni);
                finish();
            }
        });

    }

    private void szendvicskereso() {
        String arString = ar.getText().toString().trim();
        if (arString.isEmpty()) {
            Toast.makeText(getApplicationContext(), "A mező kitöltése kötelező!", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                if (!arString.isEmpty()) {
                    Cursor kereses = adatbazis.kereses(String.valueOf(ar.getText()));
                    StringBuilder builder = new StringBuilder();

                    if (kereses.getCount() == 0) {
                        builder.append("Nincs ilyen olcsó szendvics ").append(Integer.parseInt(ar.getText().toString()));

                    } else {
                        while (kereses.moveToNext()) {
                            builder.append("ID: ").append(kereses.getInt(0));
                            builder.append(System.lineSeparator());
                            builder.append("Név: ").append(kereses.getString(1));
                            builder.append(System.lineSeparator());
                            builder.append("Leírás: ").append(kereses.getString(2));
                            builder.append(System.lineSeparator());
                            builder.append("Elkészítési idő (perc) : ").append(kereses.getInt(3));
                            builder.append(System.lineSeparator());
                            builder.append("Ár (Ft) : ").append(kereses.getInt(4));
                            builder.append(System.lineSeparator());
                            builder.append(System.lineSeparator());


                        }
                    }
                    textKereso.setText(builder.toString());
                }

            }
            catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Az árnak számnak kell lennie!", Toast.LENGTH_SHORT).show();
            }


        }



    }

    public void init() {
        textKereso = findViewById(R.id.text_szendvicsek);
        btnVisszateres = findViewById(R.id.btn_visszatero);
        btnKeres = findViewById(R.id.btn_keres);
        ar = findViewById(R.id.e_ar);
        adatbazis = new DBHelper(this);

    }

    }
