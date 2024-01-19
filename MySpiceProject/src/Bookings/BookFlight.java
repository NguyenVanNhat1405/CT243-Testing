package Bookings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BookFlight {
	@Test
	public void BookFligh_RoundTrip_TestCase1()
	{
		System.out.println("TestCase1");
	}
	@Test(dependsOnMethods=("BookFligh_Oneway_TestCase3"))
	public void BookFligh_RoundTrip_TestCase2()
	{
		System.out.println("TestCase2");	
	}
	@Test
	public void BookFligh_Oneway_TestCase3()
	{
		System.out.println("TestCase3");
	}
	@Test
	public void BookFligh_Oneway_TestCase4()
	{
		System.out.println("TestCase4");
	}
	@BeforeTest
	public void Beforetesttestcase1()
	{
		System.out.println("First");
	}
	@AfterTest
	public void aftertesttestcase2()
	{
		System.out.println("Last");
	}
	@AfterMethod
	public void AfterMethodTestcase1()
	{
		System.out.println("awwwwwwwwwwwww");
	}
	@BeforeMethod
	public void BeforeMethodTestcase2()
	{
		System.out.println("awwwwwwwwwwwww");
	}
}
