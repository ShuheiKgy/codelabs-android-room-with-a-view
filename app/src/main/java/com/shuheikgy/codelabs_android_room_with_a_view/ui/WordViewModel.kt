package com.shuheikgy.codelabs_android_room_with_a_view.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.shuheikgy.codelabs_android_room_with_a_view.entity.Word
import com.shuheikgy.codelabs_android_room_with_a_view.repository.WordRepository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: WordRepository

    var allWord: LiveData<List<Word>>

    init {
        repository = WordRepository(application)
        allWord = repository.allWords

    }

    fun insert(word: Word) {
        launch(UI) {
            repository.insert(word).await()
        }
    }
}