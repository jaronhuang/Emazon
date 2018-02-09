/**
 * By: Jaron Huang and Kelvin Chen
 */
import java.io.File;

public class Technology implements Items{

	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String type;
	public double batteryLife;
	public String image;
	
	public Technology(double price, int quantity, String name,
			double rating, String type, double batteryLife, String image)
	{
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.rating = rating;
		this.type = type;
		this.batteryLife = batteryLife;
		this.image = image;
	}
	
	public double getPrice()
	{
		return price;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public String getName()
	{
		return name;
	}
	public double getRating()
	{
		return rating;
	}
	public String getType()
	{
		return type;
	}
	
	public double getBatteryLife()
	{
		return batteryLife;
	}
	public String getImage() {
		return image;
	}
}
