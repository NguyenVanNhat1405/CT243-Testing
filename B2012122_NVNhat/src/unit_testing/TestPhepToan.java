package unit_testing;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import thuvien.tinhtoan.PhepTinh;

public class TestPhepToan {
	private static final double delta = 1e-15;
	
	@BeforeMethod
	public void before() {
		System.out.println("Before");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("After");
	}
	
	@Test(dataProvider="testdata1")
	public void TestCong(float x, float y, float expected) {
		float actual = PhepTinh.Op('+', x, y);
		Assert.assertEquals(actual, expected, delta, "Tinh toan sai");
		System.out.println("Tinh toan dung");
		
	}
	
	@Test(dataProvider="testdata2")
	public void TestTru(float x, float y, float expected) {
		float actual = PhepTinh.Op('-', x, y);
		Assert.assertEquals(actual, expected, delta, "Tinh toan sai");
		System.out.println("Tinh toan dung");
		
	}
	
	@Test(dataProvider="testdata3")
	public void TestNhan(float x, float y, float expected) {
		float actual = PhepTinh.Op('*', x, y);
		Assert.assertEquals(actual, expected, delta, "Tinh toan sai");
		System.out.println("Tinh toan dung");
	}
	
	@DataProvider(name="testdata1")
	public Object[][] TestDataFeed1()
	{
		ReadExcelFile config = new ReadExcelFile("D:\\Kiem Thu Tu Dong\\Bai tap them ve Data driven testing\\Baitap1\\Thu vien va Du lieu kiem thu\\TestData.xlsx");
				
		int rows = config.getRowCount(0); //sheet1
		
		Object[][] data = new Object[rows][3]; //row dong, 3 cot
		
		for(int i=0; i<rows; i++)
		{
			data[i][0] = (float)config.getNumbericData(0, i, 0); // sheet1, dong i, cot1
			data[i][1] = (float)config.getNumbericData(0, i, 1); // sheet1, dong i, cot2	
			data[i][2] = (float)config.getNumbericData(0, i, 2); // sheet1, dong i, cot3
		}
		
		return data;
	}
	
	@DataProvider(name="testdata2")
	public Object[][] TestDataFeed2()
	{
		ReadExcelFile config = new ReadExcelFile("D:\\Kiem Thu Tu Dong\\Bai tap them ve Data driven testing\\Baitap1\\Thu vien va Du lieu kiem thu\\TestData.xlsx");
			
		int rows = config.getRowCount(1); //sheet2
		
		Object[][] data = new Object[rows][3]; //row dong, 3 cot
		
		for(int i=0; i<rows; i++)
		{
			data[i][0] = (float)config.getNumbericData(1, i, 0); // sheet2, dong i, cot1
			data[i][1] = (float)config.getNumbericData(1, i, 1); // sheet2, dong i, cot2
			data[i][2] = (float)config.getNumbericData(1, i, 2); // sheet2, dong i, cot3
		}
		
		return data;
	}
	
	@DataProvider(name="testdata3")
	public Object[][] TestDataFeed3()
	{
		ReadExcelFile config = new ReadExcelFile("D:\\Kiem Thu Tu Dong\\Bai tap them ve Data driven testing\\Baitap1\\Thu vien va Du lieu kiem thu\\TestData.xlsx");
				
		int rows = config.getRowCount(2); //sheet3
		
		Object[][] data = new Object[rows][3]; //row dong, 3 cot
		
		for(int i=0; i<rows; i++)
		{
			data[i][0] = (float)config.getNumbericData(2, i, 0); // sheet3, dong i, cot1
			data[i][1] = (float)config.getNumbericData(2, i, 1); // sheet3, dong i, cot2	
			data[i][2] = (float)config.getNumbericData(2, i, 2); // sheet3, dong i, cot3
		}
		
		return data;
	}
	

}
