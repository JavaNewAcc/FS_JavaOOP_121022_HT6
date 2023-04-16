package classwork.one;

public class Main {

	public static void main(String[] args) {

		Thread thread = Thread.currentThread();

		System.out.println(thread.getName());
//		System.out.println(thread.getId());
//		try {
//			thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		Factorial task1 = new Factorial(10);
		Factorial task2 = new Factorial(10);
		Factorial task3 = new Factorial(10);

		Thread thread1 = new Thread(task1, "Task1");
		Thread thread2 = new Thread(task2, "Task2");
		Thread thread3 = new Thread(task3, "Task3");

		thread1.start();
		thread2.start();
		thread3.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		thread1.interrupt();
//		thread2.interrupt();
//		thread3.interrupt();

		System.out.println("Summ 1 is: " + task1.getFactorialSum());
		System.out.println("Summ 2 is: " + task2.getFactorialSum());
		System.out.println("Summ 3 is: " + task3.getFactorialSum());

		System.out.println(thread.getId());
	}
}
