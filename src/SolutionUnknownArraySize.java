import java.io.*;

public class SolutionUnknownArraySize {
	public int search(ArrayReader reader, int target) {

		int low = 0;
		int high = 1;
		while (reader.get(high) < target) {
			low = high;
			high = high * 2;
			
		}

		return searchTarget(reader,low, high,target);

	}

	private int searchTarget(ArrayReader reader,int low, int high,int target) {
		// TODO Auto-generated method stub
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(reader.get(mid) == target) {
				return mid;                                    
			}else if(reader.get(mid) > target) {
				high = mid -1;
			}else
				low = mid +1;
		}
		
		return -1;

	}
}
