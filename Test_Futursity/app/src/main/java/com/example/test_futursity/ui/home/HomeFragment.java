package com.example.test_futursity.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test_futursity.R;
import com.example.test_futursity.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {

    List<Course_Data> mylist = new ArrayList<>();
    RecyclerView recyclerView,recyclerView2;
    Cource_Adapter mAdapter = null;

    List<Catagory_Data> mylists = new ArrayList<>();
    Catagory_Adapter mAdapters = null;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        
        recyclerView =v.findViewById(R.id.recycler);
        mAdapter = new Cource_Adapter(mylist);
        StaggeredGridLayoutManager mLayoutManager =
                new StaggeredGridLayoutManager(
                        1, //The number of Columns in the grid
                        LinearLayoutManager.HORIZONTAL);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String Url="https://futursity.com/course/api/top_courses";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int index = 0; index < response.length(); index++) {
                    try {
                        Context context = getActivity();
                        JSONObject jsonObject = response.getJSONObject(index);
                        String title = jsonObject.getString("title");
                        String price = jsonObject.getString("price");
                        String image = jsonObject.getString("thumbnail");
                        Course_Data list = new Course_Data(title, price,image,context);
                        mylist.add(list);
                        mAdapter.notifyDataSetChanged();
//                        Log.d("TAG", jsonObject.getString("title"));
//                        Log.d("TAG", jsonObject.getString("description"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);


        recyclerView2 =v.findViewById(R.id.recyclers);
        mAdapters = new Catagory_Adapter(mylists);
        StaggeredGridLayoutManager mLayoutManagers =
                new StaggeredGridLayoutManager(
                        2, //The number of Columns in the grid
                        LinearLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(mLayoutManagers);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView2.setAdapter(mAdapters);
        final RequestQueue requestQueues = Volley.newRequestQueue(getActivity());
        String Urls="https://futursity.com/course/api/categories";
        JsonArrayRequest requests = new JsonArrayRequest(Request.Method.GET, Urls, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int index = 0; index < response.length(); index++) {
                    try {
                        Context context = getActivity();
                        JSONObject jsonObject = response.getJSONObject(index);
                        String title = jsonObject.getString("name");
                        String price = jsonObject.getString("number_of_courses");
                        String image = jsonObject.getString("thumbnail");
                        String code = jsonObject.getString("code");
                        Catagory_Data list = new Catagory_Data(title, price,image,code,context);
                        mylists.add(list);
                        mAdapters.notifyDataSetChanged();
//                        Log.d("TAG", jsonObject.getString("title"));
//                        Log.d("TAG", jsonObject.getString("description"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueues.add(requests);

        return v;
    }

}