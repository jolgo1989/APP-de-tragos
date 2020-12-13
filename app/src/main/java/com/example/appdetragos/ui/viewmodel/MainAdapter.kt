package com.example.appdetragos.ui.viewmodel

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appdetragos.R
import com.example.appdetragos.base.BaseViewHolder
import com.example.appdetragos.data.Drink
import kotlinx.android.synthetic.main.tragos_row.view.*

class MainAdapter(private val context: Context, private val tragosList: List<Drink>,
private val itemClickListener:OnTragoClickListener ) :

    RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnTragoClickListener{
        fun onTragoClick(drink: Drink)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position])
        }
    }

    override fun getItemCount(): Int = tragosList.size
    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink) {
            //centerCrop() metodo colocar mismo tamaño a todas las imagenes
            Glide.with(context).load(item.imgen).centerCrop().into(itemView.img_cocktail)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_descripcion.text = item.descripcion
            itemView.setOnClickListener {
                itemClickListener.onTragoClick(item)
            }

        }

    }
}