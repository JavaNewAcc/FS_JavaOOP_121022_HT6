package hometask.one;

public class Main {

	public static void main(String[] args) {
		Thread[] factorialArr = new Thread[100];
		for (int i = 0; i < factorialArr.length; i++) {
			FactorialCalculator factCalculator = new FactorialCalculator(i);
			Thread thread = new Thread(factCalculator);
			factorialArr[i] = thread;
			thread.start();
		}
	}
}