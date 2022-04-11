package com.gl.lab2.travellerproblem;
import java.util.Arrays;
public class CurrencyDenomination 
{
	private int[] denominations;
	private int payAmount;
	private int[] resultDenomoinationArray;
	private int[] resultDenominationCountArray;
	
	public CurrencyDenomination(int[] denominations,int payAmount)
	{
		this.denominations=denominations;
		this.payAmount=payAmount;
		this.resultDenomoinationArray=new int[this.denominations.length];
		this.resultDenominationCountArray=new int[this.denominations.length];
		
	}
public void determine()
{
		sort();
		int index = 0;
		int resultIndex = 0;
		int balancedOutPayAmount = payAmount;
			while (index < denominations.length)
			{
				int denomination = denominations[index];
				int quotient = balancedOutPayAmount / denomination;
				int remainder = balancedOutPayAmount % denomination;
			if (quotient !=0) 
			{
				int temp = denomination * quotient;				
				balancedOutPayAmount = balancedOutPayAmount - (temp);
				resultDenomoinationArray[resultIndex] = denomination;
				resultDenominationCountArray[resultIndex] = quotient;		
				resultIndex ++;
				if (remainder != 0) 
				{
				}
				else if (remainder == 0)
				{
						if (balancedOutPayAmount == 0) 
						{
						printSuccessMessage(resultIndex);
						break;
					}
				}
				
			}
			else if (quotient == 0)
			{
					if (remainder != 0)
					{
					if (!isLastDenomination(index))
					{
					}
					else
					{
						printErrorMessage();
						break;						
					}
				}
				else if (remainder == 0) 
				{
				break;
				}
			}						
			index ++;
		}
			}
		private void sort()
	{
		BubbleSort bubbleSort = new BubbleSort(denominations);		
		bubbleSort.sortDesc();
	}
		private boolean isLastDenomination(int index)
	{
		if (index == denominations.length - 1) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		private void printErrorMessage() 
		{
		
		System.out.println("For the denomination values "  +", it is not possible to give for the payment amount ["+ payAmount + "]");
	}
		private void printSuccessMessage(int resultIndex) 
		{
		resultDenomoinationArray = Arrays.copyOf(resultDenomoinationArray, resultIndex);
		resultDenominationCountArray = Arrays.copyOf(resultDenominationCountArray, resultIndex);
		
		System.out.println("your payment approach in order to give min no of notes will be");
		for (int index = 0; index < resultDenominationCountArray.length; index ++) 
		{
			int denomination = resultDenomoinationArray[index];
			int denominationCount = resultDenominationCountArray[index];
			System.out.println( + denomination + ":" + denominationCount );
		}		
	}
	public static void main(String[] args)
	{
		test(new int[]{10,5,1}, 12);
		test(new int[]{78, 60, 25, 12, 5}, 128);
		test(new int[]{123, 18, 12, 5}, 158);
		test(new int[] {15}, 10);
		test(new int[] {25, 15}, 10);
		
	}
		private static void test(int[] denominations, int payAmount)
		{
		CurrencyDenomination cd = new CurrencyDenomination(denominations, payAmount) ; 
		cd.determine();
	}
}
