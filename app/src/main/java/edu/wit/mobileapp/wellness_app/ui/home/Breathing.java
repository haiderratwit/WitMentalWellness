package edu.wit.mobileapp.wellness_app.ui.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.wit.mobileapp.wellness_app.R;
import edu.wit.mobileapp.wellness_app.databinding.FragmentHomeBinding;

public class Breathing extends Fragment {

    private GuidedMeditationViewModel guidedMeditationViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.breathing_fragment, container, false);

        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.guided_3_min);


        Button play = root.findViewById(R.id.play_meditation);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }


            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}