package stockManagement;

public class CustomerStockDetail 
{
	private int productShare[];
	int share[];
	String name[];
	private String productName[];
	/*public void getProductShare() {
		share=new int[productShare.length];
		System.out.print("[");
		for (int i = 0; i < productShare.length; i++) 
		{
			System.out.print(productShare[i]+",");
		}
			System.out.print("]");
	}
	void setProductShare(int share[]) {
		productShare=new int[share.length];
		for (int i = 0; i < share.length; i++) {

			productShare[i]=share[i];
			System.out.println(productShare[i]);
		}
	}
	public void getProductName() {
		name=new String[productName.length];
		System.out.print(" [");
		for (int i = 0; i < productName.length; i++) 
		{
			System.out.print(productName[i]+",");

		}
		System.out.print("]");

	}
	public void setProductName(String name[]) {
		productName=new String[name.length];
		for (int i = 0; i < name.length; i++) {
			productName[i]=name[i];
			System.out.println(productName[i]);
		}
	}
	 */
	public String[] getProductName() {

		return productName;
	}
	public void setProductName(String productName[]) {
		this.productName = productName;
	}
	public int[] getProductShare() {
		share=new int[productShare.length];

		return productShare;
	}
	public void setProductShare(int productShare[]) {
		this.productShare = productShare;
	}

}
