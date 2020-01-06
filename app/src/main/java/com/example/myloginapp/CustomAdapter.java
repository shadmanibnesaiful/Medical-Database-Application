package com.example.myloginapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<InfoDct> {

    private Activity context;
    private List<InfoDct>doctorList;

    public CustomAdapter(Activity context, List<InfoDct>doctorList) {
        super(context,R.layout.rajshahisamplelayout, doctorList);
        this.context = context;
        this.doctorList=doctorList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.rajshahisamplelayout,null,true);

        InfoDct infoDct = doctorList.get(position);

        TextView t1 = view.findViewById(R.id.nametxtviewid);
        TextView t2 = view.findViewById(R.id.designationtxtView);



        return view;
    }
}
