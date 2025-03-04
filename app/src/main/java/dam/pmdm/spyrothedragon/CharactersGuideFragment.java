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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dam.pmdm.spyrothedragon.databinding.FragmentCharactersGuideBinding;

public class CharactersGuideFragment extends Fragment {

    private FragmentCharactersGuideBinding binding;
    private MainActivity activity;
    public CharactersGuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharactersGuideBinding.inflate(inflater, container, false);
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
            navController.navigate(R.id.action_charactersGuideFragment_to_worldsGuideFragment);
            if (bottomNav != null) {
                bottomNav.setSelectedItemId(R.id.nav_worlds);
            }
        });
        Animation aparecer = AnimationUtils.loadAnimation(getContext(), R.anim.aparecer);
        binding.bocadilloUno.startAnimation(aparecer);

        //Retraso para navegar a la siguiente pantalla
        view.postDelayed(() -> {
            navController.navigate(R.id.action_charactersGuideFragment_to_worldsGuideFragment);
            if (bottomNav != null) {
                bottomNav.setSelectedItemId(R.id.nav_worlds);
            }
        }, 4000);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}