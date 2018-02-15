/**
 * By: Jaron Huang and Kelvin Chen

 */

public class Songs implements Items {

	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String soundFile;
	public String length;
	public String image;

	
	public Songs(int i)
	{
		this.price = Runner.price.get(i);
		this.quantity = Runner.quantity.get(i);
		this.name = Runner.itemNames.get(i);
		this.rating = Runner.rating.get(i);
		this.soundFile = Runner.audioFile.get(i);
		this.length = Runner.length.get(i);
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
	public String getSoundFile() {
		return soundFile;
	}
	public String getLength() {
		return length;
	}

	public String getImage() {
		return image;
	}
	
}
