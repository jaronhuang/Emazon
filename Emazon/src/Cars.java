
public class Cars implements Items
{
	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String model;
	public String color;
	public double milage;
	
	public Cars(double price, int quantity, String name,
			double rating, String model, String color, double milage)
	{
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.rating = rating;
		this.model = model;
		this.color = color;
		this.milage = milage;
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

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public double getMilage() {
		return milage;
	}

}
