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
    private int goldenNumber;

    public Drugs(String drugName, int basePrice, int baseAvailability, int goldenNumber)
    {
        this.drugName = drugName;
        this.basePrice = basePrice;
        this.baseAvailability = baseAvailability;
        this.goldenNumber = goldenNumber;
    }

    public int getGoldenNumber()
    {
        return goldenNumber;
    }

    public void setGoldenNumber(int goldenNumber)
    {
        this.goldenNumber = goldenNumber;
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

    @Override
    public String toString()
    {
        return "Drugs{" + "drugName=" + drugName + ", basePrice=" + basePrice + ", baseAvailability=" + baseAvailability + ", goldenNumber=" + goldenNumber + '}';
    }
}
