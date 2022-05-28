/******************************************************************************

Time Complexity - O(log N)

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	    Main m = new Main();
	    int arr[] ={5, 6, 7, 8, 9, 10, 1, 2, 3};
	    int target = 10;
	    int result = m.RotatedBinarySearch(arr, target);
	    System.out.println(result);
	}
	
	private int RotatedBinarySearch(int arr[], int target)
	{
	    int start = 0 ;
	    int end = arr.length -1;
	    while(start <= end)
	    {
	        int mid = start + (end - start) / 2;
	        if (arr[mid] == target) return mid;
	        if(arr[start] <= arr[mid])
	        {
	            //left side is sorted
	            if(target >= arr[start] && target < arr[mid])
	            {
	                end = mid -1;
	            }
	            else
	            {
	                start = mid + 1;
	            }
	        }
	        else
	        {
	            if(target <= arr[end] && arr[mid] < target)
	            {
	                start = mid + 1;
	            }
	            else
	            {
	                end = mid - 1;
	            }
	            
	        }
	    }
	    return -1;
	}
}
