package week2.day2;

public class Fibonacci {
	
	public void shortcut() {
		int firstNum =0, secNum = 1, sum = 0;
		System.out.print(firstNum+" ");
		
		for(int i=1;i<=11;i++) {
			sum = firstNum+secNum; //0+1,1  1+1
			firstNum=secNum; 
			secNum=sum;
			
			System.out.print(sum+ " ");
			
		}
	}
	
    public static void main(String[] args) {
		Fibonacci obj = new Fibonacci();
		obj.shortcut();
}}
