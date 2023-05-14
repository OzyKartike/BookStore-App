
/**
 *
 * @author hsuresh
 */
package javafxapplication3;
public class Book 
{
    private String Name;
    private double Price;
    
   
    /**
     * Constructor for objects of class Book
     * @param Name
     * @param Price
     */
    public Book (String Name, double Price)
    {
        this.Name = Name;
        this.Price = Price;
    }
    public String getBookName()
    {
        return Name;
    }
    public double getPrice()
    {
        return Price;
    }

    /**
     *
     * @param BookName
     */
    public void setBookName(String BookName) 
    {
        this.Name = BookName;
    }
    public void setPrice(double Price)
    {
        this.Price= Price;
        
    }
}
