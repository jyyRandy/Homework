package com.bytedance.jstu.homework_demo1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.bytedance.jstu.homework.R
import com.bytedance.jstu.homework.databinding.ActivityMenuBinding
import java.util.*

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding

    private var introduction:String = "简单模式：难度随机为1~3\n" +
            "中等模式：难度随机为4~7\n困难模式：难度随机为8~10"


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.buttonEasy.setOnClickListener {
            Intent(this, SubjectActivity::class.java).apply {
                putExtra("难度", "简单")
                startActivity(this)
            }
        }

        binding.buttonMiddle.setOnClickListener {
            Intent(this, SubjectActivity::class.java).apply {
                putExtra("难度", "中等")
                startActivity(this)
            }
        }

        binding.buttonHard.setOnClickListener {
            Intent(this, SubjectActivity::class.java).apply {
                putExtra("难度", "困难")
                startActivity(this)
            }
        }

        binding.appIntroduction.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder
                .setTitle("详情")
                .setMessage(introduction)
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