package com.sugarmaniac.a5eweightcalculator

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "character_table")
class CharacterEntitity(
    @PrimaryKey val name: String,
    @ColumnInfo val itemList: String = listToJson(IntArray(187){ 0 * it }),
    @ColumnInfo val maxWeight: Int = 0
    )
