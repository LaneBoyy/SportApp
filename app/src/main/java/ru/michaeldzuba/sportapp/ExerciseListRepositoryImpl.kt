package ru.michaeldzuba.sportapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.michaeldzuba.sportapp.domain.ExerciseListRepository

object ExerciseListRepositoryImpl : ExerciseListRepository {

    private val exerciseListLD = MutableLiveData<List<ExerciseItem>>()
    private val exerciseList = sortedSetOf<ExerciseItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var autoIncrementId = 0

    init {
        val item = ExerciseItem("Отжимания", 15)
        addExerciseItem(item)
    }

    override fun addExerciseItem(exerciseItem: ExerciseItem) {
        if (exerciseItem.id == ExerciseItem.UNDEFINED_ID) {
            exerciseItem.id = autoIncrementId++
        }
        exerciseList.add(exerciseItem)
        updateList()
    }

    override fun getExerciseItem(exerciseItemId: Int): ExerciseItem {
        return exerciseList.find {
            it.id == exerciseItemId
        } ?: throw  RuntimeException("Element with id $exerciseItemId not found")
    }

    override fun getExerciseList(): LiveData<List<ExerciseItem>> {
        return exerciseListLD
    }

    private fun updateList() {
        exerciseListLD.value = exerciseList.toList()
    }
}
