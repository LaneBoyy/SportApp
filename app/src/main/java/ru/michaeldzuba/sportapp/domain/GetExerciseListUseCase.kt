package ru.michaeldzuba.sportapp.domain

import androidx.lifecycle.LiveData
import ru.michaeldzuba.sportapp.ExerciseItem

class GetExerciseListUseCase(private val exerciseListRepository: ExerciseListRepository) {

    fun getExerciseList(): LiveData<List<ExerciseItem>> {
        return exerciseListRepository.getExerciseList()
    }
}