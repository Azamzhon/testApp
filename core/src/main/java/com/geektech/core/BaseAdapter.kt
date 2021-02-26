package com.geektech.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
    private val holderLayoutId: Int,
    val listener: ((model: T) -> Unit)? = null
) :
    RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    private var data = mutableListOf<T>()

    fun setAllData(data: MutableList<T>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun addAllData(data: MutableList<T>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            LayoutInflater.from(parent.context).inflate(holderLayoutId, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    abstract fun onBind(view: View, model: T)

    inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(model: T) {
            onBind(itemView, model)

            itemView.setOnClickListener {
               listener?.let {
                    it(model)
                }
            }
        }
    }
}