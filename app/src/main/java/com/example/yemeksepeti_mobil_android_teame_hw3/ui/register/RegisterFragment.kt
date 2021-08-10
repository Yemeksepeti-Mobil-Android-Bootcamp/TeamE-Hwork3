package com.example.yemeksepeti_mobil_android_teame_hw3.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.yemeksepeti_mobil_android_teame_hw3.activity.MainActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentSignupBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var _binding: FragmentSignupBinding


    private val viewModel: RegisterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.button.setOnClickListener {
            val name = _binding.editTextName.text.toString()
            val email = _binding.editTextEmail.text.toString()
            val password = _binding.editTextPassword.text.toString()
            viewModel.register(email, name, password)
                .observe(viewLifecycleOwner, {
                    when (it.status) {
                        Resource.Status.LOADING -> {
                        }
                        Resource.Status.SUCCESS -> {
                            val intent = Intent(context, MainActivity::class.java)
                            startActivity(intent)
                            requireActivity().finish()
                        }
                        Resource.Status.ERROR -> {
                        }
                    }
                })
        }
    }
}