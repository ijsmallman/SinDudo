package com.SmallJoeMan.sindudo;

public class DiceProbabilities {

	static long binomial(int n, int k) {
		long coeff = 1;
		for (int i = n - k + 1; i <= n; i++) {
			coeff *= i;
		}
		for (int i = 1; i <= k; i++) {
			coeff /= i;
		}
		return coeff;
	}
	
	public static double prob(int n, int q)
	{
		return Math.pow(1.0/6.0,q)*Math.pow(5.0/6.0,n-q)*binomial(n,q);
	}
	
	public static double diceProb(int n, int k)
	{
		double p = 0.0;
		for (int i=k; i<(n+1); i++)
		{
			p += prob(n,i);	
		}
		return p;
	}
}
