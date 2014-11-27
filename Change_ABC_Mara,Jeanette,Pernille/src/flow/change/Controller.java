/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

import Filehandler.FileHandler;
import Interface.Interface;
import java.util.Random;
import Model.Drugs;
import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class Controller implements Interface
{

    private Random random = new Random();
    private ArrayList<Drugs> drugArray = new ArrayList<>();
    private Drugs drugName;
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
        FileHandler.loadPerson(filename);

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
    public int calculateAvailability()
    {
        adjustAva = random.nextInt(40) + 15;
        if (adjustAva % 2 == 0)// denne kode tager kun højde for kokain
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity()) / 100);
            finalAvailability = getBaseAvailiablity() - middelSum;
            System.out.println("availability" + finalAvailability);
            return finalAvailability;
        } else
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity()) / 100);
            finalAvailability = getBaseAvailiablity() + middelSum;
            System.out.println("availability" + finalAvailability);
            return finalAvailability;
        }
    }

    @Override
    public void travel()
    {
       days++;
    }

    @Override
    public int getBasePrice()
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
    public int CalculateFinalPrice()
    {
        adjust = random.nextInt(85)+1;
        if (adjust % 2 == 0)// denne kode tager kun højde for kokain
        {
            middelSum = ((adjust * getBasePrice())/ 100);
            finalPrice = getBasePrice() - middelSum;
            System.out.println("Price" + finalPrice);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * getBasePrice())/ 100);
            finalPrice = getBasePrice() + middelSum;
            System.out.println("Price" + finalPrice);
            return finalPrice;
        }
    }

    @Override
    public int getBaseAvailiablity()
    {
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                return i.getBaseAvailability();

            } else
            {
                return 0;
            }
        }
        return 0;
    }

}
