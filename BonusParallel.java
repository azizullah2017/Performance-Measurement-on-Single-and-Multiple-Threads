import java.util.Random;

public class BonusParallel {
	public static int account = 0;
	//declaration of matrix 
	
	public static int[][] A ;
	public static int[][] B ;
	public static int[][] C;
	
	
	public static void main(String[] args) {
	
		Random rand = new Random();

		for(int i=100;i<=500;i=i+100) //chnage the size of matrix on each loop iteration
		{
			//declaration of matrix size 
			 A = new int[i][i];
			 B = new int[i][i];
			 C= new int[i][i];
		
			//intizialzation of matrix A 
		for(int x=0;x<i;x++)
		{
		for(int y=0;y<i;y++)
		{
			//intizialzation of matrix A  with random numbers 
			A[x][y]=rand.nextInt(100);
		}
		}
		
		//intizialzation of matrix A 
		for(int m=0;m<i;m++)
		{
		for(int n=0;n<i;n++)
		{
			//intizialzation of matrix  B with random numbers 
			B[m][n]=rand.nextInt(100);
		}
		}
		
		//loop for creat thread, increase the number of threads on each iteration of specific size of matix
		for(int ThreadSize=10;ThreadSize<100;ThreadSize+=10) {
	     //intialize start time 
		int endPoint, intialPoint=0,factor=0; //varibales for division of matrix
		long start_time=0; long end_time=0; //variable to store time
		
	    if(i%ThreadSize==0) //check weather the matrix is divisible or not
	    {
	    	endPoint=i/ThreadSize; //unit of divisble of matrix intial matrix
	    	factor=endPoint; //unit of divisble of matrix
	    Thread t[] = new Thread[ThreadSize]; // of thread
	    start_time=  System.nanoTime()/1000;	//start time excution 
		for (int l = 0; l < ThreadSize; l++) {
			
		
		//intialization of thread, send arrayes to add with intial and end points
		t[l] = new Thread(new kThread(A, B,intialPoint, endPoint));
		t[l].start();
		
		//System.out.println(intialPoint+" "+endPoint);
		//take next portion of matrix by add factor to end because we have to divide this in eqaul parts
		intialPoint=endPoint;
		endPoint+=factor;
		
		}
		end_time=  System.nanoTime()/1000;
		intialPoint=0;
		endPoint=0;
	    }
		
		
		
		
		
		String size=Integer.toString(i);
		long excution_time= end_time - start_time;
		String time= Long.toString(excution_time);
		//print results
		 System.out.println("Size : "+size+" C : "+ThreadSize+"  Time :  "+time);
		
		}
		
		//System.out.printf("Account Balance: %d\n", account);
		
		}
		
		
		
	
	}
}

class kThread extends BonusParallel implements Runnable
{
	public int intialP;
	public int endP;
	
public kThread(int[][] a, int[][] b,int intialPoint, int endPoint) {
	intialP=intialPoint;
	endP=endPoint;
}	
public void run()
{//adding the arrays
	for(int x=intialP; x<endP; x++){
		for(int y=intialP; y<endP; y++){
			C[x][y]= A[x][y]+B[x][y];
		}
	}
//account++;
}
}