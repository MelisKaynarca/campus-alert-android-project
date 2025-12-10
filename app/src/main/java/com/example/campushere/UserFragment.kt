package com.example.campushere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.campushere.databinding.FragmentUserBinding


class UserFragment : Fragment() {


    private var _binding : FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener { goRegister(it) }
        binding.btnLogin.setOnClickListener { login(it) }
        binding.textViewResetPassword.setOnClickListener { resetPasswordPage((it)) }
    }

    fun goRegister(view: View){
        val action = UserFragmentDirections.actionUserFragmentToRegisterFragment2()
        Navigation.findNavController(view).navigate(action)
    }

    fun login(view: View){
        val action = UserFragmentDirections.actionUserFragmentToMainFragment2()
        Navigation.findNavController(view).navigate(action)
    }

    fun resetPasswordPage(view: View){
        val action = UserFragmentDirections.actionUserFragmentToPasswordresetFragment2()
        Navigation.findNavController(view).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}