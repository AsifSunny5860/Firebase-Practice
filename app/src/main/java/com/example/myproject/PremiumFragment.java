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
public class PremiumFragment extends Fragment implements ClickListener {

    private List<House> houseList = new ArrayList<>();
    FirebaseDatabase firebaseDatabase;

    private RecyclerView recyclerviewID;
    private CustomAdapter customAdapter;



    public PremiumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_premium, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();

         prepareItem();

        recyclerviewID = view.findViewById(R.id.recyclerviewID);
        recyclerviewID.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewID.setItemAnimator(new DefaultItemAnimator());


        CustomAdapter customAdapter = new CustomAdapter(getContext(), houseList);
        customAdapter.setClickListener(this);

        recyclerviewID.setAdapter(customAdapter);



        return view;
    }

   private void prepareItem() {
       DatabaseReference userDB = firebaseDatabase.getReference().child("Premium");

       userDB.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()){
                   houseList.clear();
                   for (DataSnapshot data: dataSnapshot.getChildren()){
                       House house = data.getValue(House.class);
                       houseList.add(house);
                       customAdapter.notifyDataSetChanged();
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
            Intent intent = new Intent(getActivity(), Nandos.class);
            startActivity(intent);
        } else if (adapterPosition == 1) {
            Intent intent = new Intent(getActivity(), Gloria.class);
            startActivity(intent);
        } else if (adapterPosition == 2) {
            Intent intent = new Intent(getActivity(), Greenlounge.class);
            startActivity(intent);
        } else if (adapterPosition == 3) {
            Intent intent = new Intent(getActivity(), Picasso.class);
            startActivity(intent);
        } else if (adapterPosition == 4) {
            Intent intent = new Intent(getActivity(), Burger.class);
            startActivity(intent);
        } else {
            System.out.println("position...." + adapterPosition);

        }


    }
}
