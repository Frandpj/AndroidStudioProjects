package com.example.zafiro1.recetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class CargarPDF extends AppCompatActivity {

    public PDFView pdfView;
    String PDFurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_pdf);

        Intent intent = getIntent();
        PDFurl = intent.getStringExtra("PDFurl");

        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset(PDFurl).load();



    }
}
