package com.example.yemeksepeti_mobil_android_teame_hw3.ui.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.yemeksepeti_mobil_android_teame_hw3.activity.MainActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.SharedPrefManager
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentLoginFieldsBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment() {
    private lateinit var _binding: FragmentLoginFieldsBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginFieldsBinding.inflate(inflater, container, false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.loginButton.setOnClickListener {
            val email = _binding.editTextEmailAdress.text.toString()
            val password = _binding.editTextPassword.text.toString()
                viewModel.login(email, password)
                    .observe(viewLifecycleOwner, Observer {
                        when (it.status) {
                            Resource.Status.LOADING -> {

                            }
                            Resource.Status.SUCCESS -> {
                                val intent = Intent(context, MainActivity::class.java)
                                startActivity(intent)
                                requireActivity().finish()
                            }
                            Resource.Status.ERROR -> {
                                val dialog = AlertDialog.Builder(context)
                                    .setTitle("Error")
                                    .setMessage("${it.message}")
                                    .setPositiveButton("ok") { dialog, button ->
                                        dialog.dismiss()
                                    }
                                dialog.show()
                            }
                        }
                    })

        }
    }
}