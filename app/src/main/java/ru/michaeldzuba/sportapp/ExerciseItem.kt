package ru.michaeldzuba.sportapp

data class ExerciseItem(
    val name: String,
    val count: Int,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        const val UNDEFINED_ID = 1
    }
}
