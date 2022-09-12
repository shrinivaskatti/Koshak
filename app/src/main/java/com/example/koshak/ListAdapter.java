package com.example.koshak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Patient> {

    public ListAdapter( Context context, ArrayList<Patient> patients) {
        super(context, R.layout.patient_listitem, R.id.dummy, patients);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Patient patient =  getItem(position);
        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.patient_listitem, parent, false);

        }
        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView personName = convertView.findViewById(R.id.personName);
        TextView age = convertView.findViewById(R.id.age);
        TextView gender = convertView.findViewById(R.id.gender);

        imageView.setImageResource(patient.imageId);
        personName.setText(patient.name);
        age.setText("25");
        gender.setText(patient.gender);

        return super.getView(position, convertView, parent);
    }
}
