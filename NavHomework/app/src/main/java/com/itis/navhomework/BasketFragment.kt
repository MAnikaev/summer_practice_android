package com.itis.navhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itis.navhomework.databinding.FragmentBasketBinding
import com.itis.navhomework.databinding.FragmentSalesBinding

class BasketFragment : Fragment(R.layout.fragment_basket) {

    private var binding:FragmentBasketBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}