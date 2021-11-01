package com.sagar.airplane.main.dtos;

public class AirplanePassenger {
	
	private Integer passengerId;
	
    public AirplanePassenger(Integer passengerId) 
    {
        this.passengerId = passengerId;
    }
    
    public Integer getPassengerId() 
    {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) 
    {
        this.passengerId = passengerId;
    }
}
