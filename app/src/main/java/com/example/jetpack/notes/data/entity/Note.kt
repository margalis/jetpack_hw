package com.example.jetpack.notes.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note") //anun chlinelus classi anunn a linum table i anuny
data class Note(
    //@ColumnInfo(name ="note_title")
    val title: String,
    val body: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) {
    //erb pk -n nersum er queryii meji elemneri saghi id nery 0 er
}

