package com.sugarmaniac.a5eweightcalculator

import androidx.lifecycle.LiveData

class CharacterRepo(private val characterDao: CharacterDao) {
    val getAllCharacters: LiveData<List<CharacterEntitity>> = characterDao.getAllCharacters()

    suspend fun addCharacter(characterEntitity: CharacterEntitity){
        characterDao.addCharacter(characterEntitity)
    }

    fun updateCharacter(characterEntitity: CharacterEntitity){
        characterDao.updateCharacter(characterEntitity)
    }
}