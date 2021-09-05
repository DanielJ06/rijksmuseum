package com.example.rijksmuseum.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.PaintProps
import com.example.rijksmuseum.R

class PaintItemAdapter : PagingDataAdapter<PaintProps, PaintItemAdapter.PaintViewHolder>(
    UIMODEL_COMPARATOR
) {

    private var paints = emptyList<PaintProps>()

    class PaintViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.paint_title)

        fun bind(paint: PaintProps) {
            title.text = paint.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaintViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_details, parent, false)
        return PaintViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaintViewHolder, position: Int) {
        holder.bind(paints[position])

    }

    override fun getItemCount(): Int = paints.size

    companion object {
        val UIMODEL_COMPARATOR = object : DiffUtil.ItemCallback<PaintProps>() {
            override fun areContentsTheSame(oldItem: PaintProps, newItem: PaintProps): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: PaintProps, newItem: PaintProps): Boolean =
                oldItem.title == newItem.title
        }
    }

}