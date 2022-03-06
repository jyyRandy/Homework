package com.bytedance.jstu.homework_demo1

import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.jstu.homework.R
import com.bytedance.jstu.homework_demo1.Utils.Utils
import java.util.*

class DemoAdapter(rank: String) : RecyclerView.Adapter<DemoAdapter.TextViewHolder>() {

    private val itemList = mutableListOf<String>()
    private val filterList = mutableListOf<String>()
    private var map = TreeMap<String, String>()
    private var rank = rank

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.homework_layout, parent, false)
        encapsulation()
        return TextViewHolder(v)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.setListener(itemList[position], rank)
    }

    override fun getItemCount(): Int =itemList.size

    fun updatedData(list: List<String>){
        itemList.clear()
        itemList.addAll(list)
        //更新列表
        notifyDataSetChanged()
    }
    fun setFilter(filter: String?){
        if (filter?.isNotEmpty()==true){
            val result = itemList.filter{it.contains(filter)}

            filterList.clear()
            filterList.addAll(result)
        }else{
            filterList.clear()
            filterList.addAll(itemList)
        }
        notifyDataSetChanged()
    }

    private fun encapsulation(){

        for(i in 1..100){
            map["第${Utils.format(i)}题"]="NO.${Utils.format(i)}"
        }
    }


    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val tv = view.findViewById<TextView>(R.id.homework_item_tv)

        fun bind(text: String){
            tv.text=text
        }

        fun setListener(id: String, rank: String){
            tv.setOnClickListener {
                showDetails(id, rank)
            }
        }

        private fun showDetails(id: String, rank: String){
            var mapBank = MapBank()
            mapBank.encapsulation(rank)
            val message: String? = mapBank.getMap()[id]

            val builder = AlertDialog.Builder(itemView.context)
            builder
                .setTitle("题目信息")
                .setMessage(message)
                .setPositiveButton(
                    "返回",
                    object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("TAG", "onClick:返回")
                        }
                    })
                .show()
        }

    }
}