package com.reshika.esoftwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reshika.esoftwarica.R;
import com.reshika.esoftwarica.ui.Contacts;
import com.reshika.esoftwarica.ui.ContactsAdapter;
import com.reshika.esoftwarica.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        recyclerView=view.findViewById(R.id.recyclerView);

        List<Contacts> contactsList=new ArrayList<>();
        contactsList.add(new Contacts("Reshika Bhasink","20","Kathmandu","Female",R.drawable.female));
        contactsList.add(new Contacts("Ashish Shrestha","25","Kathmandu","Male",R.drawable.male));

        ContactsAdapter contactAdapter=new ContactsAdapter(getContext(),contactsList);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
        //





//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//       // final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//       //         textView.setText(s);
//            }
//        });
//        return root;
    }
}