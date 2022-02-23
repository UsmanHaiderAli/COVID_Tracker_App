package com.example.covid19tracker.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19tracker.R;
import com.example.covid19tracker.databinding.ActivityMainBinding;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Dialog dialogLoading;
    private RelativeLayout mainLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark));

        mainLayoutMain = findViewById(R.id.main_layout_main);
        dialogLoading = new Dialog(MainActivity.this);
        dialogLoading.setContentView(R.layout.loading_dialog);
        dialogLoading.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogLoading.setCancelable(false);
        dialogLoading.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogLoading.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        dialogLoading.show();

        getUpdateOfCases();
        binding.tackCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CountriesListActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUpdateOfCases();
    }

    private void getUpdateOfCases() {
        StringRequest request = new StringRequest(Request.Method.GET, "https://corona.lmao.ninja/v2/all/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    binding.totalTestNumber.setText(jsonObject.getString("tests"));
                    binding.totalCaseNumber.setText(jsonObject.getString("cases"));
                    binding.todayCaseNumber.setText(jsonObject.getString("todayCases"));
                    binding.totalDeathNumber.setText(jsonObject.getString("deaths"));
                    binding.activeCaseNumber.setText(jsonObject.getString("active"));
                    binding.criticalCaseNumber.setText(jsonObject.getString("critical"));
                    binding.recoveredNumber.setText(jsonObject.getString("recovered"));
                    binding.todayDeathNumber.setText(jsonObject.getString("todayDeaths"));
                    binding.todayRecoveredNumber.setText(jsonObject.getString("todayRecovered"));
                    binding.casesPerOneMillionNumber.setText(jsonObject.getString("casesPerOneMillion"));
                    binding.deathsPerOneMillionNummber.setText(jsonObject.getString("deathsPerOneMillion"));
                    binding.testsPerOneMillionNumber.setText(jsonObject.getString("testsPerOneMillion"));
                    binding.totalPopulationNumbers.setText(jsonObject.getString("population"));
                    binding.activePerMillionNumber.setText(jsonObject.getString("activePerOneMillion"));
                    binding.recoverCasesPerOneMillionNumber.setText(jsonObject.getString("recoveredPerOneMillion"));
                    binding.criticalPerOneMillionNumber.setText(jsonObject.getString("criticalPerOneMillion"));
                    binding.affectedCountriesNumbers.setText(jsonObject.getString("affectedCountries"));
                    long updatedTime = Long.parseLong(jsonObject.getString("updated"));
                    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                    String time = timeFormat.format(updatedTime);
                    binding.dateTime.setText(time);
                    binding.pieChart.clearChart();
                    binding.pieChart.addPieSlice(new PieModel("Total Cases", Integer.parseInt(jsonObject.getString("cases")), Color.parseColor("#ffc107")));
                    binding.pieChart.addPieSlice(new PieModel("Recovered", Integer.parseInt(jsonObject.getString("recovered")), Color.parseColor("#28a745")));
                    binding.pieChart.addPieSlice(new PieModel("Deaths", Integer.parseInt(jsonObject.getString("deaths")), Color.parseColor("#dc3545")));
                    binding.pieChart.addPieSlice(new PieModel("Active", Integer.parseInt(jsonObject.getString("active")), Color.parseColor("#007bff")));
                    mainLayoutMain.setVisibility(View.VISIBLE);
                    dialogLoading.dismiss();
                    binding.pieChart.startAnimation();

                } catch (JSONException e) {
                    dialogLoading.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialogLoading.dismiss();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}