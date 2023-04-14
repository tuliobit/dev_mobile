package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> listApps;
        listApps = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo appinfo:listApps) {
            Log.d("App", appinfo.packageName + pm.getApplicationLabel(appinfo).toString());
            // Se desejado, poderia printar o ícone setando como drawable.
//            imageView.setDrawable(pm.getApplicationIcon(appinfo));
        }
    }
}