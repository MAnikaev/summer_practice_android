package com.itis.filmviewproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.filmviewproject.databinding.FilmItemBinding

class FilmAdapter(
    private val listOfFilms: List<Film>,
    val glide: RequestManager,
    val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<FilmItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItem =
        FilmItem(
            FilmItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onItemClick = onItemClick
        )


    override fun getItemCount(): Int {
        return listOfFilms.size
    }

    override fun onBindViewHolder(holder: FilmItem, position: Int) {
        holder.onBind(listOfFilms[position])
    }
}