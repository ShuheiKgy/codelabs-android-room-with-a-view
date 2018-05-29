package com.shuheikgy.codelabs_android_room_with_a_view.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.shuheikgy.codelabs_android_room_with_a_view.dao.WordDao
import com.shuheikgy.codelabs_android_room_with_a_view.entity.Word
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        private lateinit var instance: WordRoomDatabase

        @JvmStatic
        fun getDataBase(context: Context): WordRoomDatabase {
            instance = Room.databaseBuilder(
                    context,
                    WordRoomDatabase::class.java,
                    "word_database").addCallback(sRoomDatabaseCallback).build()
            return instance
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                launch(UI) {
                    PopulateDatabase(instance).populateDatabase().await()
                }
            }
        }
    }

}