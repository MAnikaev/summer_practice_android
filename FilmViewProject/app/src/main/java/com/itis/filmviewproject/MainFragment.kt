package com.itis.filmviewproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.filmviewproject.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    var binding: FragmentMainBinding? = null
    var adapter: FilmAdapter? = null

    private fun initAdapter() {
        adapter = FilmAdapter(
            listOfFilms = FilmRepository.listOfFilms,
            glide = Glide.with(this),
            onItemClick = {
                val bundle = Bundle()
                bundle.putInt("FILM_ID", it)
                findNavController().navigate(R.id.action_mainFragment_to_concreteFilmFragment, bundle)
            })
        binding?.rvFilms?.adapter = adapter
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}