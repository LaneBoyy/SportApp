package ru.michaeldzuba.sportapp.domain

import androidx.lifecycle.LiveData
import ru.michaeldzuba.sportapp.ExerciseItem

interface ExerciseListRepository {

    fun addExerciseItem(exerciseItem: ExerciseItem)

    fun getExerciseItem(exerciseItemId: Int): ExerciseItem

    fun getExerciseList(): LiveData<List<ExerciseItem>>
}