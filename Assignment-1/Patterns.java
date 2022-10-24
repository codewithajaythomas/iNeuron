package com.fullstack.main;

public class Patterns {

	public static void main(String[] args) {
		ineuronPattern(7);
		//numberPattern(4);
		//housePattern(13);
		//bottomHalfPattern(13);
		//leftHalfPattern(13);
	}
	
	public static void ineuronPattern(int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<(7*n)+6;j++) {
				if((((i==0||i==(n-1))&&j<n)||j==(n-1)/2) || //I
					(j==(n+1)||(i+(n+1)==j)||j==(n*2))||  //N
					((j==(2*n+2))||(i==0 && j>(2*n+1)&&j<(3*n+2))||(i==(n-1)/2 && j>(2*n+1)&&j<(3*n+2))||(i==(n-1) && j>(2*n+1)&&j<(3*n+2)))|| //E
					(j==(3*n+3)||(i==(n-1)&&j>(3*n+2)&&j<(4*n+3))||j==(4*n)+2)|| //U
					(j==(4*n+4)||(i==0 && j>(4*n+3)&&j<(5*n+4))||(i==(n-1)/2 && j>(4*n+3)&&j<(5*n+4))||(j==(5*n+3)&&i<(n-1)/2)||(i+(4*n+4)==j && i>(n-1)/2))|| //R
					(((j==(5*n+5)||j==(6*n+4))&& i!=0 && i!=(n-1))||((i==0||i==(n-1))&&j>(5*n+5)&&j<(6*n+4)))|| //O
					(j==(6*n+6)||(i+(6*n+6)==j)||j==(7*n+5))) //N
					
					System.out.print("+");
				else
					System.out.print(" ");
			}
			
			System.out.println();
		}
	}
	
	public static void numberPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(i+1);
			}
			System.out.println();
		}
	}
	
	public static void housePattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==0||j==(n-1)||i==0||i==(n-1)||(i+j<=(n-1)/2)||(j-i>=(n-1)/2))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void bottomHalfPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==(n-1)||(i-j>=(n-1)/2 && i-j<=(n-1))||(i+j>=n+((n-2)/2)))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void leftHalfPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0||i==(n-1)||i+j<=(n-1)/2||(i-j>=(n-1)/2 && i-j<=(n-1)))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
