/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import flow.change.Controller;

/**
 *
 * @author Jeanette
 */
public class Person
{
   
    private int score;
    private String username;

    public Person(String username)
    {
        this.score = 5000;
        this.username = username;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int Score)
    {
        this.score = Score;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int keepScore(int quantity)
    {
        score = score + Controller.endPrice(quantity);
        
        return score;
    }
    
    @Override
    public String toString()
    {
        return "Person{" + "Score=" + score + ", username=" + username + '}';
    }
       
}
