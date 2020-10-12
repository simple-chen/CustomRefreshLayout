package com.example.customrefreshlayout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customrefreshlayout.R;

import java.util.List;

/**
 * @author by chenlp
 * @date 2020/9/21
 * @describe
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<String> mFruitList;

    public FruitAdapter() {
    }


    public void addFruitData(List<String> fruitList) {
        mFruitList = fruitList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mFruit_name.setText(mFruitList.get(position));
    }


    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mFruit_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFruit_name = itemView.findViewById(R.id.fruit_name);
        }
    }
}
