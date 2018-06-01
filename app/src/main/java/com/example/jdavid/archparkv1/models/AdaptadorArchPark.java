package com.example.jdavid.archparkv1.models;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jdavid.archparkv1.R;

import java.util.ArrayList;

public class AdaptadorArchPark extends RecyclerView.Adapter<AdaptadorArchPark.DireccionViewHolder> {

    ArrayList<DatosArchPark> datos;
    private DatosArchPark datosArchPark;
    private Context myContext;


    public  AdaptadorArchPark(Context context)
    {
        this.myContext=context;
        datos= new ArrayList<>();
    }

    AdaptadorArchPark(ArrayList<DatosArchPark>datosArch){
        this.datos=datosArch;

    }
    public DireccionViewHolder onCreateViewHolder(ViewGroup viewGroup, int j) {

        View myView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_archpark,viewGroup,false);
        DireccionViewHolder direccionVi= new DireccionViewHolder(myView);
        return direccionVi;

    }

    @Override
    public void onBindViewHolder( DireccionViewHolder holder, int position) {
        datosArchPark=datos.get(position);
        //holder.direTextView.setText(datosColombia.getCategoria());
        holder.text6.setText("Codigo_icanh:"+datosArchPark.getCodigo_icanh());
        holder.text1.setText("Datos_biliograficos:"+datosArchPark.getDatos_bibliograficos());
        holder.text2.setText("Datos_historicos:"+datosArchPark.getDatos_historicos());
        holder.text3.setText("descripcion:"+datosArchPark.getDescripcion());
        holder.text4.setText("dimensiones_visibles:"+datosArchPark.getDimensiones_visibles());
        holder.text5.setText("elemento_arqueologico :"+datosArchPark.getElemento_arqueologico());
        holder.text7.setText("nombre elemento arqueologico:"+datosArchPark.getNombre_elemento_arqueologico());
        holder.text8.setText("parque_arqueologico :"+datosArchPark.getDimensiones_visibles());
        holder.text9.setText("tecnica_de_elaboracion :"+datosArchPark.getTecnica_de_elaboracion());
        holder.text10.setText("ubicacion  actual:"+datosArchPark.getUbicacion_actual_dentro_del_parque());


        Glide.with(myContext);
    }


    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void adicinarDatos(ArrayList<DatosArchPark>listaDatosArchParks)
    {
        datos.addAll(listaDatosArchParks);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class DireccionViewHolder extends RecyclerView.ViewHolder {


        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView text4;
        private TextView text5;
        private TextView text6;
        private TextView text7;
        private TextView text8;
        private TextView text9;
        private TextView text10;



        CardView myCardV;
        TextView direTextView;

        DireccionViewHolder(View itemView)
        {
            super(itemView);
            myCardV =(CardView)itemView.findViewById(R.id.myCardView);
            direTextView =(TextView)itemView.findViewById(R.id.txt1);

            text1 =(TextView)itemView.findViewById(R.id.txt1);
            text2 =(TextView)itemView.findViewById(R.id.txt2);
            text3 =(TextView)itemView.findViewById(R.id.txt3);
            text4 =(TextView)itemView.findViewById(R.id.txt4);
            text5 =(TextView)itemView.findViewById(R.id.txt5);
            text6 =(TextView)itemView.findViewById(R.id.txt6);
            text7 =(TextView)itemView.findViewById(R.id.txt7);
            text8 =(TextView)itemView.findViewById(R.id.txt8);
            text9 =(TextView)itemView.findViewById(R.id.txt9);
            text10=(TextView)itemView.findViewById(R.id.txt10);






        }

    }

}
