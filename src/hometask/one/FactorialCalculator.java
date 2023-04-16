package hometask.one;

import java.math.BigInteger;

public class FactorialCalculator implements Runnable {

	private int number = 0;
	private BigInteger factorial;

	public FactorialCalculator(int number) {
		super();
		this.number = number;
	}

	public BigInteger getFactorial() {
		return factorial;
	}

	public BigInteger calculateFactorial(int number) {
		if (number == 0) {
			factorial = BigInteger.ZERO;
		} else {
			factorial = BigInteger.ONE;
		}
		for (int i = 1; i <= number; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	@Override
	public void run() {
		System.out.println("Потік " + number + ", факторіал = " + calculateFactorial(number));
	}
}
