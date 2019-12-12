package com.reshika.esoftwarica.ui.dashboard;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.reshika.esoftwarica.MainActivity;
import com.reshika.esoftwarica.R;
import com.reshika.esoftwarica.ui.Contacts;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {

private Button btnSave;
private EditText etFull,etAge,etAddress;
private RadioButton btn1,btn2,btn3;
private RadioGroup rdogrp;
String gender,age,name,address;


    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        etFull=view.findViewById(R.id.etFull);
        etAge=view.findViewById(R.id.etAge);
        etAddress=view.findViewById(R.id.etAddress);
        rdogrp=view.findViewById(R.id.rdogrp);
        btn1=view.findViewById(R.id.btn1);
        btn2=view.findViewById(R.id.btn2);
        btn3=view.findViewById(R.id.btn3);
        btnSave=view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
        rdogrp.setOnCheckedChangeListener(this);

        return view;
//
//        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
    }



private boolean validate(){
    if(TextUtils.isEmpty(etFull.getText()))
    {
        etFull.setError("Please enter a name");
        etFull.requestFocus();
        return false;
    }
    if(TextUtils.isEmpty(etAge.getText()))
    {
        etAge.setError("Please enter age");
        etAge.requestFocus();
        return false;
    }

    if(!TextUtils.isDigitsOnly(etAge.getText()))
    {
        etAge.setError("Please enter age");
        etAge.requestFocus();
        return false;
    }

    if(TextUtils.isEmpty(etAddress.getText()))
    {
        etAddress.setError("Please enter an address");
        etAddress.requestFocus();
        return false;
    }

    return true;

}

    @Override
    public void onClick(View v) {
//
        name=etFull.getText().toString();
        age=etAge.getText().toString();
        address=etAddress.getText().toString();
//
//        if(validate())
//        {
//            MainActivity.st.add(new Contacts(name,gender,age,address));
            Toast.makeText(getContext(), "Student has been added", Toast.LENGTH_LONG).show();
            etFull.setText(null);
            etAge.setText(null);
            etAddress.setText(null);
//
//        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if(i==R.id.btn1)
        {
            gender="Male";
            Toast.makeText(getContext(), "Male", Toast.LENGTH_SHORT).show();
        }

        if(i==R.id.btn2)
        {
            gender="Female";
            Toast.makeText(getContext(), "Female", Toast.LENGTH_SHORT).show();
        }

        if (i==R.id.btn3)
        {
            gender="Others";
            Toast.makeText(getContext(), "Others", Toast.LENGTH_SHORT).show();
        }

    }
}