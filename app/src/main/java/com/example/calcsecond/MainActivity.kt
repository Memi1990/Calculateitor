package com.example.calcsecond

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckedTextView
import com.example.calcsecond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    var n1= 0
    var n2= 0
    var op= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.tvPantalla.text="0"

        b.btIgu.setOnClickListener {
            n2 = b.tvPantalla.text.toString().toInt()
            var result = when(op){
                "+" -> n1+n2
                "-" -> n1-n2
                "x" -> n1*n2
                "/" -> n1/n2.toDouble()
                else -> 0
            }
            b.tvMemo.text = b.tvMemo.text.toString().plus(n2.toString())
            b.tvPantalla.text = result.toString()
        }
        b.btClear.setOnClickListener{
            b.tvPantalla.text = "0"
            b.tvMemo.text = ""
            n1= 0
            n2= 0
            op= ""
        }

//array size
    }

    fun onClickNumber(view:View){
        if (view is Button) {
            val texBtn = view.text.toString()
            if (b.tvPantalla.text.toString() != "0"){
                b.tvPantalla.text = b.tvPantalla.text.toString().plus(texBtn)
            } else {
                b.tvPantalla.text = texBtn
            }
        }
    }

    fun pressOp (view:View){
        if (view is Button){
            n1 = b.tvPantalla.text.toString().toInt()
            op = view.text.toString()
            b.tvPantalla.text="0"
            b.tvMemo.text = n1.toString().plus(op)
        }
    }
}