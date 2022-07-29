package com.example.covid_19tracker;

public class Model {
    private String Sname;
    private  String dname;
    private long active;
    private long Recovered;
    private long Decreased;
    private long Confirmed;

    public Model(String stateName, String cityName, long active, long recovered, long decreased, long confirmed) {
        this.Sname = stateName;
        this.dname = cityName;
        this.active = active;
        this.Recovered = recovered;
        this.Decreased = decreased;
        this.Confirmed = confirmed;
    }

    public String getSname() {
        return Sname;
    }

    public String getDname() {
        return dname;
    }

    public long getActive() {
        return active;
    }

    public long getRecovered() {
        return Recovered;
    }

    public long getDecreased() {
        return Decreased;
    }

    public long getConfirmed() {
        return Confirmed;
    }

}