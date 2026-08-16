import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample
{
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.submit(() -> {
			System.out.println("Task 1 running...");
		});

		executor.submit(() -> {
			System.out.println("Task 2 running...");
		});

		executor.submit(() -> {
			System.out.println("Task 3 running...");
		});
		executor.shutdown();
	}
}
