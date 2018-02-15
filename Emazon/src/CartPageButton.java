//Jefferson C. Bernard

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CartPageButton extends Button{
	public int pageNum;
	public Button pageButton;
	
	public CartPageButton(int pageNum)
	{
		this.pageNum = pageNum;
		this.pageButton = new Button(pageNum+"");
	}
	public Button getButtonPage()
	{
		return this.pageButton;
	}
	
	public int getPageNum()
	{
		return this.pageNum;
	}
}
