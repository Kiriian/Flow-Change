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

    public Drugs(String drugName, int basePrice, int baseAvailability)
    {
        this.drugName = drugName;
        this.basePrice = basePrice;
        this.baseAvailability = baseAvailability;
    }

    public String getDrugName()
    {
        return drugName;
    }

    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
    }

    public int getBasePrice()
    {
        return basePrice;
    }

    public void setBasePrice(int basePrice)
    {
        this.basePrice = basePrice;
    }

    public int getBaseAvailability()
    {
        return baseAvailability;
    }

    public void setBaseAvailability(int baseAvailability)
    {
        this.baseAvailability = baseAvailability;
    }
    
}
