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
    private int factor;
    private Drugs i;

    private int endPrice;

    @Override
    public int buyDrugs(String username, String drugName, int amount)
    {
        userArray = FileHandler.loadPerson(".txt");
        for (Person p : userArray)
        {
            if (username.equals(p.getUsername()))
            {
                if (p.getScore() >= finalPrice)
                {
                    p.setScore(p.getScore() - finalPrice);
                    for (Drugs i : drugArray)
                    {
                        if (drugName.equals(i.getDrugName()))

                        {
                            i.setBaseAvailability(amount);
                            yourDrugs.add(i);
                            return p.getScore();
                        }

                    }
                } else
                {
                    return p.getScore();
                }

            }
        }
        return 0;
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
            addPerson(username, score);
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
//            endPrice =finalPrice * factor;
            System.out.println("endPrice" + endPrice);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * getBasePrice(drugName)) / 100);
            finalPrice = getBasePrice(drugName) + middelSum;
            System.out.println("Price" + finalPrice);
//            endPrice =finalPrice * factor;
            System.out.println("endPrice" + endPrice);
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
    public void addPerson(String userName, int score)
    {
        userArray.add(new Person(userName, score));

        FileHandler.save(userArray, "highscore.txt");
    }

    // beregner faktor til at gange på prisen. Faktor 10 hvis goldennumber er i in range.
    @Override
    public int goldenNumberFactor(String drugName)
    {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                if (chance <= i.getGoldenNumber())//virker ikke - finder ikke det valgte drugs golden number
                {
                    if (chance % 2 == 0)
                    {
                        factor = 10;
                    } else
                    {
                        factor = 1;
                    }
                } else
                {
                    factor = 1;
                }
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int endPrice(String drugName, int amount)
    {
        for (Drugs i : drugArray)
        {
            if (drugName.equals(i.getDrugName()))
            {
                endPrice = finalPrice * amount;
            }
        }

        return endPrice;
    }

}
