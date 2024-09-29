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
    private Integer vida1;
    private Integer pocion1;
    private Integer vida2;
    private Integer pocion2;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        //reset();
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vida1 =20;
        vida2 = 20;
        pocion1=0;
        pocion2=0;

        if (savedInstanceState != null){
            vida1 = savedInstanceState.getInt("vida1");
            pocion1 = savedInstanceState.getInt("pocion1");
        }

        binding.PMasAI.setOnClickListener(v -> {
            pocion1++;
            refresh();
        });
        binding.PMenosAD.setOnClickListener(v -> {
            pocion1--;
            refresh();
        });
        binding.PMasAbajoI.setOnClickListener(v -> {
            pocion2++;
            refresh();
        });
        binding.PMenosAbajoD.setOnClickListener(v -> {
            pocion2--;
            refresh();
        });
        binding.masVidaArriba.setOnClickListener(v -> {
            vida1++;
            refresh();
        });
        binding.menosVidaArriba.setOnClickListener(v -> {
            vida1--;
            refresh();
        });
        binding.masVidaAbajo.setOnClickListener(v -> {
            vida2++;
            refresh();
        });
        binding.menosVidaAbajo.setOnClickListener(v -> {
            vida2--;
            refresh();
        });
        binding.flechaArriba.setOnClickListener(v -> {
            vida2--;
            vida1++;
            refresh();
        });
        binding.flechaAbajo.setOnClickListener(v -> {
            vida2++;
            vida1--;
            refresh();
        });


    }
    private void refresh() {
        binding.txp1a.setText(vida1 + "/" +pocion1);
        binding.txp1abajo.setText(vida2 + "/" + pocion2);
    }


    private void reset() {
        pocion1 = 0;
        pocion2 = 0;
        vida1 = 20;
        vida2 = 20;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}