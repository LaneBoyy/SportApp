package ru.michaeldzuba.sportapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.michaeldzuba.sportapp.domain.ExerciseListRepository

object ExerciseListRepositoryImpl : ExerciseListRepository {

    private val exerciseListLD = MutableLiveData<List<ExerciseItem>>()
    private val exerciseList = sortedSetOf<ExerciseItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var autoIncrementId = 0

    init {

        val item0 = ExerciseItem("", 1)

//        val item1 = ExerciseItem("Отжимания", 15)
//        val item2 = ExerciseItem("Отжимания", 15)
//        val item3 = ExerciseItem("Отжимания", 15)
//        val item4 = ExerciseItem("Отжимания", 15)
//        val item5 = ExerciseItem("Отжимания", 15)
//        val item6 = ExerciseItem("Отжимания", 15)
//        val item7 = ExerciseItem("Отжимания", 15)
//        val item8 = ExerciseItem("Отжимания", 15)
//        val item9 = ExerciseItem("Отжимания", 15)

        addExerciseItem(item0)

        for (i in 0 until 10) {
            val item = ExerciseItem("Отжимания", i)
            addExerciseItem(item)
        }
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
