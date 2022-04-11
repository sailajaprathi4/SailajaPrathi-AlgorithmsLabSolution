package com.gl.lab2.travellerproblem;

public class DataStructureUtils {

	public static void print(int[] array)
	{
		System.out.print("{ ");
		for (int index = 0; index < array.length; index ++) 
		{	
			System.out.print(array[index]);
			
			if (index != (array.length - 1))
			{
				System.out.print(", ");
			}
		}
		System.out.println(" }");
	}
	
}