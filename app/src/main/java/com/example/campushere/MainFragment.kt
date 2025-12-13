package com.example.campushere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.campushere.databinding.FragmentMainBinding
import com.example.campushere.databinding.FragmentRegisterBinding


class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var incidentList : ArrayList<Incident>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val caution = Incident("caution","Yol calismasi","Gün boyunca mühendislik A kapısından giriş olmayacaktır. Yol bakım çalışması vardır.")

        val caution1 = Incident("caution","Yol calismasi","Gün boyunca mühendislik A kapısından giriş olmayacaktır. Yol bakım çalışması vardır.")
        val caution2 = Incident("caution","Yol calismasi","Gün boyunca mühendislik A kapısından giriş olmayacaktır. Yol bakım çalışması vardır.")
        val caution3 = Incident("caution","Yol calismasi","Gün boyunca mühendislik A kapısından giriş olmayacaktır. Yol bakım çalışması vardır.")

        incidentList = arrayListOf(caution1,caution2,caution3)

        val adapter= IncidentAdapter(incidentList)


        binding.recyclerViewItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewItems.adapter = adapter
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}