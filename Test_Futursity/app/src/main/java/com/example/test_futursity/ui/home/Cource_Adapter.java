package com.example.test_futursity.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test_futursity.R;

import java.util.List;

public class Cource_Adapter extends RecyclerView.Adapter<Cource_Adapter.MyViewHolder>{
    private Context context;
    private List<Course_Data> list ;
    @NonNull
    @Override
    public Cource_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list,parent,false);
        return new Cource_Adapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Course_Data l=list.get(position);

        holder.title.setText(l.getTitle());
        holder.price.setText(l.getPrice());
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
        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            photo=(ImageView) itemView.findViewById(R.id.image);

        }
    }



    public Cource_Adapter(List<Course_Data> list){this.list=list;}
    public Cource_Adapter(Context context){
        this.context=context;
    }
}
