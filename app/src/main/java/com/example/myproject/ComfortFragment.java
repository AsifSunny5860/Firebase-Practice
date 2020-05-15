package com.example.myproject;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComfortFragment extends Fragment implements ClickListener{

    private List<House> houseList = new ArrayList<>();
    FirebaseDatabase firebaseDatabase;
    private RecyclerView recyclerviewID;
    private ComfortListAdapter comfortListAdapter;

    public ComfortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_comfort, container, false);

        firebaseDatabase=FirebaseDatabase.getInstance();

        prepareItem();


        recyclerviewID = view.findViewById(R.id.recyclerviewID);
        recyclerviewID.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewID.setItemAnimator(new DefaultItemAnimator());

        ComfortListAdapter comfortListAdapter = new ComfortListAdapter(houseList);
        comfortListAdapter.setClickListener(this);
        recyclerviewID.setAdapter(comfortListAdapter);


        return view;
    }

    private void prepareItem() {

            DatabaseReference userDB = firebaseDatabase.getReference().child("Comfort");

            userDB.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        houseList.clear();
                        for (DataSnapshot data: dataSnapshot.getChildren()){
                            House house = data.getValue(House.class);
                            houseList.add(house);
                            comfortListAdapter.notifyDataSetChanged();
                        }
                    }else {
                        Toast.makeText(getContext(), "Empty database", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


    }

    @Override
    public void itemClicked(View v, int adapterPosition) {

        if (adapterPosition == 0) {
            Intent intent = new Intent(getActivity(), Guha.class);
            startActivity(intent);
        } else if (adapterPosition == 1) {
            Intent intent = new Intent(getActivity(), OzzCafe.class);
            startActivity(intent);
        } else if (adapterPosition == 2) {
            Intent intent = new Intent(getActivity(), CherryDrops.class);
            startActivity(intent);
        }else if(adapterPosition==3) {
            Intent intent = new Intent(getActivity(), Mirror.class);
            startActivity(intent);
        } else if(adapterPosition==4) {
            Intent intent = new Intent(getActivity(), Chilekotha.class);
            startActivity(intent);
        } else if(adapterPosition==5) {
            Intent intent = new Intent(getActivity(), Hangout.class);
            startActivity(intent);
        }
        else {
            System.out.println("position...." + adapterPosition);

        }

    }
}
