package com.electronicbill.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.electronicbill.R;
import com.electronicbill.databinding.CategoryRowBinding;
import com.electronicbill.models.CategoryModel;
import com.electronicbill.uis.HomeFragment;


import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryModel> list;
    private Context context;
    private LayoutInflater inflater;
    private HomeFragment homeFragment;
    private int selected_pos = 0;
    private int old_pos = 0;
    public CategoryAdapter(List<CategoryModel> list, Context context,HomeFragment homeFragment) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.homeFragment = homeFragment;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CategoryRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.category_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        CategoryModel categoryModel = list.get(position);
        myHolder.binding.setModel(categoryModel);
        myHolder.binding.image.setImageResource(categoryModel.getImage_resource());
        if (categoryModel.isSelected()){
            myHolder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimaryDark));
        }else {
            myHolder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.white));

        }

        myHolder.itemView.setOnClickListener(view -> {
            selected_pos = holder.getAdapterPosition();
            if (old_pos!=-1){
                CategoryModel categoryModel2 = list.get(old_pos);
                categoryModel2.setSelected(false);
                list.set(old_pos,categoryModel2);
                notifyItemChanged(old_pos);
            }


            CategoryModel categoryModel3 = list.get(selected_pos);
            categoryModel3.setSelected(true);
            list.set(selected_pos,categoryModel3);
            notifyItemChanged(selected_pos);
            old_pos = selected_pos;
            homeFragment.setSelectedItem(categoryModel3);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public CategoryRowBinding binding;

        public MyHolder(@NonNull CategoryRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }




}
