package com.itis.navhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.itis.navhomework.databinding.FragmentAccountBinding
import com.itis.navhomework.databinding.FragmentSalesBinding

class AccountFragment : Fragment(R.layout.fragment_account) {

    private var binding: FragmentAccountBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountBinding.bind(view)

        binding?.run {
            secretButton.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("SECRET_MESSAGE", "AccountFragment")
                findNavController().navigate(R.id.action_accountFragment_to_secretFragment, bundle)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}