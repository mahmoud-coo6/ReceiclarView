package com.example2.acer.receiclarview;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Employee> employee = new ArrayList<Employee>();

        final Employee e1 = new Employee();

        e1.setAge(22);
        e1.setImageId(R.drawable.family_father);
        e1.setName("Ahmed");
        employee.add(e1);


        Employee e2 = new Employee();

        e2.setAge(24);
        e2.setImageId(R.drawable.family_father);
        e2.setName("Abdulazeez");
        employee.add(e2);


        Employee e3 = new Employee();

        e3.setAge(44);
        e3.setImageId(R.drawable.family_father);
        e3.setName("Ali");
        employee.add(e3);


        Employee e4 = new Employee();

        e4.setAge(14);
        e4.setImageId(R.drawable.family_father);
        e4.setName("Rami");
        employee.add(e4);


        Employee e5 = new Employee();

        e5.setAge(43);
        e5.setImageId(R.drawable.family_father);
        e5.setName("Sami");
        employee.add(e5);


        Employee e6 = new Employee();

        e6.setAge(33);
        e6.setImageId(R.drawable.family_father);
        e6.setName("Zakaria");
        employee.add(e6);


        Employee e7 = new Employee();

        e7.setAge(65);
        e7.setImageId(R.drawable.family_father);
        e7.setName("Abu Ali");
        employee.add(e7);


        Employee e8 = new Employee();

        e8.setAge(16);
        e8.setImageId(R.drawable.family_father);
        e8.setName("Motaz");
        employee.add(e8);


        final Employee e9 = new Employee();

        e9.setAge(45);
        e9.setImageId(R.drawable.family_father);
        e9.setName("Kalid");
        employee.add(e9);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        final MyAdapter adapter = new MyAdapter(getApplicationContext(), employee, R.layout.my_list_layout);
        rv.setAdapter(adapter);

        final SwipeRefreshLayout srl=(SwipeRefreshLayout)findViewById(R.id.srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Employee e11 = new Employee();

                e11.setAge(45);
                e11.setImageId(R.drawable.family_father);
                e11.setName("AAAAAAAAAAAAA");
                employee.add(0,e11);
               // rv .scrollToPosition(employee.size()-1);
                adapter.notifyDataSetChanged();
                srl.setRefreshing(false);
            }
        });

        LinearLayoutManager m = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        // GridLayoutManager g=new GridLayoutManager(getApplicationContext(),2);

        rv.setLayoutManager(m);

        final ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START | ItemTouchHelper.END) {


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                TextView tv=(TextView)findViewById(R.id.tvv);

                if (isCurrentlyActive){
                    tv.setY(viewHolder.itemView.getTop());
                    tv.setVisibility(View.VISIBLE);
                    if (dX>0){
                      tv.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_orange_dark));
                      tv.setText("delete");
                    }else{
                        tv.setText("messege");
                        tv.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_green_dark));
                    }
                }else{
                    tv.setVisibility(View.GONE);
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.START) {
                    employee.remove(viewHolder.getAdapterPosition()-1);
                    adapter.notifyDataSetChanged();

                } else {
                    adapter.notifyDataSetChanged();

                }

            }
        });

        DividerItemDecoration di=new DividerItemDecoration(getApplicationContext(),m.getOrientation());
        di.setDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.recicler_view_divider));

//        get Integer value of color
//        ContextCompat.getColor(getApplicationContext(),R.color.colorAccent);

         rv.addItemDecoration(di);
        helper.attachToRecyclerView(rv);
    }
}
