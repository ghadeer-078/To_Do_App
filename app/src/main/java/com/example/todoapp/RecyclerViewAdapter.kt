package com.example.todoapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemRowBinding

class ToDoItem (val content: String, var isSelected: Boolean = false)


class RecyclerViewAdapter(private val items: ArrayList<ToDoItem>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position].content

        holder.binding.apply {
            cbItem.text = item
            cbItem.setOnCheckedChangeListener { _, _ ->
                if (cbItem.isChecked) {
                    cbItem.setTextColor(Color.GRAY)
                    items[position].isSelected = true
                }
                else{
                    cbItem.setTextColor(Color.BLACK)
                    items[position].isSelected = false
                }
            }
        }
    }

    override fun getItemCount() = items.size

}