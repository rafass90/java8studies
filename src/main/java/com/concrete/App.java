package com.concrete;


public class App 
{
	public static void main(String[] args)
	{
		int[] a ={1,2,3,4,5,6,7,9};

		System.out.println(exist(a, 2));


	}

	public static String exist(int[] arr, int k){
		for(int a = 0; a < arr.length; a++){
			if(k == arr[a])
				return "SIM";
		}
		return "NÃO";
	}
}
