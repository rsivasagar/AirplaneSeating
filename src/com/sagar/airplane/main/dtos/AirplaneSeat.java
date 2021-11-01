package com.sagar.airplane.main.dtos;

public class AirplaneSeat 
{
    private Integer index;
    private String type;
    private Boolean isOccupied;
    private AirplanePassenger airplanePassenger;

    public AirplaneSeat(Integer index, String type, Boolean isOccupied, AirplanePassenger airplanePassenger) 
    {
        this.index = index;
        this.type = type;
        this.isOccupied = isOccupied;
        this.airplanePassenger = airplanePassenger;
    }

    public Integer getIndex() 
    {
        return index;
    }

    public void setIndex(Integer index) 
    {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String String)
    {
        this.type = String;
    }

    public Boolean getIsOccupied() 
    {
        return isOccupied;
    }

    public void setIsOccupied(Boolean isOccupied) 
    {
        this.isOccupied = isOccupied;
    }

    public AirplanePassenger getAirplanePassenger() 
    {
        return airplanePassenger;
    }

    public void setAirplanePassenger(AirplanePassenger airplanePassenger) 
    {
        this.airplanePassenger = airplanePassenger;
    }
}
