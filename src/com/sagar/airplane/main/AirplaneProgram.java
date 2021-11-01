package com.sagar.airplane.main;

import com.sagar.airplane.main.dtos.Airplane;
import com.sagar.airplane.main.impl.AirplaneImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AirplaneProgram {

    public static void main(String[] args) 
    {
        try 
        {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        	
            System.out.println("Enter number of Groups : ");
            int numberOfGroups = Integer.parseInt(reader.readLine());

            int[][] inputData = new int[numberOfGroups][2];
            System.out.println("Enter space separated Group data (Eg: 3 4) :");
            for (int counter = 0; counter < numberOfGroups; counter++) 
            {
                String readLine = reader.readLine();
                String[] split = readLine.split(" ");
                inputData[counter][0] = Integer.parseInt(split[0]);
                inputData[counter][1] = Integer.parseInt(split[1]);
            }

            System.out.println("Enter number of Passengers :");
            int passengerCount = Integer.parseInt(reader.readLine());

            AirplaneImpl airplaneImpl = new AirplaneImpl();
            Airplane airplaneModel = airplaneImpl.createAirplane(inputData);
            airplaneImpl.arrangePassengersInAirplane(airplaneModel, passengerCount);
            System.out.println("Boarded Passengers : ");
            airplaneImpl.performPrintOperation(airplaneModel);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}
