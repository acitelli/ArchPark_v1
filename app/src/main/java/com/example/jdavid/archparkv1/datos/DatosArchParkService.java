package com.example.jdavid.archparkv1.datos;

import com.example.jdavid.archparkv1.models.DatosArchPark;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DatosArchParkService {

    @GET("ar7h-5u86.json")
    Call<ArrayList<DatosArchPark>> obtenerListaDeDatosArchPArk();

}
