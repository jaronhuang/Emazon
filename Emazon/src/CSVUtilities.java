/**
  * By: Jaron Huang 
  */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtilities 
{
	public ArrayList<String> CSVData = new ArrayList<String>();
	
	public CSVUtilities(File csv) throws IOException
	{
		FileReader csvF = new FileReader(csv);
		
		try (BufferedReader br = new BufferedReader(csvF))
		{
			String line = br.readLine();
			while (line != null)
			{
				this.CSVData.add(line);
            	line = br.readLine();
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public ArrayList<String> getCSVData() {
		return CSVData;
	}

	public void setCSVData(ArrayList<String> cSVData) {
		CSVData = cSVData;
	}

	public List<String> getColumnHeaders()
	{
		return Arrays.asList(CSVData.get(0).split(","));
	}
	
	public ArrayList<String> getDataString(int column)
	{
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 1; i < CSVData.size(); i++)
		{
			String[] hold = CSVData.get(i).split(",");
			data.add(hold[column]);
		}
		return data;
	}
	
	public ArrayList<Integer> getDataInteger(int column)
	{
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 1; i < CSVData.size(); i++)
		{
			String[] hold = CSVData.get(i).split(",");
			data.add(Integer.parseInt(hold[column]));
		}
		return data;
	}
	
	public ArrayList<Double> getDataDouble(int column)
	{
		ArrayList<Double> data = new ArrayList<Double>();
		for (int i = 1; i < CSVData.size(); i++)
		{
			String[] hold = CSVData.get(i).split(",");
			data.add(Double.parseDouble(hold[column]));
		}
		return data;
	}
		 
	static File file = new File("cart.csv");
	public static void writeCSV(String name, int quantity, double price, String image)
	{
		CSVUtilities csv = null;
		try 
		{
			csv = new CSVUtilities(file);
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int line = 1;
		csv.getCSVData().add(line, name + "," + quantity + "," + (price * quantity) + "," + image);
		try 
		{
			Files.write(Paths.get("cart.csv"), csv.getCSVData());
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static File pFile = new File("phistory.csv");
	public static void writePHistory(String name, String email, String itemname, int quantity, double price)
	{
		CSVUtilities csv = null;
		try 
		{
			csv = new CSVUtilities(pFile);
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int line = 1;
		csv.getCSVData().add(line, name + "," + email + "," + itemname + "," + quantity + "," + (price * quantity));
		try 
		{
			Files.write(Paths.get("phistory.csv"), csv.getCSVData());
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

