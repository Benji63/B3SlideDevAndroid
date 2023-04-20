package com.example.applicationliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.applicationliste.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final Planete[] initData = {
            new Planete("Mercure",58),
            new Planete("Venus",108),
            new Planete("Venus",125),
            new Planete("Venus",198),
            new Planete("Venus",178),
            new Planete("Venus",102),
            new Planete("Venus",136),
            new Planete("Venus",102),
            new Planete("Terre",158)
    };

    private List<Planete> planeteList;

    private PlanetAdapter adapter;

    private ActivityMainBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planeteList = new ArrayList<>(Arrays.asList(initData));
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());

        ui.recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        ui.recycler.setLayoutManager(lm);

        adapter = new PlanetAdapter(planeteList);
        ui.recycler.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ui.recycler.addItemDecoration(dividerItemDecoration);

        adapter = new PlanetAdapter(planeteList);

        adapter.setOnItemClickListener(this::onItemClick);

        }
        private void onItemClick(int position) {
            Planete planete = planeteList.get(position);
        }
    }
