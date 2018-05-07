
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Calendar;

import java.util.Random;


public class Squential {

	public static void main(String[] args) {
		
		Random rand = new Random();

		for(int i=100;i<=500;i=i+100)
		{
		int[][] A = new int[i][i];
		int[][] B = new int[i][i];
		int[][] C= new int[i][i];
		
		
		for(int x=0;x<i;x++)
		{
		for(int y=0;y<i;y++)
		{
			A[x][y]=rand.nextInt(100);
		}
		}
		
		for(int m=0;m<i;m++)
		{
		for(int n=0;n<i;n++)
		{
			B[m][n]=rand.nextInt(100);
		}
		}
		
	
		long start_time=  System.nanoTime()/1000;
		for(int x=0; x<i; x++){
			for(int y=0; y<i; y++){
				C[x][y]= A[x][y]+B[x][y];
			}
		}
		long end_time=  System.nanoTime()/1000;
		
		String size=Integer.toString(i);
		long excution_time= end_time - start_time;
		String time= Long.toString(excution_time);
		
		
		 System.out.println("Size : "+size+"  Time :  "+time);
		
		}
		
		
       
	}

	

}
