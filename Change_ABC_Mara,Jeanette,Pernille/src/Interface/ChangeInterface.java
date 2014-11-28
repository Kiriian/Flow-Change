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
public interface ChangeInterface
{
    void addPerson(String userName, int highScore);

    // metode til at ændre GUI og som tæller dagene.
    int travel(String username, int score);
    
    // metode til at beregne den endelige availability af drugs. returnerer antal.
   int calculateAvailability(String drugName);
   
    int getBasePrice(String drugName);

    // metode til at udregne den endelige prise for en pakke af drugs 
    int CalculateFinalPrice(String drugName);
    
    
    int getBaseAvailiablity(String drugName);
    
    //her bliver total prisen udregnet og trukket fra persones konto
    void buyDrugs();
    
    //her bliver total prisen udregnet og tilføjet til persones konto
    int sellDrugs(String drugName);
    
    //
    boolean load(String filename);
    
    // 
    boolean save(String filename);
}
