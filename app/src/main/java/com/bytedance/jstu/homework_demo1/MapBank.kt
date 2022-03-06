package com.bytedance.jstu.homework_demo1

import com.bytedance.jstu.homework_demo1.Utils.Utils
import java.util.*

class MapBank {
    companion object{
        val map = TreeMap<String, String>()
    }
    public fun encapsulation(rank:String){

        for(i in 1..100){

            var randomNum = when(rank){
                "简单"-> (1..3).random()
                "中等"-> (4..7).random()
                else -> (8..10).random()
            }

            map["第${Utils.format(i)}题"]="NO.${i}\t难度为${randomNum}"
        }
    }

    public fun getMap(): TreeMap<String, String>{
        return map
    }
}