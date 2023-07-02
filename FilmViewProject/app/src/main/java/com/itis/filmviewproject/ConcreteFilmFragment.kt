package com.itis.filmviewproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.filmviewproject.databinding.FragmentConcreteFilmBinding


class ConcreteFilmFragment : Fragment(R.layout.fragment_concrete_film) {
    var binding: FragmentConcreteFilmBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConcreteFilmBinding.bind(view)

        val id = arguments?.getInt("FILM_ID")
        val film = findFilmByIdOrNull(id)

        binding?.run {
            filmId.text = "ID: " + film?.id.toString()
            filmName.text = "Название: " + film?.name
            filmDescription.text = "Описание: " + film?.description
            rating.text = "Рейтинг: " + film?.rating
            Glide.with(binding!!.root).load(film?.url).into(filmImage)
            backButton.setOnClickListener{
                findNavController().navigate(R.id.action_concreteFilmFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

    private fun findFilmByIdOrNull(id: Int?) : Film? {
        for (film in FilmRepository.listOfFilms) {
            if(film.id == id)
                return film
        }
        return null
    }
}