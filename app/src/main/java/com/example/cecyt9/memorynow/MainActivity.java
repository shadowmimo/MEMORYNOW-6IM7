//GERARDO INFANZON PICAZO
//INTENT
//INTERFAZ
/*Reyes Ortega Ulises Axel:
* -Metodo entra: Establece una conexion al servidor y
* para buscar si la contraseña coincide con alguna escuela registrada,
* si es asi entonces guerda el id de la escuela en las preferencias
* compartidas y lo manda a la siguiente actividad.
* */


package com.example.cecyt9.memorynow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    EditText txtContraEscuela;
    Button entrar;
    String contra = "CECYT-9";
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void entra(View view){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.100.10/Servidorandroid/bin/ajax/goLoginEscuela.php";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        if(response.equals("No se encontro tu escuela")){
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        }else{
                            Intent entrar = new Intent(MainActivity.this, InicioGrupo.class);

                            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("escuela", response.toString());
                            editor.commit();
                            startActivity(entrar);
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
                EditText escuela= (EditText) findViewById(R.id.txtContraEscuela);
                params.put("password", escuela.getText().toString());
                return params;
            }
        };
        queue.add(strRequest);
    }

}
