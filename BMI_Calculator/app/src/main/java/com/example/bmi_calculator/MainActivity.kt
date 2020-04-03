package com.example.bmi_calculator

import android.content.Intent
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
        var calcButton: Button = findViewById(R.id.calculate);


        //this is the on long click listener part
        calcButton.setOnLongClickListener(OnLongClickListener {
            Toast.makeText(applicationContext, "IMC = Peso (kg) / altura (m)2  ", Toast.LENGTH_SHORT).show()
            true // set to true

        })

        //function to create the variables needed to display on the next activity
        calcButton.setOnClickListener(View.OnClickListener {
            val weight: Double = weightText.text.toString().toDouble() / 2.2;
            val height: Double = heightText.text.toString().toDouble() / 100;
            val resultado: String = (weight / (height * height)).toString();
            var mensaje: String;
            var emoji: String;
            val intent = Intent(this, Diagnostic::class.java)
            mensaje = if (resultado.toDouble() < 18.5) {
                "Estas debajo de tu peso ideal."
            } else if (resultado.toDouble() > 18.5 && resultado.toDouble() < 24.9) {
                "Tu peso es considerado normal, crack.";
            }else if(resultado.toDouble()>24.9 && resultado.toDouble()<29.9){
                "Estas en sobrepeso. Uf"
            }else {
                "Estas en obesidad."
            }
            //an index is created to know what icon to show on the diagnostic activity
            emoji=if(resultado.toDouble()<18.5) {
                "0"
            } else if(resultado.toDouble()>18.5 && resultado.toDouble()<24.9) {
                "1";
            }else if(resultado.toDouble()>24.9 && resultado.toDouble()<29.9)
            {
                "2"
            }
            else {
                "3"
            }
            //we pass the variables from this activity to the next
            intent.putExtra("resultado",resultado);
            intent.putExtra("mensaje",mensaje);
            intent.putExtra("emoji",emoji);
            startActivity(intent);
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


