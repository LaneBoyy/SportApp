package ru.michaeldzuba.sportapp.domain

import ru.michaeldzuba.sportapp.ExerciseItem

class AddExerciseItemUseCase(private val exerciseListRepository: ExerciseListRepository) {

    fun addExerciseItem(exerciseItem: ExerciseItem) {
        exerciseListRepository.addExerciseItem(exerciseItem)
    }
}