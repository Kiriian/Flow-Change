/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

/**
 *
 * @author Jeanette
 */
public class Person
{
    private int readyCash;
    private int highScore;
    private String username;

    public Person(int highScore, String username)
    {
        this.highScore = highScore;
        this.username = username;
    }

    public int getReadyCash()
    {
        return readyCash;
    }

    public void setReadyCash(int readyCash)
    {
        this.readyCash = readyCash;
    }

    public int getHighScore()
    {
        return highScore;
    }

    public void setHighScore(int highScore)
    {
        this.highScore = highScore;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "Person{" + "highScore=" + highScore + ", username=" + username + '}';
    }
       
}
