package hometask.two;

public class Main {

	public static void main(String[] args) {
		int[] randomArr = new int[100000000];
		int sumPartially = 0;
		int sumTotal = 0;

		for (int i = 0; i < randomArr.length; i++) {
			randomArr[i] = (int) (Math.random() * 100);
		}

		SumCalculator sc1 = new SumCalculator(randomArr, 0, 24999999);
		SumCalculator sc2 = new SumCalculator(randomArr, 25000000, 49999999);
		SumCalculator sc3 = new SumCalculator(randomArr, 50000000, 74999999);
		SumCalculator sc4 = new SumCalculator(randomArr, 75000000, 99999999);

		Thread thread1 = new Thread(sc1);
		Thread thread2 = new Thread(sc2);
		Thread thread3 = new Thread(sc3);
		Thread thread4 = new Thread(sc4);

		long startTime1 = System.nanoTime();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sumPartially = sc1.getSum() + sc2.getSum() + sc3.getSum() + sc4.getSum();
		System.out.println("Сума елементів (розрахунок по частинам): " + sumPartially);
		long endTime1 = System.nanoTime();
		System.out.println("Час виконання (розрахунок по частинам): " + (endTime1 - startTime1));

		long startTime2 = System.nanoTime();
		for (int i = 0; i < randomArr.length; i++) {
			sumTotal += randomArr[i];
		}
		System.out.println("Сума елементів (повний масив послідовно): " + sumTotal);
		long endTime2 = System.nanoTime();
		System.out.println("Час виконання (повний масив послідовно): " + (endTime2 - startTime2));
	}
}