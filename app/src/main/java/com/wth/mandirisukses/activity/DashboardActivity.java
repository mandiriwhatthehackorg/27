/*
 * Mandiri What The Hack! 2019
 * Bank Mandiri
 * Kalibrr
 * Accenture
 * Microsoft
 * RedHat
 * Copyright (c) 2019 All Rights Reserved.
 */

package com.wth.mandirisukses.activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wth.mandirisukses.R;
import com.wth.mandirisukses.adapter.PromoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Putra Nugraha (putra.graha.7@gmail.com)
 * @version DashboardActivity.java, 2019-07-20 20:32 by Putra Nugraha
 */

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.recycler_dashboard_promo)
    RecyclerView recyclerViewDashboardPromo;

    private PromoAdapter promoAdapter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        unbinder = ButterKnife.bind(this);
        initPromoRecycler();
    }

    private void initPromoRecycler() {
        int[] imageArray = {R.drawable.promo, R.drawable.promo, R.drawable.promo};
        promoAdapter = new PromoAdapter(this);
        promoAdapter.setPromoCollection(imageArray);
        promoAdapter.setOnItemClickListener(() -> {
            // TODO intent here
        });

        recyclerViewDashboardPromo.setLayoutManager(
                new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false));
        recyclerViewDashboardPromo.setAdapter(promoAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
