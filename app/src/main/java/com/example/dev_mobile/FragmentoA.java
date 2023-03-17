package com.example.dev_mobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentoA extends Fragment implements View.OnClickListener {
    Button buttonAbreFragmentoB;
    EditText edMsg;
    public FragmentoA() {
        // Required empty public constructor
    }

    public static FragmentoA newInstance(String param1, String param2) {
        FragmentoA fragment = new FragmentoA();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_a, container, false);
        edMsg = v.findViewById(R.id.edMsg);
        buttonAbreFragmentoB = v.findViewById(R.id.buttonAbreB);
        buttonAbreFragmentoB.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        Bundle bundleB = new Bundle();
        bundleB.putString("msg", edMsg.getText().toString());
        Fragment fragmentB = new Fragment();
        fragmentB.setArguments(bundleB);
        ft.replace(R.id.frameLayout, fragmentB);
        ft.commit();
    }
}