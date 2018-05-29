package com.shuheikgy.codelabs_android_room_with_a_view.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.shuheikgy.codelabs_android_room_with_a_view.dao.WordDao
import com.shuheikgy.codelabs_android_room_with_a_view.entity.Word

@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object Factory {

        @JvmStatic
        fun getDataBase(context: Context): WordRoomDatabase {
            return Room.databaseBuilder(
                    context,
                    WordRoomDatabase::class.java,
                    "word_database").build()
        }
    }

}