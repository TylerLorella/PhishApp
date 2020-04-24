package edu.uw.tcss450.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import edu.uw.tcss450.SuccessFragmentArgs;
import edu.uw.tcss450.databinding.FragmentSuccessBinding;
import edu.uw.tcss450.model.UserInfoViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuccessFragment extends Fragment {

    private FragmentSuccessBinding binding;

    public SuccessFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSuccessBinding.inflate(inflater, container, false);
        return binding.getRoot();

        //return inflater.inflate(R.layout.fragment_success, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserInfoViewModel model = new ViewModelProvider(getActivity()).get(UserInfoViewModel.class);
        binding.textViewSuccessUser.setText(model.getEmail());



        //reference SafeArgs object
        //SuccessFragmentArgs args = SuccessFragmentArgs.fromBundle(getArguments());

        //modify the contents of the username display
        //binding.textViewSuccessUser.setText(args.getEmail());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
