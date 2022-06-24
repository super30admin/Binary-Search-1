//Time Complexity : O(log n) as we are performing binary search
//Space Complexity : O(n*m)  or O(n)+O(m) where n is size of no.of rows and m is size of no. of cols. 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*Step 1: Create a 2D array which will be sorted
 * Step 2: We will assume it to be a single array. We will then find the low, high and mid of this assumed single array. Then we will compare whether the target is same as low, high or mid?
 * Step 3: If not then, we will comapre if the target is less than mid? if so, then high will become mid-1, focusing on just left part of array to find the target. 
 * Step 4: if the target is greater than mid? then low will become mid+1, focusing on just right part of array to find the target
 * Step 5: If target is not found then the method will return false
 */


import java.util.Scanner;

public class _2Dmatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low=0;
        int high= (m*n)-1;
        
        while(low <= high)
        {
            int mid= low + ((high-low)/2);  // to prevent integer overflow
            int row= mid/n;
            int col= mid % n;
            
            if(matrix[row][col] == target)
            {
                return true;
            }else if(target > matrix[row][col])
            {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[][] num = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int mm = num.length;
        int nn = num[0].length;
		for(int i=0; i<mm;i++)
		{
			for(int j=0; j<nn; j++)
			{
				System.out.println(num[i][j]);
			}
			System.out.println(num[i]);
		}
		System.out.println("From above array please type the target you want to search");
		Scanner sc= new Scanner(System.in); 
		int targt =sc.nextInt();
		boolean result= searchMatrix(num, targt);
		if(result == false) {
			System.out.println("Target is not present in Array");
		}else {
			System.out.println("Target is present in Array");
		}
	}

}
