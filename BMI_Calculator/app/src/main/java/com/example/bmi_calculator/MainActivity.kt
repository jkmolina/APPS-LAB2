package com.example.bmi_calculator

import android.os.Bundle
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weightText: EditText=findViewById(R.id.weight);
        var heightText: EditText=findViewById(R.id.height);
        var result: TextView=findViewById(R.id.result);
        var calcButton: Button = findViewById(R.id.calculate);


        //this is the on long click listener part
        calcButton.text="Decoldest";
        calcButton.setOnLongClickListener(OnLongClickListener {
            Toast.makeText(applicationContext, "IMC = Peso (kg) / altura (m)2  ", Toast.LENGTH_SHORT).show()
            true // set to true

        })

        calcButton.setOnClickListener(View.OnClickListener{
            result.text=(weightText.text.toString().toInt()+heightText.text.toString().toInt()).toString();
        })
//        calcButton.setOnClickListener{
//            result.text=calculate().toString()};
//
//        fun calculate(): Int {
//            val weightString = weightText.text.toString();
//            val weight=weightString.toInt();
//            val heightString=heightText.text.toString();
//            val height=heightString.toInt();
//            return height+weight;
//        }

    }
}


