package com.svetlana.learn.composition.domain.usecases

import com.svetlana.learn.composition.domain.entity.GameSettings
import com.svetlana.learn.composition.domain.entity.Level
import com.svetlana.learn.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings{
        return repository.getGameSettings(level)
    }
}