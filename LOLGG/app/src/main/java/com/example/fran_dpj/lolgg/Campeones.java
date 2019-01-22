package com.example.fran_dpj.lolgg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Campeones extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeones);

        ImageButton img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;


        View viewimg1 = findViewById(R.id.img1);
        viewimg1.setOnClickListener(this);

        img1 = findViewById(R.id.img1);
        viewimg1.setOnClickListener(this);

        View viewimg2 = findViewById(R.id.img2);
        viewimg2.setOnClickListener(this);

        img2 = findViewById(R.id.img2);
        viewimg2.setOnClickListener(this);

        View viewimg3 = findViewById(R.id.img3);
        viewimg3.setOnClickListener(this);

        img3 = findViewById(R.id.img3);
        viewimg3.setOnClickListener(this);

        View viewimg4 = findViewById(R.id.img4);
        viewimg4.setOnClickListener(this);

        img4 = findViewById(R.id.img4);
        viewimg4.setOnClickListener(this);

        View viewimg5 = findViewById(R.id.img5);
        viewimg5.setOnClickListener(this);

        img5 = findViewById(R.id.img5);
        viewimg5.setOnClickListener(this);

        View viewimg6 = findViewById(R.id.img6);
        viewimg6.setOnClickListener(this);

        img6 = findViewById(R.id.img6);
        viewimg6.setOnClickListener(this);

        View viewimg7 = findViewById(R.id.img7);
        viewimg1.setOnClickListener(this);

        img7 = findViewById(R.id.img7);
        viewimg7.setOnClickListener(this);

        View viewimg8 = findViewById(R.id.img8);
        viewimg8.setOnClickListener(this);

        img8 = findViewById(R.id.img8);
        viewimg8.setOnClickListener(this);

        View viewimg9 = findViewById(R.id.img9);
        viewimg9.setOnClickListener(this);

        img9 = findViewById(R.id.img9);
        viewimg9.setOnClickListener(this);

        View viewimg10 = findViewById(R.id.img10);
        viewimg10.setOnClickListener(this);

        img10 = findViewById(R.id.img10);
        viewimg10.setOnClickListener(this);

        View viewimg11 = findViewById(R.id.img11);
        viewimg11.setOnClickListener(this);

        img11 = findViewById(R.id.img11);
        viewimg11.setOnClickListener(this);

        View viewimg12 = findViewById(R.id.img12);
        viewimg12.setOnClickListener(this);

        img12 = findViewById(R.id.img12);
        viewimg12.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == findViewById(R.id.img1).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Aatrox");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Aatrox));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img2).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Ahri");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Ahri));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img3).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Akali");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Akali));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img4).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Ashe");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Ashe));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img5).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Aurelion Sol");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.AurelionSol));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img6).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Azir");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Azir));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img7).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Caitlyn");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Caitlyn));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img8).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Camille");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Camille));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img9).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Cassiopeia");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Cassiopeia));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img10).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "DR. Mundo");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.DRMundo));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img11).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Draven");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Draven));
            startActivity(HistoriaCampeones);

        }
        if (v.getId() == findViewById(R.id.img12).getId()) {

            Intent HistoriaCampeones = new Intent(Campeones.this, HistoriaCampeones.class);
            HistoriaCampeones.putExtra("nombreCampeon", "Ekko");;
            HistoriaCampeones.putExtra("historiaCampeon",  getString(R.string.Ekko));
            startActivity(HistoriaCampeones);

        }


    }
}
