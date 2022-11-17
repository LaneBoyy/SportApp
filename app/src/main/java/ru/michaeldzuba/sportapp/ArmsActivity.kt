package ru.michaeldzuba.sportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class ArmsActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var exerciseListAdapter: ExerciseListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arms)



        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.exerciseList.observe(this) {
            exerciseListAdapter.submitList(it)
        }
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