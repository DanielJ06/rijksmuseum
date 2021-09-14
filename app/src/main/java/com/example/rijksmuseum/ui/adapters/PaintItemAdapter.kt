package com.example.rijksmuseum.ui.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.models.PaintProps
import com.example.rijksmuseum.R
import com.example.rijksmuseum.databinding.ItemDetailsBinding
import com.example.rijksmuseum.ui.fragments.home.HomeFragment
import com.example.rijksmuseum.ui.fragments.home.HomeFragmentDirections

class PaintItemAdapter : PagingDataAdapter<PaintProps, PaintItemAdapter.PaintViewHolder>(
    UIMODEL_COMPARATOR
) {

    class PaintViewHolder(
        private val view: ItemDetailsBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bind(paint: PaintProps) {
            with(view) {
                paintImage.transitionName = "paint_image_${paint.id}"

                itemContainer.setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeFragmentToPaintDetailsFragment(
                        objNumber = paint.objNumber
                    )
                    val extras = FragmentNavigatorExtras(paintImage to "paint_cover")
                    it.findNavController().navigate(
                        action,
                        extras
                    )
                }
                this.paint = paint
                Glide
                    .with(paintImage)
                    .load(paint.image)
                    .placeholder(ColorDrawable(Color.GRAY))
                    .into(paintImage)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaintViewHolder {
        val view = ItemDetailsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PaintViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaintViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }

    companion object {
        val UIMODEL_COMPARATOR = object : DiffUtil.ItemCallback<PaintProps>() {
            override fun areContentsTheSame(oldItem: PaintProps, newItem: PaintProps): Boolean =
                oldItem.title == newItem.title

            override fun areItemsTheSame(oldItem: PaintProps, newItem: PaintProps): Boolean =
                oldItem.title == newItem.title && oldItem.image == newItem.image
        }
    }

}