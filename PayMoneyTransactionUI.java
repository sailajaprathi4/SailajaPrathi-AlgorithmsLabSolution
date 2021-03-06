package com.gl.lab2.paymoney;
import java.util.Scanner;
public class PayMoneyTransactionUI 
{
	private int[] transactions;
	private Scanner input;
	public PayMoneyTransactionUI()
	{
		input=new Scanner(System.in);
	}
	public void init()
	{
		gatherInputsAndProcess();
	}
	private void gatherInputsAndProcess()
	{
		
		System.out.println("Enter the size of the transaction array :");	
		int transactionArraySize=input.nextInt();	
		transactions = new int[transactionArraySize];
		
		System.out.println("Enter the values of array");	
		for (int index=0; index<transactionArraySize; index++) 
		{
			transactions[index]=input.nextInt();
			input.nextLine();
		}				
		System.out.print("Enter the total number of targets to be achieved:");
		int transactionsInstanceSize=input.nextInt();
		input.nextLine();
		for (int index=1; index<=transactionsInstanceSize; index++) 
		{
			System.out.println();
			System.out.print("Enter the target value :");
			int dailyTarget=input.nextInt();
			input.nextLine();
			System.out.println("Processing transaction with value"+dailyTarget);
			TargetAchievementCalculator calculator=new TargetAchievementCalculator(transactions, transactionsInstanceSize);
			calculator.calculate();
			calculator.printOutCome();
		}
		
	}
}
