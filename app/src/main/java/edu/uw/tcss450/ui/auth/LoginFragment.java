package edu.uw.tcss450.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import edu.uw.tcss450.LoginFragmentDirections;
import edu.uw.tcss450.databinding.FragmentLoginBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);


        //TODO remove this
        binding.editTextLoginEmail.setText("a@b");
        binding.editTextLoginPassword.setText("Abc12345!");


        //return inflater.inflate(R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonLoginRegister.setOnClickListener(this::handleRegister);
        binding.buttonLoginSignIn.setOnClickListener(this::handleSignIn);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void handleRegister(View view) {
        if (view == binding.buttonLoginRegister) {
            Log.d("LOGIN", "Register");
            //Navigate to register

            //LoginFragmentDirections.ActionLoginFragmentToRegisterFragment directions =
            //        LoginFragmentDirections.actionLoginFragmentToRegisterFragment();

            Navigation.findNavController(getView()).navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment());
        }
    }

    private void handleSignIn(View view) {
        if (view == binding.buttonLoginSignIn) {
            Log.d("LOGIN", "Signing In");
            String email = binding.editTextLoginEmail.getText().toString();
            //perform email & password check
            //navigate to success

            LoginFragmentDirections.ActionLoginFragmentToMainActivity directions =
                    LoginFragmentDirections.actionLoginFragmentToMainActivity(email, "");


            Navigation.findNavController(getView()).navigate(directions);
        }
    }

}
