package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AppListAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private AppListAdapter appListAdapter;
    private List<ApplicationInfo> listApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        appListAdapter = new AppListAdapter(this, this);
        recyclerView.setAdapter(appListAdapter);

        PackageManager pm = getPackageManager();
        listApps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        appListAdapter.setAppList(listApps);
    }

    @Override
    public void onItemClick(int position) {
        ApplicationInfo appInfo = listApps.get(position);
        String packageName = appInfo.packageName;

        // Launch the selected app
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "App nao pode ser aberto", Toast.LENGTH_SHORT).show();
        }
    }
}
