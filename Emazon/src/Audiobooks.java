/**
 * By: Jaron Huang and Kelvin Chen

 */


public class Audiobooks implements Items {

	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String soundFile;
	public int length;
	public String image;

	
	public Audiobooks(double price, int quantity, String name,
			double rating, String soundFile, int length, String image)
	{
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.rating = rating;
		this.soundFile = soundFile;
		this.length = length;
		this.image = image;
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
	public String getSoundFile() {
		return soundFile;
	}
	public int getLength() {
		return length;
	}

	public String getImage() {
		return image;
	}
	
}
