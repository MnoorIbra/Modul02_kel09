package com.example.modul02_kel09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.modul02_kel09.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama;
    private TextView tvLastNama;
    private TextView tvEmail;
    private ImageView tvGambar;
    private Button btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tv_first_name);
        tvEmail = findViewById(R.id.tv_email);
        tvGambar = findViewById(R.id.iv_gambar);
        btnAbout = findViewById(R.id.btn_about);



            btnAbout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DetailActivity.this, AboutActivity.class);
                                                startActivity(intent);
                                            }
                                        }
            );




        if (getIntent().hasExtra("avatar")) {

            String gambar = getIntent().getStringExtra("avatar");
            Glide.with(this).load(gambar).into(tvGambar);

            if (getIntent().hasExtra("name" ) && getIntent().hasExtra("lastname")) {

                String nama = getIntent().getStringExtra("name");
                String lastnama = getIntent().getStringExtra("lastname");

                String fullnama = nama + "" + lastnama;
                tvNama.setText(fullnama);


            }

            if (getIntent().hasExtra("email")) {

                String email = getIntent().getStringExtra("email");
                tvEmail.setText(email);
            }


        }
    }






}

