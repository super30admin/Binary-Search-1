/******************************************************************************
Time Complecity - O(log N) + O(Log N) = O(log N)
1st O(Log N) - to find element is present in the range or not 
2nd O(Log N) - Binary Search
*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	    Main m = new Main();
	    int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                            100, 130, 140, 160, 170};
	    int target = 15;
	    int start = 0;
	    int end = 1;
	    while(arr[end] < target)
	    {
	        start = end;
	        end = 2 * end;
	    }
	    int result = m.SearchInSortedArrayInfiniteNos(arr, target, start, end);
	    System.out.println(result);
	}
	
	private int SearchInSortedArrayInfiniteNos(int arr[], int target, int start, int end)
	{
	    
	    while(start <= end)
	    {
	        int mid = start + (end - start) / 2;
	        if(arr[mid] == target) return mid;
	        if(arr[mid] < target)
	        {
	           start = mid + 1 ;
	        }
	        else if(arr[mid] > target)
	        {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
}
