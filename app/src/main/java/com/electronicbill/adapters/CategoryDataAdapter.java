package com.electronicbill.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.electronicbill.R;
import com.electronicbill.databinding.CategoryListRowBinding;
import com.electronicbill.databinding.CategoryRowBinding;
import com.electronicbill.models.CategoryDataModel;
import com.electronicbill.models.CategoryModel;
import com.electronicbill.uis.HomeFragment;

import java.util.List;

public class CategoryDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryDataModel> list;
    private Context context;
    private LayoutInflater inflater;
    private HomeFragment homeFragment;
    public CategoryDataAdapter(List<CategoryDataModel> list, Context context, HomeFragment homeFragment) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.homeFragment = homeFragment;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CategoryListRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.category_list_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        CategoryDataModel categoryModel = list.get(position);
        myHolder.binding.setModel(categoryModel);
        myHolder.binding.image.setImageResource(categoryModel.getImage_resource());

        myHolder.itemView.setOnClickListener(view -> {
            CategoryDataModel categoryModel2 = list.get(position);

            homeFragment.setItemData(categoryModel2);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public CategoryListRowBinding binding;

        public MyHolder(@NonNull CategoryListRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }




}
