package com.example.preferences059

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.preferences059.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



     private lateinit var  mBinding: ActivityMainBinding
     private lateinit var  sharedPreferencesManager: SharedPreferencesManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mostraDatos()
        mBinding.agregar.setOnClickListener{
            guardarDatos()

        }
    }


    fun guardarDatos(){

       sharedPreferencesManager = SharedPreferencesManager(this)
       val wordList= WordList()

        val valor1 = mBinding.valor1.text.toString()
        val valor2= mBinding.valor2.text.toString()

        wordList.addWord(valor1, valor2)
        sharedPreferencesManager.saveWordList(wordList)

    }
    fun mostraDatos(){

        sharedPreferencesManager = SharedPreferencesManager(this)
        val wordList = sharedPreferencesManager.getWordList()

        val stringBuilder = StringBuilder()
        for(pair in wordList.getWordPairs()){

            val key = pair.first
            val value= pair.second

            println("clave: $key - Valor : $value\n")
            stringBuilder.append("clave: $key - $value\n")

            mBinding.palabras.text= stringBuilder.toString()
        }




    }












}