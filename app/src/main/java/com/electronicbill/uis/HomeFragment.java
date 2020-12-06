package com.electronicbill.uis;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.electronicbill.R;
import com.electronicbill.adapters.CategoryAdapter;
import com.electronicbill.adapters.CategoryDataAdapter;
import com.electronicbill.databinding.FragmentHomeBinding;
import com.electronicbill.models.CategoryDataModel;
import com.electronicbill.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private MainActivity activity;
    private List<CategoryModel> categoryModelList;
    private CategoryAdapter categoryAdapter;
    private List<CategoryDataModel> categoryDataModelList;
    private CategoryDataAdapter adapter;
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);
        initView();
        return binding.getRoot();
    }

    private void initView()
    {
        categoryDataModelList = new ArrayList<>();
        activity = (MainActivity) getActivity();
        categoryModelList = new ArrayList<>();



        categoryAdapter = new CategoryAdapter(categoryModelList,activity,this);
        binding.recViewCategory.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.recViewCategory.setAdapter(categoryAdapter);
        binding.recView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new CategoryDataAdapter(categoryDataModelList,activity,this);
        binding.recView.setAdapter(adapter);



        List<CategoryDataModel> categoryDataModelList1 = new ArrayList<>();
        categoryDataModelList1.add(new CategoryDataModel(0,"هايبر بندة","3:29 مساءا 06-12-2020"));
        categoryDataModelList1.add(new CategoryDataModel(0,"هايبر بندة","3:29 مساءا 06-12-2020"));
        categoryDataModelList1.add(new CategoryDataModel(0,"هايبر بندة","3:29 مساءا 06-12-2020"));
        categoryModelList.add(new CategoryModel(0,"بندة",categoryDataModelList1));

        List<CategoryDataModel> categoryDataModelList2 = new ArrayList<>();
        categoryDataModelList2.add(new CategoryDataModel(0,"هايبر العثيم","3:29 مساءا 06-12-2020"));
        categoryDataModelList2.add(new CategoryDataModel(0,"هايبر العثيم","3:29 مساءا 06-12-2020"));
        categoryDataModelList2.add(new CategoryDataModel(0,"هايبر العثيم","3:29 مساءا 06-12-2020"));
        categoryModelList.add(new CategoryModel(0,"العثيم",categoryDataModelList2));


        List<CategoryDataModel> categoryDataModelList3 = new ArrayList<>();
        categoryDataModelList3.add(new CategoryDataModel(0,"الكهرباء","3:29 مساءا 06-12-2020"));
        categoryDataModelList3.add(new CategoryDataModel(0,"الكهرباء","3:29 مساءا 06-12-2020"));
        categoryDataModelList3.add(new CategoryDataModel(0,"الكهرباء","3:29 مساءا 06-12-2020"));
        categoryModelList.add(new CategoryModel(0,"الكهرباء",categoryDataModelList3));

        List<CategoryDataModel> categoryDataModelList4 = new ArrayList<>();
        categoryDataModelList4.add(new CategoryDataModel(0,"وزارة الداخلية","3:29 مساءا 06-12-2020"));
        categoryDataModelList4.add(new CategoryDataModel(0,"وزارة الداخلية","3:29 مساءا 06-12-2020"));
        categoryDataModelList4.add(new CategoryDataModel(0,"وزارة الداخلية","3:29 مساءا 06-12-2020"));
        categoryModelList.add(new CategoryModel(0,"وزارة الداخلية",categoryDataModelList4));

        categoryAdapter.notifyDataSetChanged();

        categoryDataModelList.addAll(categoryModelList.get(0).getCategoryDataModelList());
        adapter.notifyDataSetChanged();

    }

    public void setSelectedItem(CategoryModel categoryModel) {
        categoryDataModelList.clear();
        categoryDataModelList.addAll(categoryModel.getCategoryDataModelList());
        adapter.notifyDataSetChanged();

    }

    public void setItemData(CategoryDataModel categoryModel) {

    }
}
