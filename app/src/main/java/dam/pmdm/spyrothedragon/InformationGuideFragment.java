package dam.pmdm.spyrothedragon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.spyrothedragon.databinding.FragmentInformationGuideBinding;

public class InformationGuideFragment extends Fragment {

    private FragmentInformationGuideBinding binding;
    public InformationGuideFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = dam.pmdm.spyrothedragon.databinding.FragmentInformationGuideBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = NavHostFragment.findNavController(this);
        binding.saltarGuia.saltarGuia.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).cerrarGuia();
            }
        });
        binding.siguiente.siguiente.setOnClickListener(v ->
                navController.navigate(R.id.action_informationGuideFragment_to_summaryGuideFragment)
        );
        //Retraso para navegar a la siguiente pantalla
        view.postDelayed(() -> {
            navController.navigate(R.id.action_informationGuideFragment_to_summaryGuideFragment);
        }, 5000);
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.pulse(binding.parpadeoInformacion, 1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}