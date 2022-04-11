package com.gl.lab2.travellerproblem;
import java.util.Scanner;
public class TravellerCurrencySpendUI
{
	private int[] denominations;
	private Scanner input;
	public TravellerCurrencySpendUI()
	{
	input = new Scanner(System.in);
	}
	public void init()
	{
		gatherInputs();
	}
	
	private void gatherInputs()
	{
		System.out.println("Enter the size of the currency denominations");	
		int denominationsArraySize = input.nextInt();	
		denominations = new int[denominationsArraySize];
		System.out.println("Enter the currency denomination value");	
		for(int index=0;index<denominationsArraySize; index ++) 
		{
			denominations[index] = input.nextInt();
			input.nextLine();
		}		
		System.out.println("Enter the amount you want to pay");	
		int payAmount = input.nextInt();	
		CurrencyDenomination cd =new CurrencyDenomination(denominations, payAmount);
		cd.determine();

	}
}
