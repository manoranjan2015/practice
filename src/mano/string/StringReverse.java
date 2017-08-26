package mano.string;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringReverse 
{
	
	public static void main(String args[]) throws IOException 
	{
		InputStream inputStream = new BufferedInputStream(System.in);
		
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String str;
		while("exit" != ( str = reader.readLine())) 
		{
			System.out.println(str);
		}
	}

}
