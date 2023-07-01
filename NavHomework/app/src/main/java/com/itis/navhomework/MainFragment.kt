package com.itis.navhomework

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itis.navhomework.databinding.FragmentMainBinding
import com.itis.navhomework.databinding.FragmentSalesBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        Log.e("TTTTTTTTTT","Main fragment started")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}