package com.sugarmaniac.a5eweightcalculator

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class item (
    @PrimaryKey val id : Int,
    @ColumnInfo val itemName : String?,
    @ColumnInfo val number : Int?,
    @ColumnInfo val weight : Float?
)

@Entity
class Character (
    @PrimaryKey val name: String,
    @ColumnInfo val itemList : List<item>
    )
