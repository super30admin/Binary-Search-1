/******************************************************************************
Time Complexity - O(log (m * n))
*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	    Main m = new Main();
	    int arr[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 } };
        int target = 12;
        if(arr.length == 0) return;
	    int start = 0;
	    int rows = arr.length;
	    int columns = arr[0].length; 
	    int end =  (rows * columns) - 1;
	    
	    int result = m.FindinMatrix(arr, target, start, end, columns);
	    System.out.println(result);
	}
	
	private int FindinMatrix(int arr[][], int target, int start, int end, int columns)
	{
	    
	    while(start <= end)
	    {
	        int mid = start + (end - start) / 2;
	        int element = arr[mid / columns][mid % columns];
	        if(element == target) return mid;
	        if(element < target)
	        {
	           start = mid + 1 ;
	        }
	        else if(element > target)
	        {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
}
