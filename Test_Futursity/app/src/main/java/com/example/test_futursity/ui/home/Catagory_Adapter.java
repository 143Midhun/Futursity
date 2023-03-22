package com.example.test_futursity.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test_futursity.R;

import java.util.List;

public class Catagory_Adapter extends RecyclerView.Adapter<Catagory_Adapter.MyViewHolder>{
    private Context context;
    private List<Catagory_Data> list ;
    @NonNull
    @Override
    public Catagory_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.catogory_list,parent,false);
        return new Catagory_Adapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull Catagory_Adapter.MyViewHolder holder, int position) {
        final Catagory_Data l=list.get(position);

        holder.title.setText(l.getTitle());
        holder.price.setText(l.getNo_of_cources()+" Courses");
        if(l.getImage()==null)
        {
            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
        }else {
            String Url=l.getImage();
//            Toast.makeText(l.getContext(), Url, Toast.LENGTH_SHORT).show();
            Glide.with(l.getContext()).load(Url).into(holder.photo);
        }
        context = l.getContext();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView title, price;
        ImageView photo;

        LinearLayout l1;
        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            photo=(ImageView) itemView.findViewById(R.id.image);
            l1=(LinearLayout) itemView.findViewById(R.id.colours);

        }
    }



    public Catagory_Adapter(List<Catagory_Data> list){this.list=list;}
    public Catagory_Adapter(Context context){
        this.context=context;
    }
}