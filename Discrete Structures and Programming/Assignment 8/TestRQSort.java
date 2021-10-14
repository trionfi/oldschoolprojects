import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class TestRQSort{
	private static RandomizedQuickSort test = new RandomizedQuickSort();
		public static long evaluateRQSort(int size, int trials){
			long allComparisons = 0;
			for(int j = 0; j < trials; j++){
				Random random = new Random();
				int[] sequence = new int[size];

				for (int i = 0; i < size; i++)
					sequence[i] = Math.abs(random.nextInt(100));
				test.quickSort(sequence, 0, size - 1, true);
				allComparisons = allComparisons + test.returnComparisons();
				test.setComparisons(0);
			}
			//System.out.println(allComparisons);
			return (allComparisons / trials);
		}
		public static void overallEvaluate(int startSize, int finishSize, int sizeIncrement, int numTrials) throws IOException{
			File file = new File("comparisonplot.csv");
			
			file.createNewFile();
			
			FileWriter writer = new FileWriter(file);
			writer.write("Array Size,Average No. of Comparisons\n");
			for(int i = startSize; i <= finishSize;){
				String string = i + "," + evaluateRQSort(i, numTrials) + "\n";
				System.out.print(string);
				writer.write(string);
				i = i + sizeIncrement;
			}
			writer.close();
		}
		public static void main(String[] args) throws IOException{
			overallEvaluate(10000, 1000000, 10000, 1000);
		}
}