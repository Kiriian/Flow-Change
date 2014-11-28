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
import Model.Person;
import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class Controller implements ChangeInterface
{

    private Random random = new Random();
    private ArrayList<Drugs> drugArray = new ArrayList<>();
    private ArrayList<Person> userArray = new ArrayList<>();
    private ArrayList<Drugs> yourDrugs = new ArrayList<>();
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
        FileHandler.save(userArray, "highscore.txt");

        if (userArray == null)
        {
            return false;
        } else
        {
            return true;
        }
    }

    @Override
    public int sellDrugs(String drugName)
    {
        Drugs temp = null;
        for (Drugs dObject : yourDrugs)
        {
            if (dObject.getDrugName().equals(drugName))
            {
                temp = dObject;
                return temp.getBaseAvailability();

            }
        }
        return 0;
    }

    @Override
    public int calculateAvailability(String drugName)
    {
        adjustAva = random.nextInt(40) + 15;
        System.out.println("adjustAva " + adjustAva);
        if (adjustAva % 2 == 0)
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity(drugName)) / 100);
            finalAvailability = getBaseAvailiablity(drugName) - middelSumAva;
            System.out.println("middelsum" + middelSumAva);

            System.out.println("availability?" + finalAvailability);
            return finalAvailability;
        } else
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity(drugName)) / 100);
            finalAvailability = getBaseAvailiablity(drugName) + middelSumAva;
            System.out.println("middelsum" + middelSumAva);
            System.out.println("availability" + finalAvailability);
            return finalAvailability;
        }
    }

    @Override
    public void travel(String username, int score)
    {
        if (days == 20)
        {
            addPerson(username, score);
        } else
        {
            days++;
        }
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
        adjust = random.nextInt(85) + 1;
        if (adjust % 2 == 0)// denne kode tager kun højde for kokain
        {
            middelSum = ((adjust * getBasePrice(drugName)) / 100);
            finalPrice = getBasePrice(drugName) - middelSum;
            System.out.println("Price" + finalPrice);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * getBasePrice(drugName)) / 100);
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
                return i.getBaseAvailability();
            } else
            {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public void addPerson(String userName, int score)
    {
        userArray.add(new Person(userName, score));

        FileHandler.save(userArray, "highscore.txt");
    }

}
