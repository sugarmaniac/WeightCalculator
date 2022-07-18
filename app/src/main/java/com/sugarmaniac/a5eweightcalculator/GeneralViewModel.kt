package com.sugarmaniac.a5eweightcalculator

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeneralViewModel() : ViewModel() {

    lateinit var getAllCharacters: LiveData<List<CharacterEntitity>>
    private val selectedCharacter = MutableLiveData<CharacterEntitity>()
    private lateinit var repository : CharacterRepo
    private var itemList = IntArray(187){ 0 * it }

    fun initCharacterDao(context: Context){
        val characterDao = CharacterDatabase.getDatabase(context).characterDao()
        repository = CharacterRepo(characterDao)
        getAllCharacters = repository.getAllCharacters
    }

    fun addCharacter(characterEntitity: CharacterEntitity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addCharacter(characterEntitity)
        }
    }

    fun updateCharacter(characterEntitity: CharacterEntitity){
        repository.updateCharacter(characterEntitity)
    }

    fun addItemToSelectedCharacter(position: Int){
        itemList[position] = itemList[position] + 1
//        selectedCharacter.value!!.itemList[position] = selectedCharacter.value!!.itemList[position] + 1
    }

    fun deleteItemFromSelectedCharacter(position: Int){
        itemList[position] = itemList[position] - 1
//        selectedCharacter.value!!.itemList[position] = selectedCharacter.value!!.itemList[position] - 1
    }

}