/*
 * Mandiri What The Hack! 2019
 * Bank Mandiri
 * Kalibrr
 * Accenture
 * Microsoft
 * RedHat
 * Copyright (c) 2019 All Rights Reserved.
 */

package com.wth.mandirisukses.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wth.mandirisukses.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Putra Nugraha (putra.graha.7@gmail.com)
 * @version PromoAdapter.java, 2019-07-20 20:49 by Putra Nugraha
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoViewHolder>  {

    public interface OnItemClickListener {
        void onItemClicked();
    }

    private int[] promoCollection;
    private OnItemClickListener onItemClickListener;

    private final LayoutInflater layoutInflater;

    public PromoAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public PromoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_promo, parent, false);
        return new PromoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoViewHolder holder, int position) {
        final int promo = this.promoCollection[position];
        holder.imageViewPoster.setImageResource(promo);
        holder.imageViewPoster.setOnClickListener(view -> {
            if (PromoAdapter.this.onItemClickListener != null) {
                PromoAdapter.this.onItemClickListener.onItemClicked();
            }
        });
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return (this.promoCollection != null) ? this.promoCollection.length : 0;
    }

    public void setPromoCollection(int[] promoCollection) {
        this.validatePromoCollection(promoCollection);
        this.promoCollection = promoCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validatePromoCollection(int[] promoCollection) {
        if (promoCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    public static class PromoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_row_promo_image)
        ImageView imageViewPoster;

        PromoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
