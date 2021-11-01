package com.sagar.airplane.main.dtos;

import java.util.ArrayList;
import java.util.List;

public class AirplaneRow {
    private Integer index;
    private List<AirplaneSeat> airplaneSeats = new ArrayList<>();

    public AirplaneRow(Integer index, List<AirplaneSeat> airplaneSeats) 
    {
        this.index = index;
        this.airplaneSeats = airplaneSeats;
    }

    public Integer getIndex() 
    {
        return index;
    }

    public void setIndex(Integer index) 
    {
        this.index = index;
    }

    public List<AirplaneSeat> getAirplaneSeats() 
    {
        return airplaneSeats;
    }
}
