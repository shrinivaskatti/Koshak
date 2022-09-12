package com.example.koshak.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.koshak.ListAdapter;
import com.example.koshak.MainActivity;
import com.example.koshak.Patient;
import com.example.koshak.R;

import com.example.koshak.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    ListView patientView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       int[] imageid =  {R.drawable.katti, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
               R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round};
        String [] name = {"Robert", "John", "Strange", "XYZ", "AVD","AAAAA"};
        String [] gender={ "Male","Female","Male","Male","Female","Male"};
        int[] age       ={20,20,20,20,20, 20};

        ArrayList<Patient> patients = new ArrayList<>();

        for (int i=0; i<imageid.length; i++){
            Patient p = new Patient(name[i],gender[i],age[i], imageid[i]);
            patients.add(p);
        }

        ListAdapter listAdapter = new ListAdapter(this.getContext(), patients);
        binding.patientList.setAdapter(listAdapter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* int[] imageid =  {R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d, R.drawable.katti};
        String [] name = {"Shrinivas", "Shreeraksha", "Shreyas", "Shivshant", "Rama"};
        String [] gender={ "Male","Female","Male","Male","Female"};
        int[] age       ={20,20,20,20,20};

        ArrayList<Patient> patients = new ArrayList<>();

        for (int i=0; i<imageid.length; i++){
            Patient p = new Patient(name[i],gender[i],age[i], imageid[i]);
            patients.add(p);
        }

        ListAdapter listAdapter = new ListAdapter(getContext(), patients);

        //ArrayAdapter adapter  = new ArrayAdapter(getContext(), R.layout.patient_listview,mobileArray);
        patientView = (ListView) getView().findViewById(R.id.patientList);
        patientView.setAdapter(listAdapter);*/
        //patientView.setClickable(true);
       /* patientView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}