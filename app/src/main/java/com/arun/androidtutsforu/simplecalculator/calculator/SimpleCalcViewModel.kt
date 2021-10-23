package com.arun.androidtutsforu.simplecalculator.calculator

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.floor

class SimpleCalcViewModel : ViewModel() {
    var secondNum  = 0.0
    var opcode :String =""
    var firstNumStr =""
    var secondNumStr =""
    var firstNum =0.0
    var isFirst:Boolean = true
    private var _number = MutableLiveData<String>()
    val number:LiveData<String>
     get() = _number
    private var _result = MutableLiveData<String>()
    val result:LiveData<String>
      get() = _result

    init{
      _number.value=""
      _result.value=""
    }
    fun numberClicked(num:String){
         _number.value = _number.value+num
        if(isFirst) {
            firstNumStr = firstNumStr + num
            firstNum =firstNumStr.toDouble()
        }else{
            secondNumStr = secondNumStr + num
            secondNum = secondNumStr.toDouble()
        }
    }
    fun operatorClicked(operator :String){

          _number.value=_number.value+operator
          opcode=operator
          isFirst=false

    }
    fun equalToClicked(){
        when(opcode){
            "+"->_result.value=(firstNum+secondNum).toString()
            "-"->_result.value=(firstNum-secondNum).toString()
            "*"->_result.value=(firstNum*secondNum).toString()
            "/"->_result.value=(firstNum/secondNum).toString()
            else->0
        }
        clear()
    }

    fun clearAllclicked(){
        clear()
        _number.value=""
        _result.value=""

    }
    fun clear(){
        isFirst=true
        firstNumStr=""
        secondNumStr=""
        firstNum=0.0
        secondNum=0.0

    }

}