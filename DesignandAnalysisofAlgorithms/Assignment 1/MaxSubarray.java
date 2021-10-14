import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class MaxSubarray{
	public static void main(String args[]) throws IOException{
		List<Long> input = new ArrayList<Long>();
		
		if(args.length > 0) {
			File file = new File(args[0]);
			try{
				Scanner scanner = new Scanner(file);
			
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					input.add(Long.parseLong(line));
				}
				int repeat = input.get(0).intValue(); //# repeats
				int pointer = 1;
				long value;
				String output;
				FileWriter writer = new FileWriter(args[1]);
				BufferedWriter wr = new BufferedWriter(writer);
				for(int i = 0; i < repeat; i++){
					value = maxSA(input, pointer + 1, pointer + input.get(pointer).intValue());
					output = "" + value;
					
					//System.out.println(output);
					wr.write(output);
					wr.newLine();
					pointer = pointer + input.get(pointer).intValue() + 1;
				}
				
				wr.flush();
				wr.close();
				
			}
			catch (FileNotFoundException e){
				System.out.println("File Not Found");
			}
			
		}
		//for(int init: input)
		//	System.out.println(init);
	}
	public static long max3(long a, long b, long c){
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
	public static long maxSA(List<Long> input, int left, int right){
		long sum = 0;
		long leftSum = Long.MIN_VALUE;
		long rightSum = Long.MIN_VALUE;
		
		if(left == right)
			return input.get(left);
		
		int mid = (left + right) / 2;
		long maxLeftSum = maxSA(input, left, mid);
		long maxRightSum = maxSA(input, mid + 1, right);
		
		for(int i = mid; i >= left; i--){
			sum += input.get(i);
			if(sum > leftSum){
				leftSum = sum;
			}
		}
		sum = 0;
		
		for(int i = mid + 1; i <= right; i++){
			sum += input.get(i);
			if (sum > rightSum){
				rightSum = sum;
			}
		}
		return max3(maxLeftSum, maxRightSum, (leftSum + rightSum));
		
		
	}
}