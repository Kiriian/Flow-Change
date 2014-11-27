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
    private ArrayList <Drugs> drugArray = new ArrayList<>();
    private int adjust;
    private int adjustAva;
    private int middelSum;
    private int finalPrice;
    private int middelSumAva;
    private int finalAvailability;
    
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
        
        if (drugArray == null )
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
    public void travel(int days)// her tænker jeg at der skal slettes int days - da vi ikke giver antallet af dage med til metoden - vi beregner den her
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CalculateFinalPrice()
    {
       adjust = random.nextInt(85)+1;
       if(adjust%2==0)// denne kode tager kun højde for kokain
       {
           middelSum =((adjust*cocaine.getBasePriceCocaine())/100);
           finalPrice = cocaine.getBasePriceCocaine()-middelSum;
           System.out.println("pris"+finalPrice);
           return finalPrice;
           
       }else
       {
           middelSum =((adjust*cocaine.getBasePriceCocaine())/100);
           finalPrice = cocaine.getBasePriceCocaine()+middelSum;
           System.out.println("pris"+finalPrice);
           return finalPrice;
       }     
    }

    @Override
    public int calculateAvailability()
    {
       adjustAva = random.nextInt(40)+15;
       if(adjustAva%2==0)// denne kode tager kun højde for kokain
       {
           middelSumAva =((adjustAva*cocaine.getBaseAvailabilityCocaine())/100);
           finalAvailability = cocaine.getBasePriceCocaine()-middelSum;
           System.out.println("availability"+finalAvailability);
           return finalAvailability;
       }else
       {
           middelSumAva =((adjustAva*cocaine.getBasePriceCocaine())/100);
           finalAvailability = cocaine.getBaseAvailabilityCocaine()+middelSum;
           System.out.println("availability"+finalAvailability);
           return finalAvailability;
       }     
    }
    
}
