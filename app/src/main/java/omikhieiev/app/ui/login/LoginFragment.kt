package omikhieiev.app.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.view.*
import omikhieiev.app.R

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResult.observe(this.viewLifecycleOwner, Observer {
            result ->
            when (result) {
                is Success -> {
                    val appUIDirection = LoginFragmentDirections.showAppUI()
                    Navigation.findNavController(view).navigate(appUIDirection)
                }
                is Error -> {
                    Toast.makeText(this.context, result.message, Toast.LENGTH_LONG).show()
                    view.login.isEnabled = true
                }
            }
        })

        view.login.setOnClickListener {
            val email = view.email.text.toString()
            val password = view.password.text.toString()
            viewModel.login(email, password)
            it.isEnabled = false
        }
    }
}