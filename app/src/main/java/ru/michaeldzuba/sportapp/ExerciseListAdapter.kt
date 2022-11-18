package ru.michaeldzuba.sportapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class ExerciseListAdapter :
    ListAdapter<ExerciseItem, ExerciseItemViewHolder>(ExerciseItemDiffCallback()) {

    var onExerciseItemClickListener: ((ExerciseItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_IMAGE -> R.layout.first_card_on_rv
            VIEW_TYPE_EXERCISE -> R.layout.exercise_item_for_rv
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ExerciseItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ExerciseItemViewHolder, position: Int) {
        val exerciseItem = getItem(position)
        with(viewHolder) {
            tvName.text = exerciseItem.name
            tvCount.text = exerciseItem.count.toString()
            if (!tvName.text.equals("")) {
                view.setOnClickListener {
                    onExerciseItemClickListener?.invoke(exerciseItem)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.name == "") {
            VIEW_TYPE_IMAGE
        } else {
            VIEW_TYPE_EXERCISE
        }
    }

    companion object {

        const val VIEW_TYPE_IMAGE = 100
        const val VIEW_TYPE_EXERCISE = 101

        const val MAX_POOL_SIZE = 10
    }
}