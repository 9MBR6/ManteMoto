package com.example.mantenimientomotosbd.ui;

import static com.example.mantenimientomotosbd.ui.historial.HistoryFragment.mantenimientosMoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mantenimientomotosbd.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_recicle_view,parent,false);
        RecyclerView.ViewHolder viewHolder = new RecyclerViewHolder(v);
        return (RecyclerViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        RecyclerViewHolder viewHolderMeu = (RecyclerViewHolder) holder;
        viewHolderMeu.id.setText("ID: "+mantenimientosMoto.get(position).getIdMantenimiento());
        viewHolderMeu.fecha.setText("Fecha: "+mantenimientosMoto.get(position).getFecha());
        viewHolderMeu.kms.setText("Kms: "+mantenimientosMoto.get(position).getKm());
        viewHolderMeu.aceite.setText("Aceite: "+mantenimientosMoto.get(position).getAceite());
        viewHolderMeu.filtroAceite.setText("Filtro de aceite: "+mantenimientosMoto.get(position).getFiltroAceite());
        viewHolderMeu.filtroAire.setText("Filtro de aire: "+mantenimientosMoto.get(position).getFiltroAire());
        viewHolderMeu.bujias.setText("Bujías: "+mantenimientosMoto.get(position).getBujia());
        viewHolderMeu.pastillasDelanteras.setText("Pastillas delanteras: "+mantenimientosMoto.get(position).getPastillasDelanteras());
        viewHolderMeu.pastillasTraseras.setText("Pastillas traseras: "+mantenimientosMoto.get(position).getPastillasTraseras());
        viewHolderMeu.liquidoFrenos.setText("Líquido de frenos: "+mantenimientosMoto.get(position).getLiquidoFrenos());
        viewHolderMeu.kitArrastre.setText("Kit de arrastre: "+mantenimientosMoto.get(position).getKitArrastre());
        viewHolderMeu.etComentarios.setText(mantenimientosMoto.get(position).getComentarios());


    }

    @Override
    public int getItemCount() {
        return mantenimientosMoto.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        //aqui solo tenemos que referenciar los elementos del la vista xml
        TextView id, bujias, aceite, kms, fecha, filtroAceite, filtroAire, pastillasDelanteras, pastillasTraseras,
        liquidoFrenos, kitArrastre, etComentarios;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.rvID);
            bujias = itemView.findViewById(R.id.rvBujias);
            aceite = itemView.findViewById(R.id.rvAceite);
            kms = itemView.findViewById(R.id.rvKms);
            fecha = itemView.findViewById(R.id.rvFecha);
            filtroAceite = itemView.findViewById(R.id.rvFiltroAceite);
            filtroAire = itemView.findViewById(R.id.rvFiltroAire);
            pastillasDelanteras = itemView.findViewById(R.id.rvPastillasDelanteras);
            pastillasTraseras = itemView.findViewById(R.id.rvPastillasTraseras);
            liquidoFrenos = itemView.findViewById(R.id.rvLiquidoFrenos);
            kitArrastre = itemView.findViewById(R.id.rvKitArrastre);
            etComentarios = itemView.findViewById(R.id.etComentarios);

        }
    }

}


