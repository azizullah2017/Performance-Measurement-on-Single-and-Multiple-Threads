import java.util.Random;

public class threadInParallel {
	public static int[][] A ;
	public static int[][] B ;
	public static int[][] C;
	
	
	public static void main(String[] args) {
		Random rand = new Random();

		for(int i=500;i<=500;i=i+100)
		{
		 A = new int[i][i];
		 B = new int[i][i];
		 C= new int[i][i];
		
		
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
		

		
		Thread t1 = new Thread(new threadOne());
		Thread t2 = new Thread(new threadTwo());
		long start_time=  System.nanoTime()/1000;
		t1.start();
		long end_time=  System.nanoTime()/1000;
		
		String size=Integer.toString(i);
		long excution_time= end_time - start_time;
		String time= Long.toString(excution_time);
		
		System.out.println("Size : "+size+"  Time :  "+time);
		
		start_time=  System.nanoTime()/1000;
		t2.start();
		end_time=  System.nanoTime()/1000;
		
		size=Integer.toString(i);
		 excution_time= end_time - start_time;
	    time= Long.toString(excution_time);
		
		System.out.println("Size : "+size+"  Time :  "+time);
		}
		
		
		
		
		
	}
				
}



class threadOne extends threadInParallel implements Runnable
{
public void run() {
	for(int x=250; x<500; x++){
		for(int y=0; y<250; y++){
			C[x][y]= A[x][y]+B[x][y];
		}
	}
}
}
class threadTwo extends threadInParallel implements Runnable
{
public void run() {

	for(int x=0; x<250; x++){
		for(int y=0; y<250; y++){
			C[x][y]= A[x][y]+B[x][y];
		}
	}
	
	
}
}
