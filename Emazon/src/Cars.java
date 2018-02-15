import java.io.File;
import java.util.ArrayList;

public class Cars implements Items
{
	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String model;
	public String color;
	public double mileage;
	public String image;
	
	public Cars(int i)
	{
		this.price = Runner.price.get(i);
		this.quantity = Runner.quantity.get(i);
		this.name = Runner.itemNames.get(i);
		this.rating = Runner.rating.get(i);
		this.model = Runner.model.get(i);
		this.color = Runner.color.get(i);
		this.mileage = Runner.mileage.get(i);
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

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public double getMilage() {
		return mileage;
	}
	public String getImage() {
		return image;
	}
}
