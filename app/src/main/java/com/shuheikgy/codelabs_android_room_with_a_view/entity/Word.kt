package com.shuheikgy.codelabs_android_room_with_a_view.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
        @PrimaryKey
        @ColumnInfo(name = "word")
        var word: String
)