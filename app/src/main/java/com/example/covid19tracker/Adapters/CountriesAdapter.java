package com.example.covid19tracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.covid19tracker.Activities.CountriesListActivity;
import com.example.covid19tracker.Models.CountriesModel;
import com.example.covid19tracker.R;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends ArrayAdapter<CountriesModel> {

    private Context context;
    private List<CountriesModel> countriesModelList;
    private List<CountriesModel> countriesModelListFiltered;

    public CountriesAdapter(Context context, List<CountriesModel> countriesModelList) {
        super(context, R.layout.countries_list_design, countriesModelList);
        this.context = context;
        this.countriesModelList = countriesModelList;
        this.countriesModelListFiltered = countriesModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_list_design, null, false);
        TextView countryNameDesign = view.findViewById(R.id.design_country_name);
        ImageView countryImageDesign = view.findViewById(R.id.design_country_image);
        countryNameDesign.setText(countriesModelListFiltered.get(position).getCountryName());
        Glide.with(context).load(countriesModelListFiltered.get(position).getCountryFlag()).into(countryImageDesign);
        return view;
    }

    @Override
    public int getCount() {
        return countriesModelListFiltered.size();
    }

    @Nullable
    @Override
    public CountriesModel getItem(int position) {
        return countriesModelListFiltered.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = countriesModelList.size();
                    filterResults.values = countriesModelList;
                } else {
                    List<CountriesModel> resultModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (CountriesModel itemModel : countriesModelList) {
                        if (itemModel.getCountryName().toLowerCase().contains(searchStr)) {
                            resultModel.add(itemModel);
                        }
                        filterResults.count = resultModel.size();
                        filterResults.values = resultModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countriesModelListFiltered = (List<CountriesModel>) results.values;
                CountriesListActivity.countriesModelsList = (List<CountriesModel>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
