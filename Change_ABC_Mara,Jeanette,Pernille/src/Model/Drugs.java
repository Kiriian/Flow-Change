/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Pernille
 */
public class Drugs
{
    private String drugName;
    private int basePrice;
    private int baseAvailability;
    private ArrayList<Drugs> drugArray = new ArrayList<>();

    public Drugs(String drugName, int basePrice, int baseAvailability)
    {
        this.drugName = drugName;
        this.basePrice = basePrice;
        this.baseAvailability = baseAvailability;
    }
    public void addDrugs()
    {
    drugArray.add(new Drugs("Cocaine", 1200, 30));
    drugArray.add(new Drugs("herion", 1600, 15));
    drugArray.add(new Drugs ("amphetamine", 200, 50));
    drugArray.add(new Drugs ("acid", 550, 33));
    drugArray.add(new Drugs ("angel", 400, 60));
    drugArray.add(new Drugs ("chrystal meth", 800, 38));
    drugArray.add(new Drugs ("hash", 180, 100));
    drugArray.add(new Drugs ("weed", 150, 115));
    drugArray.add(new Drugs ("mushrooms", 120, 95));
     
    }
    



    
}
