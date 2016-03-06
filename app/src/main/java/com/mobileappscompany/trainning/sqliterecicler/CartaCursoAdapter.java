package com.mobileappscompany.trainning.sqliterecicler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 3/5/2016.
 */

//public class CartaCursoAdapter extends RecyclerView.Adapter<CartaCursoAdapter.CartaViewHolder> {

public class CartaCursoAdapter extends RecyclerView.Adapter<CartaCursoAdapter.CartaViewHolder> {

    private Context mainContext;
    private List<Curso> items;

    public CartaCursoAdapter(List<Curso> items, Context contexto) {
        this.mainContext = contexto;
        this.items = items;
    }


    static class CartaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        protected TextView id;
        protected TextView nombre;
        protected TextView descripcion;
        protected TextView precio;


        public CartaViewHolder(View v) {
            super(v);

            this.id = (TextView) v.findViewById(R.id.tv_curso_id);
            this.nombre = (TextView) v.findViewById(R.id.tv_curso_nombre);
            this.descripcion = (TextView) v.findViewById(R.id.tv_curso_descripcion);
            this.precio = (TextView) v.findViewById(R.id.tv_curso_precio);

        }
    }


    /**
     * creamos la card o targeta
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public CartaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_curso, viewGroup, false);

        return new CartaViewHolder(v);
    }

    /**
     * Este metodo actualiza el RecyclerView.ViewHolder
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(CartaViewHolder viewHolder, int position) {
        Curso item = items.get(position);
        viewHolder.itemView.setTag(item);

        viewHolder.id.setText("Nº: "+item.getId());
        viewHolder.nombre.setText("Nombre: " +  item.getNombre());
        viewHolder.descripcion.setText("Descripcon: " +  item.getDescripcion());
        viewHolder.precio.setText("Precio: " + item.getPrecio());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}