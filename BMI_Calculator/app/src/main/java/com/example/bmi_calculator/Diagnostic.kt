package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Diagnostic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostic)
        //creates all references needed for this activity, from the previous one
        val BMI=intent.getStringExtra("resultado");
        var bmi: TextView=findViewById(R.id.bmi);
        val MESSAGE= intent.getStringExtra("mensaje");
        var message: TextView=findViewById(R.id.mensaje);
        val EMOJI=intent.getStringExtra("emoji");
        val emoji: ImageView=findViewById(R.id.result_image);

        //chooses what emoji to display based on the BMI result
        val drawableResource = when (EMOJI) {
           "0" -> R.drawable.ic_emoji
            "1" -> R.drawable.ic_check
            "2" -> R.drawable.overweight
            else -> R.drawable.ic_alert
        }
        emoji.setImageResource(drawableResource);

        //sets up the textviews. result and message are shown.
        var intent=intent;
        val peso=intent.getStringExtra("resultado");
        val mensaje=intent.getStringExtra("mensaje");
        bmi.text=peso;
        message.text=mensaje;
    }

}
