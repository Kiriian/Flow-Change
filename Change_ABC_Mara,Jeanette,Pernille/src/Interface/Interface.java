/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Marta, Pernille og Jeanette
 */
public interface Interface
{
    // metode til at ændre GUI og som tæller dagene.
    void travel();
    
    // metode til at beregne den endelige availability af drugs. returnerer antal.
   int calculateAvailability();
   
    int getBasePrice();

    // metode til at udregne den endelige prise for en pakke af drugs 
    int CalculateFinalPrice();
    
    int getBaseAvailiablity();
    
    //her bliver total prisen udregnet og trukket fra persones konto
    void buyDrugs();
    
    //her bliver total prisen udregnet og tilføjet til persones konto
    void sellDrugs();
    
    //
    boolean load(String filename);
    
    // 
    boolean save(String filename);
}
