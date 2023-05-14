/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication3;

/**
 *
 * @author kartc
 */
public class Customer 
{
    private String Name;
    private double Points;
    
   
    /**
     * Constructor for objects of class Book
     * @param Name
     * @param Price
     */
    public Customer (String Name, double Points)
    {
        this.Name = Name;
        this.Points = Points;
    }
    public String getCustomerName()
    {
        return Name;
    }
    public double getPoints()
    {
        return Points;
    }

    /**
     *
     * @param BookName
     */
    public void setCustomerName(String customerName) 
    {
        this.Name = customerName;
    }
    public void setPoints(double Points)
    {
        this.Points= Points;
        
    }
}
