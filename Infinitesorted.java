import java.util.Arrays;

// Time Complexity : O(logn)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : No
public class Infinitesorted {
	    int arr[];

	    public  Infinitesorted (int t[]) {
	        arr = Arrays.copyOf(t, t.length);
	    }

	    public int get(int index) {
	        if (index >= arr.length)
	            return Integer.MAX_VALUE;

	        return arr[index];
	    }

	    public int search(int target) {
	        int low = 0;
	        int high = 1;

	        while (get(high) < target) {
	            high = high * 2;
	        }

	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            int value = get(mid);

	            if (value == target) {
	                return mid;
	            }

	            if (value == Integer.MAX_VALUE) {
	                high = mid - 1;
	            } else if (value > target) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }

	        }

	        return -1;
	    }

	    public static void main(String[] args) {
	        int arr[] = new int[] { 1, 2, 3, 10, 20, 40, 50 };
	        Infinitesorted  prob = new  Infinitesorted (arr);

	        System.out.println(Arrays.toString(arr));

	        for (int element : new int[] { -20, 1, 40, 50, 200 }) {
	            int customBSIndex = prob.search(element);
	            int StandardBSIndex = Arrays.binarySearch(prob.arr, element);
	            boolean testCasePassed = (customBSIndex < 0 && StandardBSIndex < 0) || (StandardBSIndex == customBSIndex);
	            System.out.println("--------------------------");
	            System.out.println("Searching for element :\t" + element);
	            System.out.println("Element found at index :\t" + customBSIndex);
	            System.out.println("Test Passed :\t" + testCasePassed);
	            System.out.println("--------------------------");
	        }

	    }
	} 