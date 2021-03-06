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
    private int adjust;
    private int adjustAva;
    private int middelSum;
    private int finalPrice;
    private int middelSumAva;
    private int finalAvailability;
    private int days;
    private int factor;
    private Drugs i;
    private Person p;
    private int endPrice;

    @Override
    public void buyDrugs(Drugs drug, int quantity)
    {
        if (!yourDrugs.isEmpty())
        {
            for (Drugs i : yourDrugs)
            {
                if (drug.getDrugName().equals(i.getDrugName()))
                {
                    i.setBaseAvailability(i.getBaseAvailability() + quantity);
                    System.out.println(yourDrugs.toString() + "fisk");
                    break;
                }
            }
        } else
        {
            System.out.println(i);
            drug.setBaseAvailability(quantity);
            yourDrugs.add(drug);
            System.out.println(yourDrugs.toString() + "hello");
        }
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
            System.out.println("middelsum" + middelSumAva + "adjust" + adjustAva);

            System.out.println("availability?" + finalAvailability);
            return finalAvailability;
        } else
        {
            middelSumAva = ((adjustAva * getBaseAvailiablity(drugName)) / 100);
            finalAvailability = getBaseAvailiablity(drugName) + middelSumAva;
            System.out.println("middelsum" + middelSumAva);
            System.out.println("availability" + finalAvailability + "adjust" + adjustAva);
            return finalAvailability;
        }
    }

    @Override
    public int travel(String username, int score)
    {
        if (days == 20)
        {
            addPerson(username);
            return days;
        } else
        {
            days++;
            return days;
        }
    }

    @Override
    public int getBasePrice(String drugName)
    {
        drugArray = FileHandler.loadDrugs("Drugs.txt");

        int temp = 0;
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                temp = i.getBasePrice();
            }

        }
        return temp;
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
            finalPrice = finalPrice * goldenNumberFactor(drugName);
            System.out.println("endPrice" + finalPrice);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * getBasePrice(drugName)) / 100);
            finalPrice = getBasePrice(drugName) + middelSum;
            System.out.println("Price" + finalPrice);
            finalPrice = finalPrice * goldenNumberFactor(drugName);
            System.out.println("endPrice" + finalPrice);
            return finalPrice;
        }
    }

    @Override
    public int getBaseAvailiablity(String drugName)
    {
        drugArray = FileHandler.loadDrugs("Drugs.txt");

        int temp = 0;
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                temp = i.getBaseAvailability();
                break;
            }

        }
        return temp;
    }

    @Override
    public void addPerson(String userName)
    {
        userArray.add(new Person(userName));

    }

    // beregner faktor til at gange på prisen. Faktor 10 hvis goldennumber er i in range.
    @Override
    public int goldenNumberFactor(String drugName)
    {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        System.out.println(chance);
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                if (chance <= i.getGoldenNumber())//virker ikke - finder ikke det valgte drugs golden number
                {
                    if (chance % 2 == 0)
                    {
                        factor = 10;
                        return factor;
                    } else
                    {
                        factor = 1;
                        return factor;
                    }
                } else
                {
                    factor = 1;
                    return factor;
                }
            }
        }
        return 0;
    }

    @Override
    public int endPrice(int quantity)
    {
        endPrice = finalPrice * quantity;

        return endPrice;
    }

}
