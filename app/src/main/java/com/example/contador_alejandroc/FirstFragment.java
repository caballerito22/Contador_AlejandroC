package com.example.contador_alejandroc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contador_alejandroc.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Integer P_mas_a_i;
    private Integer mas_vida_arriba;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        P_mas_a_i =20;
        mas_vida_arriba=0;

        if (savedInstanceState != null){
            P_mas_a_i = savedInstanceState.getInt("P_mas_a_i");
            mas_vida_arriba = savedInstanceState.getInt("P_mas_a_i");
        }

        binding.masVidaArriba.setOnClickListener(v -> {
            P_mas_a_i++;

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}