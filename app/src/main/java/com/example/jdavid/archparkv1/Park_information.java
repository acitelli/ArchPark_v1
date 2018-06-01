package com.example.jdavid.archparkv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jdavid.archparkv1.datos.DatosArchParkService;
import com.example.jdavid.archparkv1.models.AdaptadorArchPark;
import com.example.jdavid.archparkv1.models.DatosArchPark;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Park_information extends AppCompatActivity {


    public static  final  String TAG="Datos";
    private Retrofit myRetrofit;
    private RecyclerView myRecyclerView;
    private  boolean aptadorCargaDeDatos;
    private AdaptadorArchPark adaptadorArchPark;
    private  String  text_arch_park;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_information);

        myRetrofit=new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myRecyclerView =(RecyclerView) findViewById(R.id.idrecyclerView);
        adaptadorArchPark=new AdaptadorArchPark(this);
        myRecyclerView.setAdapter(adaptadorArchPark);
        myRecyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                if(dy>0){

                    int visibleItem=layoutManager.getChildCount();
                    int totalItem=layoutManager.getItemCount();
                    int pastVisible = layoutManager.findFirstVisibleItemPosition();

                    if(aptadorCargaDeDatos){

                        if((visibleItem+pastVisible)>= totalItem){
                            Log.i(TAG,"Al fin el Final");
                            aptadorCargaDeDatos=false;

                            procesadorDeDatosArchPark();
                        }

                    }

                }
            }
        });

        aptadorCargaDeDatos=true;
        procesadorDeDatosArchPark();
    }

    public void procesadorDeDatosArchPark(){

        DatosArchParkService myService =myRetrofit.create(DatosArchParkService.class);
        Call<ArrayList<DatosArchPark>> datosArrayListCall=myService.obtenerListaDeDatosArchPArk();
        datosArrayListCall.enqueue(new Callback<ArrayList<DatosArchPark>>() {
            @Override
            public void onResponse(Call<ArrayList<DatosArchPark>> call, Response<ArrayList<DatosArchPark>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<DatosArchPark>datosArchParksLista=response.body();
                    adaptadorArchPark.adicinarDatos(datosArchParksLista);
                }
                else{
                    Log.e(TAG,"onResponse"+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DatosArchPark>> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.getMessage());
            }
        });


    }


    public void cambiarValor(String pTexto)
    {
        text_arch_park = pTexto;
        Log.i("Respuesta", text_arch_park);

        ubicacion();
    }



    public void ubicacion()
    {
        Intent i = new Intent(this, MapaArchPark.class);
        i.putExtra("texto_comuna",text_arch_park);
        startActivity(i);
    }



    }

