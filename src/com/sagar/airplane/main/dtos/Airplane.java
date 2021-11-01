package com.sagar.airplane.main.dtos;

import java.util.ArrayList;
import java.util.List;

public class Airplane
{
    private List<AirplaneSeatGroup> airplaneSeatGroups = new ArrayList<>();

    public List<AirplaneSeatGroup> getAirplaneSeatGroups() 
    {
        return airplaneSeatGroups;
    }
}
