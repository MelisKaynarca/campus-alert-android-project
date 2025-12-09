package com.example.campushere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.campushere.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {


    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener { register(it) }
        binding.btnLogin.setOnClickListener { login(it) }
    }

    fun register(view: View){

    }

    fun login(view: View){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}