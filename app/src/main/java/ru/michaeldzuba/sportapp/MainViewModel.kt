package ru.michaeldzuba.sportapp

import androidx.lifecycle.ViewModel
import ru.michaeldzuba.sportapp.domain.GetExerciseListUseCase

class MainViewModel: ViewModel() {

    private val repository = ExerciseListRepositoryImpl

    private val getShopListUseCase = GetExerciseListUseCase(repository)

    val exerciseList = getShopListUseCase.getExerciseList()

}