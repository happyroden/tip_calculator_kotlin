package org.hyperskill.calculator.tip

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {
    var percentage = "0"
    var tex = ""
    private var bill:Double = 0.0
    private var tip:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edittext = findViewById<EditText>(R.id.edit_text)
        val s = findViewById<Slider>(R.id.slider)
        edittext.addTextChangedListener(object: TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                tex = p0.toString()
                bill = tex.toDouble()
                calc(bill,tip)
            }

        })
        s.addOnChangeListener(object: Slider.OnChangeListener{
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {

                percentage = (value).toString()
                tip = percentage.toDouble()
                calc(bill,tip)
//                if (bill != 0.0) {
//                    txt.text = "Tip amount: $c"
//                }
            }

        })
    }

    @SuppressLint("SetTextI18n")
    fun calc (bill: Double, tip:Double)
    {   bill.toBigDecimal()
        tip.toBigDecimal()
        val calculate = bill*(tip/100)
        val txt = findViewById<TextView>(R.id.text_view)
        if (bill != 0.0) {
            val c = "%.2f".format(calculate)
            txt.text = "Tip amount: $c"
        }


    }
}