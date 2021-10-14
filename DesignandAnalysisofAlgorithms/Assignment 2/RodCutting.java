import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class RodCutting{
	public static void main(String args[]) throws IOException{
		List<Long> input = new ArrayList<Long>();
		List<Long> price = new ArrayList<Long>();
		
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
						for(int j = pointer + 1; j <= pointer + input.get(pointer).intValue(); j++)
							price.add(input.get(j));
					value = rodCut(price, input.get(pointer).intValue());
					output = "" + value;
					
					//System.out.println(output);
					wr.write(output);
					wr.newLine();
					pointer = pointer + input.get(pointer).intValue() + 1;
					price.clear();
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

	public static long rodCut(List<Long> price, int n){
		long val[] = new long[n + 1];
		val[0] = 0;

		
		for (int i = 1; i <= n; i++){
			long maxVal = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++){
				maxVal = Math.max(maxVal, price.get(j) + val[i-j-1]);
			val[i] = maxVal;

			}
		}
		
		return val[n];
		
	}
}