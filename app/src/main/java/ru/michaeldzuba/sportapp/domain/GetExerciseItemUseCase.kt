package ru.michaeldzuba.sportapp.domain

import ru.michaeldzuba.sportapp.ExerciseItem

class GetExerciseItemUseCase(private val exerciseListRepository: ExerciseListRepository) {

    fun getExerciseItem(exerciseItemId: Int): ExerciseItem {
        return exerciseListRepository.getExerciseItem(exerciseItemId)
    }
}