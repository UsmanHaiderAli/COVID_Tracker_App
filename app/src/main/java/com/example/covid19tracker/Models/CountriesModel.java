package com.example.covid19tracker.Models;

public class CountriesModel {
    private String totalPopulation;
    private String totalTests;
    private String totalCases;
    private String todayCases;
    private String totalDeaths;
    private String todayDeaths;
    private String totalRecovered;
    private String todayRecovered;
    private String activeCases;
    private String criticalCases;
    private String testPerOneMillion;
    private String casesPerOneMillion;
    private String deathsPerOneMillion;
    private String recoveredPerOneMillion;
    private String activePerOneMillion;
    private String criticalPerOneMillion;
    private String countryName;
    private String countryFlag;
    private String continent;
    private String oneTestPerPeople;
    private String oneCasePerPeople;
    private String oneDeathPerPeople;
    private String updatedTime;

    public CountriesModel() {
    }

    public CountriesModel(String countryName, String countryFlag) {
        this.countryName = countryName;
        this.countryFlag = countryFlag;
    }

    public CountriesModel(String totalPopulation, String totalTests, String totalCases, String todayCases, String totalDeaths, String todayDeaths, String totalRecovered, String todayRecovered, String activeCases, String criticalCases, String testPerOneMillion, String casesPerOneMillion, String deathsPerOneMillion, String recoveredPerOneMillion, String activePerOneMillion, String criticalPerOneMillion, String countryName, String countryFlag, String continent, String oneTestPerPeople, String oneCasePerPeople, String oneDeathPerPeople, String updatedTime) {
        this.totalPopulation = totalPopulation;
        this.totalTests = totalTests;
        this.totalCases = totalCases;
        this.todayCases = todayCases;
        this.totalDeaths = totalDeaths;
        this.todayDeaths = todayDeaths;
        this.totalRecovered = totalRecovered;
        this.todayRecovered = todayRecovered;
        this.activeCases = activeCases;
        this.criticalCases = criticalCases;
        this.testPerOneMillion = testPerOneMillion;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.activePerOneMillion = activePerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
        this.countryName = countryName;
        this.countryFlag = countryFlag;
        this.continent = continent;
        this.oneTestPerPeople = oneTestPerPeople;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.updatedTime = updatedTime;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(String totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public String getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(String totalTests) {
        this.totalTests = totalTests;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getCriticalCases() {
        return criticalCases;
    }

    public void setCriticalCases(String criticalCases) {
        this.criticalCases = criticalCases;
    }

    public String getTestPerOneMillion() {
        return testPerOneMillion;
    }

    public void setTestPerOneMillion(String testPerOneMillion) {
        this.testPerOneMillion = testPerOneMillion;
    }

    public String getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(String casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public String getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(String deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public String getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(String recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public String getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(String activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public String getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(String criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(String oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public String getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(String oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public String getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(String oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}