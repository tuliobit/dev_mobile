package com.example.dev_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.ViewHolderFruta> {
    Context mContext;
    int mResource;
    Fruta[] mDataSet;

    public FrutaAdapter(Context mContext, int mResource, Fruta[] mDataSet) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public FrutaAdapter.ViewHolderFruta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // inflar layout => Retorna View
        // Construir layout InflarLayout
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource, parent, false);
//        ViewHolderFruta viewHolderFruta = new ViewHolderFruta(convertView);

        return new ViewHolderFruta(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull FrutaAdapter.ViewHolderFruta holder, int position) { // preenche (recicla) o layout inflado com os campos
        Fruta fruta = mDataSet[position];

        holder.tvCodigo.setText(fruta.getCodigo());
        holder.tvNome.setText(fruta.getNome());
        holder.tvPreco.setText(fruta.getPreco().toString());
        holder.tvPrecoVenda.setText(fruta.getPreco_venda().toString());
        holder.imageView.setImageResource(fruta.getImagem());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderFruta extends RecyclerView.ViewHolder { // pode declarar separado
        TextView tvCodigo;
        TextView tvNome;
        TextView tvPreco;
        TextView tvPrecoVenda;
        ImageView imageView;
        public ViewHolderFruta(@NonNull View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById((R.id.tvCodigo));
            tvNome = itemView.findViewById((R.id.tvCodigo));
            tvPreco = itemView.findViewById((R.id.tvPreco));
            tvPrecoVenda = itemView.findViewById((R.id.tvPrecoVenda));
            imageView = itemView.findViewById((R.id.imageView));
        }
    }
}