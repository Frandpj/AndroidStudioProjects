package com.example.fran_dpj.lolgg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CampeonAnalisis extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeon_analisis);


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

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Aatrox");
            Analisis.putExtra("p",  getString(R.string.PAatrox));
            Analisis.putExtra("q", getString(R.string.QAatrox));
            Analisis.putExtra("w",  getString(R.string.WAatrox));
            Analisis.putExtra("e", getString(R.string.EAatrox));
            Analisis.putExtra("r", getString(R.string.RAatrox));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img2).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Ahri");
            Analisis.putExtra("p",  getString(R.string.PAhri));
            Analisis.putExtra("q", getString(R.string.QAhri));
            Analisis.putExtra("w",  getString(R.string.WAhri));
            Analisis.putExtra("e", getString(R.string.EAhri));
            Analisis.putExtra("r", getString(R.string.RAhri));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img3).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Akali");
            Analisis.putExtra("p",  getString(R.string.PAkali));
            Analisis.putExtra("q", getString(R.string.QAkali));
            Analisis.putExtra("w",  getString(R.string.WAkali));
            Analisis.putExtra("e", getString(R.string.EAkali));
            Analisis.putExtra("r", getString(R.string.RAkali));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img4).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Ashe");
            Analisis.putExtra("p",  getString(R.string.PAshe));
            Analisis.putExtra("q", getString(R.string.QAshe));
            Analisis.putExtra("w",  getString(R.string.WAshe));
            Analisis.putExtra("e", getString(R.string.EAshe));
            Analisis.putExtra("r", getString(R.string.RAshe));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img5).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Aurelion Sol");
            Analisis.putExtra("p",  getString(R.string.PAurelion));
            Analisis.putExtra("q", getString(R.string.QAurelion));
            Analisis.putExtra("w",  getString(R.string.WAurelion));
            Analisis.putExtra("e", getString(R.string.EAurelion));
            Analisis.putExtra("r", getString(R.string.RAurelion));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img6).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Azir");
            Analisis.putExtra("p",  getString(R.string.PAzir));
            Analisis.putExtra("q", getString(R.string.QAzir));
            Analisis.putExtra("w",  getString(R.string.WAzir));
            Analisis.putExtra("e", getString(R.string.EAzir));
            Analisis.putExtra("r", getString(R.string.RAzir));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img7).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Caitlyn");
            Analisis.putExtra("p",  getString(R.string.PCaitlyn));
            Analisis.putExtra("q", getString(R.string.QCaitlyn));
            Analisis.putExtra("w",  getString(R.string.WCaitlyn));
            Analisis.putExtra("e", getString(R.string.ECaitlyn));
            Analisis.putExtra("r", getString(R.string.RCaitlyn));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img8).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Camille");
            Analisis.putExtra("p",  getString(R.string.PCamille));
            Analisis.putExtra("q", getString(R.string.QCamille));
            Analisis.putExtra("w",  getString(R.string.WCamille));
            Analisis.putExtra("e", getString(R.string.ECamille));
            Analisis.putExtra("r", getString(R.string.RCamille));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img9).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Cassiopeia");
            Analisis.putExtra("p",  getString(R.string.PCassio));
            Analisis.putExtra("q", getString(R.string.QCassio));
            Analisis.putExtra("w",  getString(R.string.WCassio));
            Analisis.putExtra("e", getString(R.string.ECassio));
            Analisis.putExtra("r", getString(R.string.RCassio));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img10).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "DR. Mundo");
            Analisis.putExtra("p",  getString(R.string.PMundo));
            Analisis.putExtra("q", getString(R.string.QMundo));
            Analisis.putExtra("w",  getString(R.string.WMundo));
            Analisis.putExtra("e", getString(R.string.EMundo));
            Analisis.putExtra("r", getString(R.string.RMundo));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img11).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Draven");
            Analisis.putExtra("p",  getString(R.string.PDraven));
            Analisis.putExtra("q", getString(R.string.QDraven));
            Analisis.putExtra("w",  getString(R.string.WDraven));
            Analisis.putExtra("e", getString(R.string.EDraven));
            Analisis.putExtra("r", getString(R.string.RDraven));
            startActivity(Analisis);

        }
        if (v.getId() == findViewById(R.id.img12).getId()) {

            Intent Analisis = new Intent(CampeonAnalisis.this, Analisis.class);
            Analisis.putExtra("nombreCampeon", "Ekko");
            Analisis.putExtra("p",  getString(R.string.PEkko));
            Analisis.putExtra("q", getString(R.string.QEkko));
            Analisis.putExtra("w",  getString(R.string.WEkko));
            Analisis.putExtra("e", getString(R.string.EEkko));
            Analisis.putExtra("r", getString(R.string.REkko));
            startActivity(Analisis);

        }
    }
}
