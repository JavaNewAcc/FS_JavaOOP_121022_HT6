package hometask.two;

public class SumCalculator implements Runnable {

	private int startIndex;
	private int endIndex;
	private int[] array;
	private int sum = 0;

	public int getSum() {
		return sum;
	}

	public SumCalculator(int[] array, int startIndex, int endIndex) {
		super();
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	private int sumCalc(int[] array, int startIndex, int endIndex) throws ArrayIndexOutOfBoundsException {
		if (endIndex >= (array.length)) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			for (int i = startIndex; i <= endIndex; i++) {
				sum += array[i];
			}
		}
		return sum;
		
	}

	@Override
	public void run() {
		sumCalc(array, startIndex, endIndex);
	}

}
