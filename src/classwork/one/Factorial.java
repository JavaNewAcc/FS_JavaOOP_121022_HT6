package classwork.one;

import java.math.BigInteger;

public class Factorial implements Runnable {

	private int number;
	private BigInteger factorialSum = BigInteger.ZERO;

	public Factorial(int number) {
		super();
		this.number = number;
	}

	public BigInteger getFactorialSum() {
		return factorialSum;
	}

	public BigInteger calculateFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i <= number; i++) {
			if (thread.isInterrupted()) {
				System.out.println(thread.getName() + " is interrupted");
				return;
			}
			BigInteger fact = calculateFactorial(i);
			System.out.println(thread.getName() + "  " + i + " !=" + fact);
			factorialSum = factorialSum.add(fact);
		}
	}
}