package ru.michaeldzuba.sportapp

data class ExerciseItem(
    val name: String,
    val count: Int,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
        const val ARMS_EX_KEY = "ARMS_EX"
        const val PRESS_EX_KEY = "PRESS_EX"
        const val LEGS_EX_KEY = "LEGS_EX"
        const val BACK_EX_KEY = "BACK_EX"
    }
}
