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

import dam.pmdm.spyrothedragon.databinding.FragmentCollectiblesGuideBinding;

public class CollectiblesGuideFragment extends Fragment {

    public CollectiblesGuideFragment() {
        // Required empty public constructor
    }

    private FragmentCollectiblesGuideBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = dam.pmdm.spyrothedragon.databinding.FragmentCollectiblesGuideBinding.inflate(inflater, container, false);
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
        binding.siguiente.siguiente.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).showInfoDialog();
            }
            navController.navigate(R.id.action_collectiblesGuideFragment_to_informationGuideFragment);
        });
        //Retraso para navegar a la siguiente pantalla
        view.postDelayed(() -> {
            navController.navigate(R.id.action_collectiblesGuideFragment_to_informationGuideFragment);
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).showInfoDialog();
            }
        }, 4000);
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.pulse(binding.flechaIndica, 1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}