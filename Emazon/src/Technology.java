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
	
	public Technology(int i)
	{
		this.price = Runner.price.get(i);
		this.quantity = Runner.quantity.get(i);
		this.name = Runner.itemNames.get(i);
		this.rating = Runner.rating.get(i);
		this.type = Runner.type.get(i);
		this.batteryLife = Runner.batteryLife.get(i);
		this.image = Runner.imageFiles.get(i);
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
