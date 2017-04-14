//6IM7
// GERARDO INFANZON PICAZO
//INTENT
//INTERFAZ
/*Reyes Ortega Ulises Axel:
* -Metodo Junta_Imagenes: Establece una conexion al servidor y
* posteriormente despliega las fotos de acuerdo a los datos obtenidos de los
* alumnos registrados
* -Metodo DescargarImagen: envia al servidor una peticion de acuerdo a la ruta que
* se obtuvo en el metodo Junta_Imagenes
* -Metodo menuA: guarda el id del alumno seleccionado en la preferencias compartidas y ejecuta el
* intent de la siguiente actividad
* */
package com.example.cecyt9.memorynow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class inicioAlumno extends AppCompatActivity {
    Context context=this;
    String [] alumnos;
    String [][] alumnosDatos;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_alumno);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String grupo= preferences.getString("grupo", "No hay dato");
        Toast.makeText(getApplicationContext(),"grupo"+grupo, Toast.LENGTH_SHORT).show();
        junta_imagenes(grupo);
    }
    public void junta_imagenes(final String grupo){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.100.10/Servidorandroid/bin/ajax/goAlumnos.php";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        if(response.equals("Accesa datos validos") || response.equals("NO HAY ALUMNOS EN ESTE GRUPO")){
                            Toast.makeText(getApplicationContext(),response, Toast.LENGTH_SHORT).show();
                        }else{
                            alumnos= response.split("\\.");
                            alumnosDatos= new String[alumnos.length][2];

                            for(int i=0; i<alumnos.length;i++){
                                alumnosDatos[i][0]=alumnos[i].split(",")[0];
                                alumnosDatos[i][1]=alumnos[i].split(",")[1];
                                //Toast.makeText(getApplicationContext(),"prr", Toast.LENGTH_SHORT).show();
                                switch(i){
                                    case 0:
                                        ImageButton imagen1= (ImageButton) findViewById(R.id.imageButton2);
                                        new DescargarImagen().execute(imagen1);
                                        imagen1.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[0][0]);
                                            }
                                        });

                                        break;
                                    case 1:
                                        ImageButton imagen2= (ImageButton) findViewById(R.id.imageButton1);
                                        new DescargarImagen().execute(imagen2);
                                        imagen2.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[1][0]);
                                            }
                                        });
                                        break;
                                    case 2:
                                        ImageButton imagen3= (ImageButton) findViewById(R.id.imageButton3);
                                        new DescargarImagen().execute(imagen3);
                                        imagen3.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[2][0]);
                                            }
                                        });
                                        break;
                                    case 3:
                                        ImageButton imagen4= (ImageButton) findViewById(R.id.imageButton13);
                                        new DescargarImagen().execute(imagen4);
                                        imagen4.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[3][0]);
                                            }
                                        });
                                        break;
                                    case 4:
                                        ImageButton imagen5= (ImageButton) findViewById(R.id.imageButton4);
                                        new DescargarImagen().execute(imagen5);
                                        imagen5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[4][0]);
                                            }
                                        });
                                        break;
                                    case 5:
                                        ImageButton imagen6= (ImageButton) findViewById(R.id.imageButton10);
                                        new DescargarImagen().execute(imagen6);
                                        imagen6.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[5][0]);
                                            }
                                        });
                                        break;
                                    case 6:
                                        ImageButton imagen7= (ImageButton) findViewById(R.id.imageButton11);
                                        new DescargarImagen().execute(imagen7);
                                        imagen7.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[6][0]);
                                            }
                                        });
                                        break;
                                    case 7:
                                        ImageButton imagen8= (ImageButton) findViewById(R.id.imageButton21);
                                        new DescargarImagen().execute(imagen8);
                                        imagen8.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[7][0]);
                                            }
                                        });
                                        break;
                                    case 8:
                                        ImageButton imagen9= (ImageButton) findViewById(R.id.imageButton12);
                                        new DescargarImagen().execute(imagen9);
                                        imagen9.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[8][0]);
                                            }
                                        });
                                        break;
                                    case 9:
                                        ImageButton imagen10= (ImageButton) findViewById(R.id.imageButton18);
                                        new DescargarImagen().execute(imagen10);
                                        imagen10.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[9][0]);
                                            }
                                        });
                                        break;
                                    case 10:
                                        ImageButton imagen11= (ImageButton) findViewById(R.id.imageButton19);
                                        new DescargarImagen().execute(imagen11);
                                        imagen11.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[10][0]);
                                            }
                                        });
                                        break;
                                    case 11:
                                        ImageButton imagen12= (ImageButton) findViewById(R.id.imageButton26);
                                        new DescargarImagen().execute(imagen12);
                                        imagen12.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[11][0]);
                                            }
                                        });
                                        break;
                                    case 12:
                                        ImageButton imagen13= (ImageButton) findViewById(R.id.imageButton20);
                                        new DescargarImagen().execute(imagen13);
                                        imagen13.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[12][0]);
                                            }
                                        });
                                        break;
                                    case 13:
                                        ImageButton imagen14= (ImageButton) findViewById(R.id.imageButton23);
                                        new DescargarImagen().execute(imagen14);
                                        imagen14.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[13][0]);
                                            }
                                        });
                                        break;
                                    case 14:
                                        ImageButton imagen15= (ImageButton) findViewById(R.id.imageButton24);
                                        new DescargarImagen().execute(imagen15);
                                        imagen15.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[14][0]);
                                            }
                                        });
                                        break;
                                    case 15:
                                        ImageButton imagen16= (ImageButton) findViewById(R.id.imageButton25);
                                        new DescargarImagen().execute(imagen16);
                                        imagen16.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                menuA(alumnosDatos[15][0]);
                                            }
                                        });
                                        break;

                                }
                            }
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", grupo);
                return params;
            }
        };
        queue.add(strRequest);
    }

    class DescargarImagen extends AsyncTask<ImageView,Void,Bitmap> {
        ImageView imagen;
        Bitmap bitm;

        @Override
        protected Bitmap doInBackground(ImageView... params) {
            imagen= params[0];
            String dato= alumnosDatos[contador][1];
            contador++;
            String ur= "http://192.168.100.10/Proyectofinalizado/MEMORYNOW/MEMORYNOW/fotosalumnos/" +
                    "fotoalumno"+dato+".jpg";
            try{
                URL imageUrl=new URL(ur);
                HttpURLConnection conn= (HttpURLConnection) imageUrl.openConnection();
                conn.connect();
                bitm = BitmapFactory.decodeStream(conn.getInputStream());
            }catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitm;
        }
        @Override
        protected void onPostExecute(Bitmap result){
            imagen.setImageBitmap(result);
            super.onPostExecute(result);
        }
    }

    public void menuA(String alumno){
        //Toast.makeText(getApplicationContext(),alumno, Toast.LENGTH_SHORT).show();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("alumno", alumno);
        editor.commit();
        Intent actividad = new Intent(inicioAlumno.this, menuActividades.class);
        startActivity(actividad);

    }
}
