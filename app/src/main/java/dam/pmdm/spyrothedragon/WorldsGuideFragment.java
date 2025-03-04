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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dam.pmdm.spyrothedragon.databinding.FragmentWorldsGuideBinding;

public class WorldsGuideFragment extends Fragment {

    private FragmentWorldsGuideBinding binding;
    public WorldsGuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorldsGuideBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = NavHostFragment.findNavController(this);
        BottomNavigationView bottomNav = getActivity().findViewById(R.id.navView);
        binding.saltarGuia.saltarGuia.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).cerrarGuia();
            }
        });
        binding.siguiente.siguiente.setOnClickListener(v -> {
            if (bottomNav != null) {
                bottomNav.setSelectedItemId(R.id.nav_collectibles);
            }
            navController.navigate(R.id.action_worldsGuideFragment_to_collectiblesGuideFragment);
        });
        //Retraso para navegar a la siguiente pantalla
        view.postDelayed(() -> {
            navController.navigate(R.id.action_worldsGuideFragment_to_collectiblesGuideFragment);
            if (bottomNav != null) {
                bottomNav.setSelectedItemId(R.id.nav_collectibles);
            }
        }, 4000);

        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.pulse(binding.parpadeoBotonNav, 1000);
        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}