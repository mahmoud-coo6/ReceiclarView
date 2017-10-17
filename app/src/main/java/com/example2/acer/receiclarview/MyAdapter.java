package com.example2.acer.receiclarview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ACER on 16/07/17.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Employee> employees;
    int layout;
    Context context;

    public class HederViewHoler extends RecyclerView.ViewHolder {
        public HederViewHoler(View view) {
            super(view);
        }
    }

    public MyAdapter(Context context, List<Employee> employees, int layout) {
        this.employees = employees;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == -1) {
            View view = LayoutInflater.from(context).inflate(R.layout.heder_layout, parent, false);
            HederViewHoler hvh = new HederViewHoler(view);
            return hvh;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.my_list_layout, parent, false);
            MyViewHolder vh = new MyViewHolder(view);
            return vh;
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return -1;

        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position != 0) {
            Employee e = employees.get(position - 1);
            MyAdapter.MyViewHolder myViewHolder = (MyAdapter.MyViewHolder) holder;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, employees.get(position-1).getName(), Toast.LENGTH_SHORT).show();
                }
            });
            myViewHolder.im.setImageResource(e.getImageId());
            myViewHolder.nameTV.setText(e.getName());
            myViewHolder.ageTV.setText(e.getAge() + "");
            myViewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    employees.remove(position-1);
//                    notifyItemRemoved(position);
//                    notifyItemRangeRemoved(position, employees.size());
                     notifyDataSetChanged();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return employees.size() + 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView nameTV;
        TextView ageTV;
        Button deleteBtn;

        public MyViewHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.im);
            nameTV = (TextView) itemView.findViewById(R.id.name);
            ageTV = (TextView) itemView.findViewById(R.id.age);
            deleteBtn = (Button) itemView.findViewById(R.id.delete_btn);

        }
    }

}
