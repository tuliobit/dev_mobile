package com.example.dev_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev_mobile.modelo.Alimento;

import java.util.List;

public class AlimentoAdapter extends RecyclerView.Adapter<AlimentoAdapter.AlimentoViewHolder> {
    private List<Alimento> alimentos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Alimento alimento);
    }

    public AlimentoAdapter(List<Alimento> alimentos, OnItemClickListener listener) {
        this.alimentos = alimentos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlimentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alimento, parent, false);
        return new AlimentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlimentoViewHolder holder, int position) {
        Alimento alimento = alimentos.get(position);
        holder.bind(alimento, listener);
    }

    @Override
    public int getItemCount() {
        return alimentos.size();
    }

    static class AlimentoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNomeAlimento;

        AlimentoViewHolder(View itemView) {
            super(itemView);
            tvNomeAlimento = itemView.findViewById(R.id.tvNomeAlimento);
        }

        void bind(final Alimento alimento, final OnItemClickListener listener) {
            tvNomeAlimento.setText(alimento.getAlimento());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(alimento);
                }
            });
        }
    }
}
