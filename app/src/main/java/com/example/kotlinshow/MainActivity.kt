package com.example.kotlinshow

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout.*

const val Kotlin = "kotlinTest"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.setGravity(Gravity.TOP, 0, 200)
            toast.view = layoutInflater.inflate(R.layout.layout, null)
            toast.show()
        }

        btn2.setOnClickListener {
            var pos = -1
            AlertDialog.Builder(this).setTitle("列表對話框").setSingleChoiceItems(arrayOf("hello", "world", "everybody"), 0) {
                        dialog, which ->
                    pos = which
                }
                .setPositiveButton("確認") {
                        dialog, which ->
                    Log.d(Kotlin, "確認")
                    Toast.makeText(this, "您的選擇是$pos 項", Toast.LENGTH_LONG).show()
                }.setNegativeButton("取消") {
                        dialog, which ->
                    Log.d(Kotlin, "取消")
                }.show()

        }

        btn3.setOnClickListener {
            AlertDialog.Builder(this).setTitle("列表對話框").setItems(arrayOf("hello", "world", "everybody")) {
            dialog: DialogInterface?, which: Int ->
            Toast.makeText(this, "選擇第$which 項", Toast.LENGTH_LONG).show()
            Log.d(Kotlin, "選擇第$which 項")
            }.show()
        }

        btn4.setOnClickListener {
            AlertDialog.Builder(this).setTitle("按鍵對話框").setMessage("對話框內容").setPositiveButton("確定") {
                    dialog, which ->
                Toast.makeText(this, "確定", Toast.LENGTH_LONG).show()
            }.setNeutralButton("取消") {
                    dialog, which ->
                Toast.makeText(this, "取消", Toast.LENGTH_LONG).show()
            }.setNegativeButton("拒絶") {
                    dialog, which ->
                Toast.makeText(this, "拒絶", Toast.LENGTH_LONG).show()
            }.show()
        }
    }
}
