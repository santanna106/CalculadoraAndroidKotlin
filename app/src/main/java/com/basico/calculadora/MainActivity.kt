package com.basico.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var resultado:Int = 0
    private var operacaoAcionada:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickListeners()
        txtDisplay.setText("")
        txtResultado.setText("")
    }

    private fun clickListeners()
    {
        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnSoma.setOnClickListener(this)
        btnZerar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.btn0-> {
                atualizaNumeroExpressao("0")
            }
            R.id.btn1-> {
                atualizaNumeroExpressao("1")
            }
            R.id.btn2-> {
                atualizaNumeroExpressao("2")
            }
            R.id.btn3-> {
                atualizaNumeroExpressao("3")
            }
            R.id.btn4-> {
                atualizaNumeroExpressao("4")
            }
            R.id.btn5-> {
                atualizaNumeroExpressao("5")
            }
            R.id.btn6-> {
                atualizaNumeroExpressao("6")
            }
            R.id.btn7-> {
                atualizaNumeroExpressao("7")
            }
            R.id.btn8-> {
                atualizaNumeroExpressao("8")
            }
            R.id.btn9-> {

                atualizaNumeroExpressao("9")
            }
            R.id.btnSoma-> {
                atualizaOperacaoCalculo(" + ")
            }
            R.id.btnSub-> {
                atualizaOperacaoCalculo(" - ")
            }
            R.id.btnMult-> {
                atualizaOperacaoCalculo(" x ")

            }
            R.id.btnDiv-> {
                atualizaOperacaoCalculo(" / ")
            }
            R.id.btnZerar-> {
                atualizaTextView(txtDisplay,"",true)
                atualizaTextView(txtResultado,"",true)
            }
        }

    }

    private fun atualizaTextView(textView: TextView,caracter:String,zerar:Boolean = false ){
        if(zerar){
            textView.setText(caracter);
        } else {
            textView.text = textView.text.toString() + caracter;
        }

    }

    private fun atualizaOperacaoCalculo(caracter:String ){
        txtDisplay.text = txtDisplay.text.toString() + caracter
        operacaoAcionada = true
    }

    private fun atualizaNumeroExpressao(caracter:String){
        atualizaTextView(txtDisplay,caracter)
        if (operacaoAcionada){
            operacaoAcionada = false
        } else {
            atualizaTextView(txtResultado,caracter)
        }
        val calcResultExp: Int
        calcResultExp = Calculadora.getCalculo(txtDisplay.text.toString())
        txtResultado.setText(calcResultExp.toString())
    }



}