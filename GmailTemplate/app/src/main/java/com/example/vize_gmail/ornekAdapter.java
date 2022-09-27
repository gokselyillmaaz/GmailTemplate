package com.example.vize_gmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ornekAdapter extends RecyclerView.Adapter<ornekAdapter.ExampleViewHolder> {

    private ArrayList<ornek_item> m_ornek_liste;

    public void setList(ArrayList<ornek_item> m_ornek_liste) {
        this.m_ornek_liste = m_ornek_liste;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mProfil;
        public TextView mGonderen;
        public TextView mKonu;
        public TextView mMail;
        public ExampleViewHolder(final View itemView) {
            super(itemView);
            mProfil = itemView.findViewById(R.id.profil_fotografi);
            mGonderen = itemView.findViewById(R.id.gonderen_isim);
            mKonu = itemView.findViewById(R.id.konu_basligi);
            mMail = itemView.findViewById(R.id.mail_mesaji);

        }
    }

    public ornekAdapter(ArrayList<ornek_item> ornek_liste){
        m_ornek_liste = ornek_liste;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ornek_item,parent,false);
        final ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        final ornek_item gecerli_item = m_ornek_liste.get(position);
        holder.mProfil.setImageResource(gecerli_item.getM_profil());
        holder.mGonderen.setText(gecerli_item.getM_gonderen());
        holder.mKonu.setText(gecerli_item.getM_konu());
        holder.mMail.setText(gecerli_item.getM_mail());
    }

    @Override
    public int getItemCount() {
        return m_ornek_liste.size();
    }


    public void filterList(ArrayList<ornek_item> filtrelenmis_liste) {
        m_ornek_liste = filtrelenmis_liste;
        notifyDataSetChanged();
    }


}
