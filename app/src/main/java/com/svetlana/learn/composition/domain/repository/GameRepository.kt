package com.svetlana.learn.composition.domain.repository

import com.svetlana.learn.composition.domain.entity.GameSettings
import com.svetlana.learn.composition.domain.entity.Level
import com.svetlana.learn.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ) : Question

    fun getGameSettings(level: Level) : GameSettings
}