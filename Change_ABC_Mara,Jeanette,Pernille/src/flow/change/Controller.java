/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

import Filehandler.FileHandler;
import Interface.ChangeInterface;
import java.util.Random;
import Model.Drugs;
import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class Controller implements ChangeInterface
{

    private Random random = new Random();
    private ArrayList<Drugs> drugArray = new ArrayList<>();
    private String drugName;
    private int adjust;
    private int adjustAva;
    private int middelSum;
    private int finalPrice;
    private int middelSumAva;
    private int finalAvailability;
    private int days;

    @Override
    public void buyDrugs()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load(String filename)
    {
        drugArray = FileHandler.loadDrugs("Drugs.txt");

        if (drugArray == null)
        {
            return false;
        } else
        {
            return true;
        }
    }

    @Override
    public boolean save(String filename)
    {
        FileHandler.save(null, filename);

        return true;
    }

    @Override
    public void sellDrugs()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculateAvailability(String drugName)
    {
        adjustAva = random.nextInt(40) + 15;
        System.out.println("adjustAva "+adjustAva);
        if (adjustAva % 2 == 0)
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity(drugName)) / 100);
            finalAvailability = getBaseAvailiablity(drugName) - middelSumAva;
            System.out.println("middelsum"+middelSumAva);
                    
            System.out.println("availability?" + finalAvailability);
            return finalAvailability;
        } else
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity(drugName)) / 100);
            finalAvailability = getBaseAvailiablity(drugName) + middelSumAva;
            System.out.println("middelsum"+middelSumAva);
            System.out.println("availability" + finalAvailability);
            return finalAvailability;
        }
    }

    @Override
    public void travel()
    {
       days++;
        System.out.println("Number of Days: " + days);
    }

    @Override
    public int getBasePrice(String drugName)
    {
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                return i.getBasePrice();

            } else
            {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int CalculateFinalPrice(String drugName)
    {
        adjust = random.nextInt(85)+1;
        if (adjust % 2 == 0)// denne kode tager kun højde for kokain
        {
            middelSum = ((adjust * getBasePrice(drugName))/ 100);
            finalPrice = getBasePrice(drugName) - middelSum;
            System.out.println("Price" + finalPrice);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * getBasePrice(drugName))/ 100);
            finalPrice = getBasePrice(drugName) + middelSum;
            System.out.println("Price" + finalPrice);
            return finalPrice;
        }
    }

    @Override
    public int getBaseAvailiablity(String drugName)
    {
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                System.out.println("Gere");
                return i.getBaseAvailability();

            } else
            {
                return 0;
            }
        }
        return 0;
    }

}
