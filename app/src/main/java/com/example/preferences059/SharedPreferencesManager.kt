package com.example.preferences059

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context:Context) {


    companion object{

        // nombre del archivo de las preferencias
      private const val SHARED_PREFERENCES_NAME="Preferences059"
        // referencia a los datos
        private const val KEY_WORD_LIST= "Wordlist"

    }

 // instancia las preferencias de la clase

    private val sharedPreferences : SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)


      fun saveWordList(wordList: WordList){

          val previousWordList = getWordList().getWordPairs() // obtener la lista anterior
          val combinedWordPairs = ArrayList(previousWordList) // creando una nueva lista

          combinedWordPairs.addAll(wordList.getWordPairs())// combinar con la nueva lista
           val editor= sharedPreferences.edit()
          editor.putString(KEY_WORD_LIST, WordList().apply { getWordPairs().addAll(combinedWordPairs) }.getSerializedString())
          editor.apply()

      }


    // retorna el listado de las palabras
    fun getWordList(): WordList{
        // PARA OBTENER LOS DATOS QUE ESTAN EN LAS PREFRENCIAS
        val serializeWordList = sharedPreferences.getString(KEY_WORD_LIST,"")
         val  wordList= WordList()
        wordList.deserializedFromString(serializeWordList)
        return wordList
    }



}