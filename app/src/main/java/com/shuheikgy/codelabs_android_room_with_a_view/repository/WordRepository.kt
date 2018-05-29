package com.shuheikgy.codelabs_android_room_with_a_view.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import com.shuheikgy.codelabs_android_room_with_a_view.dao.WordDao
import com.shuheikgy.codelabs_android_room_with_a_view.database.WordRoomDatabase
import com.shuheikgy.codelabs_android_room_with_a_view.entity.Word
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

class WordRepository(context: Context) {

    private var dao: WordDao
    var allWords: LiveData<List<Word>>

    init {
        val database = WordRoomDatabase.getDataBase(context)
        dao = database.wordDao()
        allWords = dao.getAllWords()
    }

    fun insert(word: Word) = async(CommonPool){
        dao.insert(word)
    }

}