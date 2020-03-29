package com.example.mydiary.adapters

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {
    var mDataList: List<T> = ArrayList()
    private var mCallback:  BaseAdapterCallback<T>? = null

    fun attachCallback(callback: BaseAdapterCallback<T>){
        mCallback = callback
    }

    fun detachCallback(){
        mCallback = null
    }

    fun setData(newData: List<T>){
        (mDataList as ArrayList).clear()
        (mDataList as ArrayList).addAll(newData)
    }

    fun addItem(newItem: T){
        (mDataList as ArrayList).add(newItem)
    }

    fun addItemToFirst(newItem: T){
        (mDataList as ArrayList).add(0, newItem)
    }

    fun updateItem(updateData: List<T>){
        (mDataList as ArrayList).clear()
        setData(updateData)
    }

    fun clearAllItem(){
        (mDataList as ArrayList).clear()
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

