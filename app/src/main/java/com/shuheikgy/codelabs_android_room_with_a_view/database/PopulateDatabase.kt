package com.shuheikgy.codelabs_android_room_with_a_view.database

import com.shuheikgy.codelabs_android_room_with_a_view.dao.WordDao
import com.shuheikgy.codelabs_android_room_with_a_view.entity.Word
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

class PopulateDatabase(database: WordRoomDatabase) {

    private var dao: WordDao

    init {
        dao = database.wordDao()
    }

    fun populateDatabase() = async(CommonPool) {
        dao.deleteAll()
        var word = Word("Hello")
        dao.insert(word)
        word = Word("World")
        dao.insert(word)
        return@async
    }

}