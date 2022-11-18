package ru.michaeldzuba.sportapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import ru.michaeldzuba.sportapp.*

class ExercisesActivity : AppCompatActivity() {

    private lateinit var exerciseListAdapter: ExerciseListAdapter
    private lateinit var exerciseItem: LiveData<ExerciseItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exersices)

        val armsEx: List<ExerciseItem> = listOf(
            ExerciseItem("", 1),
            ExerciseItem("Отжимания", 10),
            ExerciseItem("Подтяшивания узким хватом", 5),
            ExerciseItem("Подтяшивания широким хватом", 5),
            ExerciseItem("Подтяшивания обратгным хватом", 10),
            ExerciseItem("Планка на вытянутых руках", 10)
        )

        val legsEx: List<ExerciseItem> = listOf(
            ExerciseItem("", 1),
            ExerciseItem("Приседания", 25),
            ExerciseItem("Приседания с гантелями", 15)
        )

        val pressEx: List<ExerciseItem> = listOf(
            ExerciseItem("", 1),
            ExerciseItem("Планка", 60),
            ExerciseItem("Поднятие туловища", 30),
            ExerciseItem("Качаем пресс", 60),
            ExerciseItem("Качай сука пресс", 10)
        )

        val backEx: List<ExerciseItem> = listOf(
            ExerciseItem("", 1),
            ExerciseItem("Один - два раза", 60),
            ExerciseItem("Вот это", 30),
            ExerciseItem("Упраждение делаешь", 5),
            ExerciseItem("И спина болеть не будет", 5)
        )

        val hashMap: HashMap<String, List<ExerciseItem>> = hashMapOf(
            ExerciseItem.ARMS_EX_KEY to armsEx,
            ExerciseItem.PRESS_EX_KEY to pressEx,
            ExerciseItem.LEGS_EX_KEY to legsEx,
            ExerciseItem.BACK_EX_KEY to backEx
        )

        val exerciseList: List<ExerciseItem> = when (intent.getStringExtra("EX")) {
            "Arms" -> hashMap.getValue(ExerciseItem.ARMS_EX_KEY)
            "Press" -> hashMap.getValue(ExerciseItem.PRESS_EX_KEY)
            "Legs" -> hashMap.getValue(ExerciseItem.LEGS_EX_KEY)
            "Back" -> hashMap.getValue(ExerciseItem.BACK_EX_KEY)
            else -> {
                listOf()
            }
        }

        setupRecyclerView()
        exerciseListAdapter.submitList(exerciseList)

    }

    private fun setupRecyclerView() {
        val rvExerciseList = findViewById<RecyclerView>(R.id.rv)
        with(rvExerciseList) {
            exerciseListAdapter = ExerciseListAdapter()
            adapter = exerciseListAdapter
            recycledViewPool.setMaxRecycledViews(
                ExerciseListAdapter.VIEW_TYPE_EXERCISE,
                ExerciseListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ExerciseListAdapter.VIEW_TYPE_IMAGE,
                ExerciseListAdapter.MAX_POOL_SIZE
            )
            setupClickListener()
        }
    }

    private fun setupClickListener() {
        exerciseListAdapter.onExerciseItemClickListener = {
                val intent = Intent(this, ExerciseItemActivity::class.java)
                startActivity(intent)
        }
    }
}