package com.example.campushere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.campushere.databinding.FragmentRegisterBinding
import com.example.campushere.databinding.FragmentUserBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null
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
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegisterPage.setOnClickListener { registerPage(it) }

    }


    fun registerPage(view: View){

        val email = binding.editTextTextEmailAddress2.text.toString()
        val name = binding.editTextName.text.toString()
        val surname = binding.editTextSurname.text.toString()
        val department = binding.editTextDepartment.text.toString()
        val password = binding.editTextTextPassword2.text.toString()
        val passwordConfirm = binding.editTextTextPassword3.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            if(password == passwordConfirm){
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if(task.isSuccessful){


                        val uid = task.result?.user?.uid

                        if (uid == null) {

                            return@addOnCompleteListener
                        }

                        val userMap = hashMapOf(
                            "name" to name,
                            "surname" to surname,
                            "department" to department,
                            "email" to email,
                            "userType" to true //only admin false   {0,1} {admin,user}
                        )


                        FirebaseFirestore.getInstance()
                            .collection("Users")
                            .document(uid)   // doc id = auth uid
                            .set(userMap)
                            .addOnSuccessListener {
                                //user created
                                val action = RegisterFragmentDirections.actionRegisterFragmentToUserFragment()
                                Navigation.findNavController(view).navigate(action)
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(requireContext(), e.localizedMessage, Toast.LENGTH_LONG).show()
                            }



                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
                }
            }
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}