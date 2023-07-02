package com.itis.filmviewproject

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.filmviewproject.databinding.FilmItemBinding

class FilmItem(
    val binding: FilmItemBinding,
    val glide: RequestManager,
    val onItemClick: (Int) -> Unit
) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)

    fun onBind(film: Film){
        binding.run {
            filmCardName.text = film.name
            filmCardRating.text = film.rating.toString()

            glide
                .load(film.url)
                .error(R.drawable.image_not_found)
                .apply(options)
                .into(filmCardImage)

            root.setOnClickListener{
                onItemClick(film.id)
            }
        }
    }
}