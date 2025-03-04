package dam.pmdm.spyrothedragon.ui;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import dam.pmdm.spyrothedragon.R;

public class GuideDialogFragment extends DialogFragment {

    public GuideDialogFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_guide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavHostFragment navHostFragment = NavHostFragment.create(R.navigation.nav_graph_guide);
        if (getChildFragmentManager().findFragmentById(R.id.guideContainer) == null) {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.guideContainer, navHostFragment)
                    .setPrimaryNavigationFragment(navHostFragment)
                    .commit();

            view.post(() -> {
                if (navHostFragment != null) {
                    navHostFragment.getNavController().addOnDestinationChangedListener((controller, destination, arguments) -> {
                        sonido();
                    });
                }
            });

        }

    }
    private void sonido() {
        MediaPlayer mediaPlayer = MediaPlayer.create(requireContext(), R.raw.transition_sound);
        mediaPlayer.setOnCompletionListener(mp -> mp.release());
        mediaPlayer.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
}
