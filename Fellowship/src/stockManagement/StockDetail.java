package stockManagement;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class StockDetail 
{
	private String stockName;
	private long noOfShare;
	private long sharePrice;
	private long amount;
	private String stockSymbol;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(long noOfShare) {
		this.noOfShare = noOfShare;
	}
	public long getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(long sharePrice) {
		this.sharePrice = sharePrice;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	static void printStockReport()
	{
		JSONParser parser =new JSONParser();
		//ObjectMapper mapper=new ObjectMapper();
		JSONObject name[];
		Object o[];
		try {

			Object obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/stockinjson.json"));
			//System.out.println(obj);
			JSONArray array=new JSONArray();
			array=(JSONArray) obj;
			//System.out.println(array.size());
			name=new JSONObject[array.size()];
			o=new Object[array.size()];
			JSONObject jsonObject[]=new JSONObject[array.size()];
			int j=1;
			for (int i = 0; i < array.size(); i++)
			{

				o[i]=array.get(i);

				jsonObject[i]=(JSONObject) o[i];

				//System.out.println(jsonObject[i]);
				String cat="Stock"+j;
				name[i] = (JSONObject) jsonObject[i].get(cat);
				j++;
				StockDetail s=new StockDetail();
				s.setAmount((long)name[i].get("TotalAmount"));
				s.setNoOfShare((long)name[i].get("NumberOfShare"));
				s.setSharePrice((long)name[i].get("SharePrice"));
				s.setStockName((String)name[i].get("StockName"));
				s.setStockSymbol((String)name[i].get("StockSymbol"));
				System.out.println("Stock Name="+s.getStockName()+" Number Of Share="+s.getNoOfShare()+" Share Price="+s.getSharePrice()+" Total Amount="+s.getAmount()+" Symbol="+s.getStockSymbol());
			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
	}
}
