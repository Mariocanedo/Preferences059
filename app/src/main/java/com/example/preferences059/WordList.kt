package com.example.preferences059

class WordList {

    // lista de datos
    private val wordPairs: MutableList<Pair<String,String>> = mutableListOf()


    fun getWordPairs(): MutableList<Pair<String,String>>{

        return wordPairs
    }

// para agregar Palabras

    fun addWord(key:String, value: String){
        wordPairs.add(Pair(key,value))
    }

// eliminar palabras

    fun removeWord(key:String){
        wordPairs.removeAll{it.first==key}
    }

    // para separar palabras que guardaremos para que tengan una coma de separacion
    fun getSerializedString(): String{
        return wordPairs.joinToString(separator = ","){"${it.first}:${it.second}"}
    }




     // para leer las palabras y quitarle el formato de como se habian guardado

    fun deserializedFromString(serialiized: String?) {

        // limipiar la lista
        wordPairs.clear()

        // verificar si la cadena no es nula o vacia

        if (!serialiized.isNullOrEmpty()) {
            val pairs = serialiized.split(",")

            pairs.forEach { pairString ->

                val keyValue = pairString.split(":")

                if (keyValue.size == 2)

                    wordPairs.add((Pair(keyValue[0], keyValue[1])))

            }

        }


    }
    // muestra las palabras

    override fun toString(): String {
         return  wordPairs.joinToString("\n") {"${it.first}:${it.second}"}
    }





}


