package com.sagar.airplane.main.impl;

import com.sagar.airplane.main.dtos.*;

import java.text.*;
import java.util.*;

public class AirplaneImpl {

	public enum SeatType {
	    W, M, A;
	}
	
    public Airplane createAirplane(int[][] inputData) 
    {
        Airplane airplane = new Airplane();
        for (int groupCounter = 0; groupCounter < inputData.length; groupCounter++) 
        {
            AirplaneSeatGroup group = getAirplaneSeatGroup(inputData[groupCounter], inputData.length, groupCounter);
            airplane.getAirplaneSeatGroups().add(group);
        }
        return airplane;
    }
    
    private AirplaneSeatGroup getAirplaneSeatGroup(int[] seatGroupArray, int totalNumberOfSeatGroups, int seatGroupIndex) 
    {
        int numberOfRows = seatGroupArray[1];
        int numberOfColumns = seatGroupArray[0];
        List<AirplaneRow> seatRows = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) 
        {
            AirplaneRow seatRow = getRow(totalNumberOfSeatGroups, seatGroupIndex, numberOfColumns, rowIndex);
            seatRows.add(seatRow);
        }
        return new AirplaneSeatGroup(seatGroupIndex, numberOfColumns, numberOfRows, seatRows);
    }
    
    public int getMaxNumberOfRowsInAirplane(Airplane airplane)
    {
    	return airplane.getAirplaneSeatGroups().stream().max(Comparator.comparing(AirplaneSeatGroup::getNumberOfRows)).get().getNumberOfRows();
    }

    public void performPrintOperation(Airplane airplane) 
    {
    	NumberFormat formatter = new DecimalFormat("000");
        int maxNoOfRows = getMaxNumberOfRowsInAirplane(airplane);

        for (int rowNumber = 0; rowNumber <= maxNoOfRows; rowNumber++) 
        {
        	for (AirplaneSeatGroup seatGroup : airplane.getAirplaneSeatGroups()) 
        	{
                for (int colCounter = 0; colCounter < seatGroup.getNumberOfColumns(); colCounter++)
                {
                    if (seatGroup.getAirplaneRows().size() > rowNumber) 
                    {
                        AirplaneRow seatRow = seatGroup.getAirplaneRows().get(rowNumber);
                        AirplaneSeat seat = seatRow.getAirplaneSeats().get(colCounter);
                        if (null != seat.getAirplanePassenger()) 
                        {
                            int passengerId = seat.getAirplanePassenger().getPassengerId();
                            System.out.print(formatter.format(passengerId) + " ");
                        } 
                        else 
                        {
                            System.out.print("    ");
                        }
                    } 
                    else 
                    {
                        System.out.print("    ");
                    }
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    public Airplane arrangePassengersInAirplane(Airplane airplane, int passengerCount) throws Exception {
        
    	Queue<AirplanePassenger> queue = new LinkedList<AirplanePassenger>();
        
        for (int passengerIndex = 1; passengerIndex <= passengerCount; passengerIndex++) 
        {
        	queue.add(new AirplanePassenger(passengerIndex));
        }
        boardPassengers(airplane, queue, SeatType.A);
        boardPassengers(airplane, queue, SeatType.W);
        boardPassengers(airplane, queue, SeatType.M);

        return airplane;
    }

    private AirplaneRow getRow(int totalNumberOfSeatGroups, int seatGroupIndex, int numberOfColumns, int rowIndex) {
        List<AirplaneSeat> seats = new ArrayList<>();
        for (int seatIndex = 0; seatIndex < numberOfColumns; seatIndex++) 
        {
            AirplaneSeat seat = new AirplaneSeat(seatIndex, getSeatType(totalNumberOfSeatGroups, seatGroupIndex, numberOfColumns, seatIndex).toString(), false, null);
            seats.add(seat);
        }
        AirplaneRow seatRow = new AirplaneRow(rowIndex, seats);
        return seatRow;
    }

    private SeatType getSeatType(int numberOfSeatGroups, int seatGroupIndex, int numberOfColumns, int seatIndex) {
        SeatType seatType;
        if ((seatIndex == 0 && seatGroupIndex == 0) || (seatIndex == numberOfColumns - 1 && seatGroupIndex == numberOfSeatGroups - 1)) 
        {
            seatType = SeatType.W;
        } 
        else if (seatIndex == 0 || seatIndex == numberOfColumns - 1) 
        {
            seatType = SeatType.A;
        } 
        else 
        {
            seatType = SeatType.M;
        }
        return seatType;
    }

    private Airplane boardPassengers(Airplane airplane, Queue<AirplanePassenger> passengerQueue, SeatType seatType) 
    {
        int maxNoOfRows = getMaxNumberOfRowsInAirplane(airplane);
        for (int rowNumber = 0; rowNumber < maxNoOfRows; rowNumber++) 
        {
            for (AirplaneSeatGroup seatGroup : airplane.getAirplaneSeatGroups()) 
            {
                for (int colCounter = 0; colCounter < seatGroup.getNumberOfColumns(); colCounter++) {
                    if (seatGroup.getAirplaneRows().size() > rowNumber) 
                    {
                        if (!passengerQueue.isEmpty()) 
                        {
                            AirplaneRow row = seatGroup.getAirplaneRows().get(rowNumber);
                            AirplaneSeat airplaneSeat = row.getAirplaneSeats().get(colCounter);
                            if (airplaneSeat.getType() == seatType.toString()) 
                            {
                                airplaneSeat.setAirplanePassenger(passengerQueue.poll());
                                airplaneSeat.setIsOccupied(true);
                            }
                        }
                    }
                }
            }
        }
        return airplane;
    }
}
