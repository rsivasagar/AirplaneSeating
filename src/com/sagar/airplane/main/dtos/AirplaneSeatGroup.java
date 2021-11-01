package com.sagar.airplane.main.dtos;

import java.util.ArrayList;
import java.util.List;

public class AirplaneSeatGroup 
{
    private Integer index;
    private Integer numberOfColumns;
    private Integer numberOfRows;
    private List<AirplaneRow> airplaneRows = new ArrayList<>();


    public AirplaneSeatGroup(Integer index, int numberOfColumns, int numberOfRows, List<AirplaneRow> airplaneRows) 
    {
        this.index = index;
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.airplaneRows = airplaneRows;
    }

    public Integer getIndex() 
    {
        return index;
    }

    public void setIndex(Integer index) 
    {
        this.index = index;
    }

    public Integer getNumberOfColumns() 
    {
        return numberOfColumns;
    }

    public void setNumberOfColumns(Integer numberOfColumns) 
    {
        this.numberOfColumns = numberOfColumns;
    }

    public Integer getNumberOfRows() 
    {
        return numberOfRows;
    }

    public void setNumberOfRows(Integer numberOfRows) 
    {
        this.numberOfRows = numberOfRows;
    }

    public List<AirplaneRow> getAirplaneRows() 
    {
        return airplaneRows;
    }
}
