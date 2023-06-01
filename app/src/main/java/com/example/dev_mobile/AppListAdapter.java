package com.example.dev_mobile;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppViewHolder> {
    private Context context;
    private List<ApplicationInfo> appList;
    private OnItemClickListener listener;

    public AppListAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.appList = new ArrayList<>();
    }

    public void setAppList(List<ApplicationInfo> appList) {
        this.appList = appList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        ApplicationInfo appInfo = appList.get(position);
        PackageManager pm = context.getPackageManager();

        holder.appNameTextView.setText(pm.getApplicationLabel(appInfo).toString());
        holder.packageNameTextView.setText(appInfo.packageName);
        holder.iconImageView.setImageDrawable(pm.getApplicationIcon(appInfo));

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView appNameTextView;
        TextView packageNameTextView;

        AppViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.imageView);
            appNameTextView = itemView.findViewById(R.id.tvAppName);
            packageNameTextView = itemView.findViewById(R.id.tvPackageName);
        }
    }
}
