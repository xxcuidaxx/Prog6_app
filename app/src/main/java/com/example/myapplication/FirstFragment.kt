package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.text.DynamicLayout
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import java.security.SecureRandom
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        binding.toastButton.setOnClickListener{
//            val qwe = binding.firstLayout
//            val random = SecureRandom()
//
//        }


        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            val showCountTextView = binding.textviewFirst


            val currentCount = showCountTextView.text.toString().toInt()

            val random = SecureRandom()
            showCountTextView.setTextColor(Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256)))

            val action =  FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)


        }

        binding.toastButton.setOnClickListener {
            val random = SecureRandom()
            binding.firstLayout.setBackgroundColor(Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256)))

            val qwe = arrayListOf("Hello Toast","Hi","Aloha","Good Day Sir","Bonjour","Kamusta")
            val myToast = Toast.makeText(context, qwe.random(), Toast.LENGTH_SHORT)
            myToast.show()
        }


        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun countMe(view: View) {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        showCountTextView.text = count.toString()


        val random = SecureRandom()
        showCountTextView.setTextColor(Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256)))




    }
}




