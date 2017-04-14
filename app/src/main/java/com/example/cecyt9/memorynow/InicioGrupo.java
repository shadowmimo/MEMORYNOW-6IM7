// 6IM7
// GERARDO INFANZON PICAZO:
//INTENT
//INTERFAZ
/*Reyes Ortega Ulises Axel:
* -Metodo Junta_Imagenes: Establece una conexion al servidor y
* posteriormente despliega las fotos de acuerdo a los datos obtenidos
* -Metodo DescargarImagen: envia al servidor una peticion de acuerdo a la ruta que
* se obtuvo en el metodo Junta_Imagenes
* -Metodo SiguienteA: guarda el id del grupo en la preferencias compartidas y ejecuta el
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InicioGrupo extends AppCompatActivity {

    Context context=this;
    String [] grupos;
    String [][] gruposDatos;
    int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_grupo);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String escuela= preferences.getString("escuela", "No hay dato");
        junta_imagenes(escuela);
    }

    public void junta_imagenes(final String escuela){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.100.10/Servidorandroid/bin/ajax/goGrupos.php";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        if(response.equals("Accesa datos validos") || response.equals("NO HAY GRUPOS EN ESTA ESCUELA")){
                            Toast.makeText(getApplicationContext(),response, Toast.LENGTH_SHORT).show();
                        }else{
                            grupos= response.split("\\.");
                            gruposDatos= new String[grupos.length][2];

                            for(int i=0; i<grupos.length;i++){
                                gruposDatos[i][0]=grupos[i].split(",")[0];
                                gruposDatos[i][1]=grupos[i].split(",")[1];
                                //Toast.makeText(getApplicationContext(),"prr", Toast.LENGTH_SHORT).show();
                                switch(i){
                                    case 0:
                                        ImageButton imagen1= (ImageButton) findViewById(R.id.imageButton2);
                                        new DescargarImagen().execute(imagen1);
                                        imagen1.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[0][0]);
                                            }
                                        });

                                        break;
                                    case 1:
                                        ImageButton imagen2= (ImageButton) findViewById(R.id.imageButton1);
                                        new DescargarImagen().execute(imagen2);
                                        imagen2.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[1][0]);
                                            }
                                        });
                                        break;
                                    case 2:
                                        ImageButton imagen3= (ImageButton) findViewById(R.id.imageButton3);
                                        new DescargarImagen().execute(imagen3);
                                        imagen3.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[2][0]);
                                            }
                                        });
                                        break;
                                    case 3:
                                        ImageButton imagen4= (ImageButton) findViewById(R.id.imageButton4);
                                        new DescargarImagen().execute(imagen4);
                                        imagen4.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[3][0]);
                                            }
                                        });
                                        break;
                                    case 4:
                                        ImageButton imagen5= (ImageButton) findViewById(R.id.imageButton5);
                                        new DescargarImagen().execute(imagen5);
                                        imagen5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[4][0]);
                                            }
                                        });
                                        break;
                                    case 5:
                                        ImageButton imagen6= (ImageButton) findViewById(R.id.imageButton8);
                                        new DescargarImagen().execute(imagen6);
                                        imagen6.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[5][0]);
                                            }
                                        });
                                        break;
                                    case 6:
                                        ImageButton imagen7= (ImageButton) findViewById(R.id.imageButton6);
                                        new DescargarImagen().execute(imagen7);
                                        imagen7.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[6][0]);
                                            }
                                        });
                                        break;
                                    case 7:
                                        ImageButton imagen8= (ImageButton) findViewById(R.id.imageButton7);
                                        new DescargarImagen().execute(imagen8);
                                        imagen8.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[7][0]);
                                            }
                                        });
                                        break;
                                    case 8:
                                        ImageButton imagen9= (ImageButton) findViewById(R.id.imageButton9);
                                        new DescargarImagen().execute(imagen9);
                                        imagen9.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                siguienteA(gruposDatos[8][0]);
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
                params.put("id", escuela);
                return params;
            }
        };
        queue.add(strRequest);
    }

    class DescargarImagen extends AsyncTask<ImageView,Void,Bitmap>{
        ImageView imagen;
        Bitmap bitm;

        @Override
        protected Bitmap doInBackground(ImageView... params) {
            imagen= params[0];
            String dato= gruposDatos[contador][1];
            contador++;
            String ur= "http://192.168.100.10/Proyectofinalizado/MEMORYNOW/MEMORYNOW/fotosgrupos/" +
                    "fotogrupo"+dato+".png";
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
    public void siguienteA(String id){
        //Toast.makeText(getApplicationContext(),id, Toast.LENGTH_SHORT).show();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("grupo", id);
        editor.commit();
        Intent alumno = new Intent(InicioGrupo.this, inicioAlumno.class);
        startActivity(alumno);

    }

}
