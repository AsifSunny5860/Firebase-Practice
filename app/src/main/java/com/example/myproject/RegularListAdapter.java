package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RegularListAdapter extends RecyclerView.Adapter<RegularListAdapter.ViewHolder> {

    private List<House> houseList;
    private  ClickListener clicklistener = null;

    public RegularListAdapter(List<House> houseList) {
        this.houseList = houseList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_layout3,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        House currentHouse = houseList.get(position);
        final String name=houseList.get(position).getName();
        final String mobilenumber =houseList.get(position).getMobilenumber();
        final String address= houseList.get(position).getAddress();
        final String branches = houseList.get(position).getBranches();
        final String capacity = houseList.get(position).getCapacity();
        final int logo = houseList.get(position).getLogo();
        final String id= houseList.get(position).getId();

        viewHolder.NameTV.setText(currentHouse.getName());
        viewHolder.mobileNumberTV.setText(currentHouse.getMobilenumber());
        viewHolder.logoIV.setImageResource(currentHouse.getLogo());

    }

    @Override
    public int getItemCount() {
        return houseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView logoIV;
        private TextView NameTV,ratingTV,mobileNumberTV;
        private LinearLayout Layout;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            logoIV=itemView.findViewById(R.id.logoIV);
            NameTV=itemView.findViewById(R.id.NameTV);
            ratingTV=itemView.findViewById(R.id.ratingTV);
            mobileNumberTV=itemView.findViewById(R.id.mobileNumberTV);
            Layout=itemView.findViewById(R.id.Layout);


            Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //noinspection deprecation
                    //Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                    if(clicklistener !=null){
                        clicklistener.itemClicked(v,getAdapterPosition());
                    }

                }
            });

        }
    }
    public void setClickListener(ClickListener clickListener){
        this.clicklistener = clickListener;
    }
}
