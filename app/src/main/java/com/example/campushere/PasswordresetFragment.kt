package com.example.campushere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.campushere.databinding.FragmentPasswordresetBinding
import com.example.campushere.databinding.FragmentRegisterBinding
import com.example.campushere.databinding.FragmentUserBinding


class PasswordresetFragment : Fragment() {

    private var _binding : FragmentPasswordresetBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPasswordresetBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPasswordReset.setOnClickListener { passwordReset(it) }

    }

    fun passwordReset(view:View){
        val action = PasswordresetFragmentDirections.actionPasswordresetFragmentToUserFragment()
        Navigation.findNavController(view).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}