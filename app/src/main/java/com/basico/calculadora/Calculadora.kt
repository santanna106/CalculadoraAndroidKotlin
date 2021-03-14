package com.basico.calculadora

import kotlinx.android.synthetic.main.activity_main.*

class Calculadora {
    companion object {
        fun getCalculo(expressao:String): Int {
            var resultado:Int = 0

            val nums = expressao.split("[+-/x]".toRegex()).toTypedArray()
            val op = expressao.replace("\\s+".toRegex(),"").split("\\d".toRegex()).toTypedArray()
            var i:Int = 1

            resultado = resultado + nums[0].toString().trim().toInt()
            for(itemOp in op ){
                if(itemOp.contains("[+-/x]".toRegex())){
                    when (itemOp) {
                        "+"-> {
                            resultado = resultado + nums[i].toString().trim().toInt()
                        }
                        "-"-> {
                            resultado = resultado - nums[i].toString().trim().toInt()
                        }
                        "x"-> {
                            resultado = resultado * nums[i].toString().trim().toInt()
                        }
                        "/"-> {
                            resultado = resultado / nums[i].toString().trim().toInt()
                        }
                    }
                    i++
                }


            }

            return resultado
        }
    }
}