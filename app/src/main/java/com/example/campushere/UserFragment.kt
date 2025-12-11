package com.example.campushere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.campushere.databinding.FragmentUserBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class UserFragment : Fragment() {


    private var _binding : FragmentUserBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
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
        /*val loginedUser = auth.currentUser
        if(loginedUser!= null){
            val action = UserFragmentDirections.actionUserFragmentToMainFragment2()
            Navigation.findNavController(view).navigate(action)
        }*/
    }

    fun goRegister(view: View){
        val action = UserFragmentDirections.actionUserFragmentToRegisterFragment2()
        Navigation.findNavController(view).navigate(action)
    }

    fun login(view: View){

        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {

                //user logged in
                val action = UserFragmentDirections.actionUserFragmentToMainFragment2()
                Navigation.findNavController(view).navigate(action)

            }.addOnFailureListener { exception ->
                Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }

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