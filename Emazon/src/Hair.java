/**
 * By: Jaron Huang and Kelvin Chen
 */
public class Hair implements Items{
	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String color;
	public String image;
	
	public Hair(int i)
	{
		this.price = Runner.price.get(i);
		this.quantity = Runner.quantity.get(i);
		this.name = Runner.itemNames.get(i);
		this.rating = Runner.rating.get(i);
		this.color = Runner.color.get(i);
		this.image = Runner.imageFiles.get(i);
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

	public String getImage() {
		return image;
	}
	

}
