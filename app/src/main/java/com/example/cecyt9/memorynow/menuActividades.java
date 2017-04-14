//GERARDO INFANZON PICAZO
//INTERFAZ
//INTENT

package com.example.cecyt9.memorynow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuActividades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actividades);
    }


    public void verTangram(View v){
        Intent tan = new Intent(menuActividades.this, Tangram.class);
        startActivity(tan);
    }

    public void verRompecabezas(View v){
        Intent rom = new Intent(menuActividades.this, RompeCabezas.class);
        startActivity(rom);
    }

    public void verLectura(View v){
        Intent lec = new Intent(menuActividades.this, Lectura.class);
        startActivity(lec);
    }

    public void verColumnas(View v){
        Intent col = new Intent(menuActividades.this, Columnas.class);
        startActivity(col);
    }

}
