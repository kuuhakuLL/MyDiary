package com.example.mydiary.adapters

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {
    protected var mDataList: List<T> = ArrayList()
    protected var mCallback:  BaseAdapterCallback<T>? = null

    fun attachCallback(callback: BaseAdapterCallback<T>){
        mCallback = callback
    }

    fun detachCallback(){
        mCallback = null
    }

    fun setData(newData: List<T>){
        (mDataList as ArrayList).addAll(newData)
        notifyDataSetChanged()
    }

    fun addItem(newItem: T){
        (mDataList as ArrayList).add(newItem)
        notifyItemInserted(mDataList.size - 1)
    }

    fun addItemToFirst(newItem: T){
        (mDataList as ArrayList).add(0, newItem)
        notifyItemInserted(0)
    }

    fun updateItem(updateData: List<T>){
        (mDataList as ArrayList).clear()
        setData(updateData)
    }

    fun clearAllItem(){
        (mDataList as ArrayList).clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<T> = mDataList

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(mDataList[position])
        holder.itemView.setOnClickListener{
            mCallback?.onItemClick(mDataList[position], holder.itemView)
        }

    }

    override fun getItemCount(): Int = mDataList.count()
}

