package com.example.covid19tracker.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.covid19tracker.R;
import com.example.covid19tracker.databinding.ActivityDetailsBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.covid19tracker.databinding.ActivityDetailsBinding binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark));

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        binding.cNameDetails.setText(CountriesListActivity.countriesModelsList.get(position).getCountryName() + " / " + CountriesListActivity.countriesModelsList.get(position).getContinent());

        binding.countryNameLabel.setText(CountriesListActivity.countriesModelsList.get(position).getCountryName());
        Glide.with(DetailsActivity.this).load(CountriesListActivity.countriesModelsList.get(position).getCountryFlag()).into(binding.countryFlagImage);
        binding.totalPopulationNumbers.setText(CountriesListActivity.countriesModelsList.get(position).getTotalPopulation());
        binding.totalCaseNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTotalCases());
        binding.todayCaseNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTodayCases());
        binding.totalDeathNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTotalDeaths());
        binding.todayDeathNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTodayDeaths());
        binding.recoveredNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTotalRecovered());
        binding.todayRecoveredNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTodayRecovered());
        binding.activeCaseNumber.setText(CountriesListActivity.countriesModelsList.get(position).getActiveCases());
        binding.criticalCaseNumber.setText(CountriesListActivity.countriesModelsList.get(position).getCriticalCases());
        binding.testsPerOneMillionNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTestPerOneMillion());
        binding.casesPerOneMillionNumber.setText(CountriesListActivity.countriesModelsList.get(position).getCasesPerOneMillion());
        binding.deathsPerOneMillionNummber.setText(CountriesListActivity.countriesModelsList.get(position).getDeathsPerOneMillion());
        binding.recoverCasesPerOneMillionNumber.setText(CountriesListActivity.countriesModelsList.get(position).getRecoveredPerOneMillion());
        binding.activePerMillionNumber.setText(CountriesListActivity.countriesModelsList.get(position).getActivePerOneMillion());
        binding.criticalPerOneMillionNumber.setText(CountriesListActivity.countriesModelsList.get(position).getCriticalPerOneMillion());
        binding.totalTestNumber.setText(CountriesListActivity.countriesModelsList.get(position).getTotalTests());
        binding.continentNameLabel.setText(CountriesListActivity.countriesModelsList.get(position).getContinent());
        binding.oneTestPerPeopleNumber.setText(CountriesListActivity.countriesModelsList.get(position).getOneTestPerPeople());
        binding.oneCasePerPeopleNumber.setText(CountriesListActivity.countriesModelsList.get(position).getOneCasePerPeople());
        binding.oneDeathPerPeopleNumber.setText(CountriesListActivity.countriesModelsList.get(position).getOneDeathPerPeople());

        long updatedTime = Long.parseLong(CountriesListActivity.countriesModelsList.get(position).getUpdatedTime());

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String time = timeFormat.format(updatedTime);
        binding.dateTime.setText(time);
    }
}