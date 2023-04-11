package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _currentScrambledWord =  MutableLiveData<String>()
    val currentScrambledWord : LiveData<String> get() = _currentScrambledWord
    private val wordsList = ArrayList<String>()



    private val _score = MutableLiveData(0)
    val score get() : LiveData<Int> = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount get() : LiveData<Int> = _currentWordCount


    init {
        Log.e("GameFragment", ": GameViewModel created")
        getNextWord()
    }

    private lateinit var currentWord: String


    fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        wordsList.add(currentWord)

        Log.e("TAG", "getNextWord: ${currentWord}")

        _currentScrambledWord.value = String(tempWord)
        _currentWordCount.value = (_currentWordCount.value)?.inc()

    }

    private fun increaseScore() {
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        return if (playerWord.equals(currentWord, true)) {
            increaseScore()
            true
        } else
            false
    }


    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }



    fun reinitalizeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }


}