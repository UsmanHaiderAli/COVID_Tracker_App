package com.example.covid19tracker.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19tracker.Adapters.CountriesAdapter;
import com.example.covid19tracker.Models.CountriesModel;
import com.example.covid19tracker.R;
import com.example.covid19tracker.databinding.ActivityCountriesListBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountriesListActivity extends AppCompatActivity {

    public static List<CountriesModel> countriesModelsList = new ArrayList<>();
    private ActivityCountriesListBinding binding;
    private CountriesModel countriesModel;
    private CountriesAdapter countriesAdapter;
    private Dialog dialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountriesListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark));

        dialogLoading = new Dialog(CountriesListActivity.this);
        dialogLoading.setContentView(R.layout.loading_dialog);
        dialogLoading.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogLoading.setCancelable(false);
        dialogLoading.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogLoading.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        dialogLoading.show();
        getCountriesList();
        binding.countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getCountriesDetails(position);
            }
        });
        binding.searchTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                countriesAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getCountriesDetails(int position) {
        startActivity(new Intent(CountriesListActivity.this, DetailsActivity.class).putExtra("position", position));
    }

    private void getCountriesList() {
        dialogLoading.show();
        StringRequest request = new StringRequest(Request.Method.GET, "https://corona.lmao.ninja/v2/countries/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    countriesModelsList.clear();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String countryName = jsonObject.getString("country");
                        JSONObject object = jsonObject.getJSONObject("countryInfo");
                        String countryFlag = object.getString("flag");
                        String totalPopulation = jsonObject.getString("population");
                        String totalTest = jsonObject.getString("tests");
                        String totalCases = jsonObject.getString("cases");
                        String todayCases = jsonObject.getString("todayCases");
                        String totalDeaths = jsonObject.getString("deaths");
                        String todayDeaths = jsonObject.getString("todayDeaths");
                        String totalRecovered = jsonObject.getString("recovered");
                        String todayRecovered = jsonObject.getString("todayRecovered");
                        String active = jsonObject.getString("active");
                        String critical = jsonObject.getString("critical");
                        String testPerOneMillion = jsonObject.getString("testsPerOneMillion");
                        String casesPerOneMillion = jsonObject.getString("casesPerOneMillion");
                        String deathsPerOneMillion = jsonObject.getString("deathsPerOneMillion");
                        String criticalPerOneMillion = jsonObject.getString("criticalPerOneMillion");
                        String recoveredPerOneMillion = jsonObject.getString("recoveredPerOneMillion");
                        String activePerOneMillion = jsonObject.getString("activePerOneMillion");
                        String continent = jsonObject.getString("continent");
                        String oneTestPerPeople = jsonObject.getString("oneTestPerPeople");
                        String oneCasePerPeople = jsonObject.getString("oneCasePerPeople");
                        String oneDeathPerPeople = jsonObject.getString("oneDeathPerPeople");
                        String updateTime = jsonObject.getString("updated");

                        countriesModel = new CountriesModel(totalPopulation, totalTest, totalCases, todayCases, totalDeaths, todayDeaths, totalRecovered, todayRecovered, active, critical, testPerOneMillion, casesPerOneMillion, deathsPerOneMillion, recoveredPerOneMillion, activePerOneMillion, criticalPerOneMillion, countryName, countryFlag, continent, oneTestPerPeople, oneCasePerPeople, oneDeathPerPeople, updateTime);
                        countriesModelsList.add(countriesModel);
                    }
                    countriesAdapter = new CountriesAdapter(CountriesListActivity.this, countriesModelsList);
                    binding.countryListView.setAdapter(countriesAdapter);
                    countriesAdapter.notifyDataSetChanged();
                    binding.searchTv.setEnabled(countriesModelsList.size() != 0);
                    dialogLoading.dismiss();
                } catch (JSONException e) {
                    binding.searchTv.setEnabled(countriesModelsList.size() != 0);

                    dialogLoading.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                binding.searchTv.setEnabled(countriesModelsList.size() != 0);
                dialogLoading.dismiss();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
        binding.searchTv.setEnabled(countriesModelsList.size() != 0);
    }
}