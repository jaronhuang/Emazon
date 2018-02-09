/**
 * By: Jaron Huang and Kelvin Chen
 */
public class Shoes implements Items{

	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String color;
	public int size;
	public String image;
	
	public Shoes(double price, int quantity, String name,
			double rating, String color, int size, String image)
	{
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.rating = rating;
		this.color = color;
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public double getRating() {
		return rating;
	}
	public String getColor() {
		return color;
	}
	public int getSize()
	{
		return size;
	}
	public String getImage() {
		return image;
	}
}
