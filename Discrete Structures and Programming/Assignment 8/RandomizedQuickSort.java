import java.util.Random;

public class RandomizedQuickSort {
	private int comparisons = 0;;
	private boolean countComparisons;

    public void quickSort(int[] s, int left, int right, boolean cc) 
    {
		countComparisons = cc; //set counting boolean
		if(countComparisons)
				setComparisons(returnComparisons() + 1); 
        if (right - left <= 0){ //if starting and ending are the same number or ending is less than beginning
            return;
		}
        else 
        {
			 Random rand = new Random();
			int pivotSwap = left + rand.nextInt(right - left + 1); //randomized pivot
			swap(s, pivotSwap, right);
			
            int pivot = s[right];
            int q = partition(s, left, right, pivot); //partition the array
            quickSort(s, left, q - 1, countComparisons); //sort left
            quickSort(s, q + 1, right, countComparisons); //sort right

        }
    }
	public int returnComparisons(){ //get number of comparisons
		return comparisons;
	}
	public void setComparisons(int c){ //set new comparison number
		comparisons = c;
	}

    public int partition(int[] s, int left, int right, long pivot){
        int i = left - 1;
		int r = right;
		while(true){
			if(countComparisons)
				setComparisons(returnComparisons() + 1);
			while(s[++i] < pivot){ //move along the left
				if(countComparisons)
					setComparisons(returnComparisons() + 1);
			}
			while(r > 0 && s[--r] > pivot){ //move away from right
				if(countComparisons)
					setComparisons(returnComparisons() + 1);
			}
			if(i >= r) //if left is greater tha right, end
				break;
			else
				swap(s, i, r); //swap
		}
        swap(s, i, right); //swap
        return i;

    }
    public void swap(int[] s, int dex1, int dex2){ //swap method
        int temp = s[dex1];
        s[dex1] = s[dex2];
        s[dex2] = temp;
    }
	 public static void printSequence(int[] sorted_sequence) {
		for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }
	public static void main(String[] args){
		RandomizedQuickSort test = new RandomizedQuickSort();
		int size = 100;
		Random random = new Random();
		int[] sequence = new int[size];
		for (int i = 0; i < size; i++)
			sequence[i] = Math.abs(random.nextInt(100));
		printSequence(sequence);
		test.quickSort(sequence, 0, size - 1, false);
		System.out.println("");
		printSequence(sequence);
	}
}