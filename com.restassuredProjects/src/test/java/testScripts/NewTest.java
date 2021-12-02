package testScripts;

import java.util.Random;
import java.util.Scanner;

public class NewTest {

	public static void main(String[] args) {
		int count=0;
		String name1="";
		Scanner s=new Scanner(System.in);
		System.out.println("Your Name:");
		name1=s.nextLine();
		String name=name1.toLowerCase();
		
		for( int i=0;i<name.length();i++)
		{
			
			if(name.charAt(i)=='a' || name.charAt(i)=='e'||name.charAt(i)=='i'||name.charAt(i)=='o'||name.charAt(i)=='u')
			{
				count++;
			}
			
		}
		System.out.println(count);
	}

}
