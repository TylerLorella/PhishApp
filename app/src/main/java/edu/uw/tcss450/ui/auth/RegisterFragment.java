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


import edu.uw.tcss450.databinding.FragmentRegisterBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();

        //return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonRegisterRegister.setOnClickListener(this::handleRegister);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void handleRegister(View view) {
        if (view == binding.buttonRegisterRegister) {
            Log.d("REGISTER", "Registering");
            String email = binding.editTextRegisterEmail.getText().toString();
            //check account info

            //navigate to main activity
            RegisterFragmentDirections.ActionRegisterFragmentToMainActivity directions =
                    RegisterFragmentDirections.actionRegisterFragmentToMainActivity(email, "");

            Navigation.findNavController(getView()).navigate(directions);
        }
    }




}
