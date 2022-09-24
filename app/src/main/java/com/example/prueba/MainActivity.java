package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private JSONArray arrayMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load(10,10);
    }
   private void load(int limit, int offset) {
        //final LoadingDialog loadingDialog = new LoadingDialog(this);
       // loadingDialog.startLoadingDialog();
        //en caso de no responder

        StringRequest stringRequest = new StringRequest(Request.Method.GET,  "https://musicbrainz.org/ws/2/genre/all?limit=" + limit + "&offset=" +offset +"&fmt=Json",
                response -> {

                    String Datos = response.trim();
                    arrayMusic = null;
                    Log.e("aaaaaaaaa",Datos);
                    try {
                        arrayMusic = new JSONArray(Datos);
                        Log.e("aaaaaaaaa", String.valueOf(arrayMusic));
                        llenarSpinneruso();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
               //     loadingDialog.dismissDialog();
                }, error ->        Log.e("",error.toString()));

       new Response.ErrorListener() {

           @Override
           public void onErrorResponse(VolleyError error) {
               Log.e("",error.toString());
           }
       };
       stringRequest.setRetryPolicy(new RetryPolicy() {
           @Override
           public int getCurrentTimeout() {
               return 50000;
           }

           @Override
           public int getCurrentRetryCount() {
               return 50000;
           }

           @Override
           public void retry(VolleyError error) throws VolleyError {

           }
       });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void llenarSpinneruso() {
        ArrayList<Object> listaInformacion = new ArrayList<>();
        music listElement = null;
    }

}