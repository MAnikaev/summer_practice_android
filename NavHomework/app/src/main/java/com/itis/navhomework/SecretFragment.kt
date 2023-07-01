package com.itis.navhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.itis.navhomework.databinding.FragmentSalesBinding
import com.itis.navhomework.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {

    private var binding: FragmentSecretBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)

        val message = arguments?.getString("SECRET_MESSAGE")
        Snackbar.make(binding!!.root, "$message", Snackbar.LENGTH_LONG).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}