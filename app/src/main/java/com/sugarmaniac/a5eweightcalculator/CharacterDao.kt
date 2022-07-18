package com.sugarmaniac.a5eweightcalculator

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(characterEntitity: CharacterEntitity)

    @Update
    fun updateCharacter(characterEntitity: CharacterEntitity)

    @Query("Select * from character_table")
    fun getAllCharacters(): LiveData<List<CharacterEntitity>>

}