class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
    	// Time Complexity : m log n
    	// Space Complexity : m * n
    	// Did this code successfully run on Leetcode :
    	//the basic iterative one did but I could not pass a test case 
    	//which i am passing in my IDE but not in leet code.
    	// Any problem you faced while coding this :
/*
 * Not sure why i am getting false on this in leet code and not here in my main.
 * index out of bound issue most likely but not sure where.
 * 
 * 
Input:
[[1],[3]]
3
Output:
false
Expected:
true

*
*i get true for above test in my machine but not in leet code.
*you can run the code using the main() provided below here.
*/

    	// Your code here along with comments explaining your approach
       
       /*
        * 1. : Not Implemented: convert all first columns and last columns into 
        * 		one combined 1 D array then do binary search on it to find row where the
        * 			solution will most likely exist for m rows. to get O(log m) 
        * 		This part was getting messy so i will do it later. 
        * 		OVERALL expected time complexity O (log m) + O (log n)
        * 		in which case that largest log value for m or n will be taken
        * Implemented:
        * 2. : Create a Binary search function for n columns to get O(log n)
        * 3. : run a for loop over each row and call a binary search function on 
        * all elements in that row. 
        * 
        * 
        * */
    	for (int row = 0; row < matrix.length; row++  ) {
    		System.out.println(" the row " + row);
    		return binsearch(matrix[row], target );
    		
 /*below is an iterative search that checks all elements in 2d array 1 by 1
  * not efficient : O(m*n) but is accepted in leetcode and works.
  * comment return binsearch function call at top and uncomment section below to run this.
  * 
  * */ 
    		
 /*   		for (int col = 0; col < matrix[row].length; col++  ) {
    		turns++;
    		System.out.println(" the col " + col);
    		
    		if (matrix[row][col] > target) {	
    		System.out.println("turns taken" + turns);	
    		return false;
    		}

    		if (matrix[row][col] == target) {
    				return true;
    			}    			
    		}		
    */		

    	}
    	
    	return false;
    	
    }
    
//   TODO: this part will have implementation for row binary search 
    //using the 1d array made from first and last columns in 2d array.
    //to get O(log m)
//    public static boolean rowbinsearch(int[][] twoarray, int target) {
//    	
//    	
//    	for(int row = 0; row<twoarray.length; row++) {
//    		if (twoarray[row] == target) {
//    			
//    			return true;
//    		}
//    		
//    		
//    		else if(twoarray[row][lastcol] < tar ) {
//    			
//    		}
//    		
//    	}    	
//    	return false;  	
//    }
    
    

    public static boolean binsearch(int[] onearray, int target) {
    	int low = 0;
    	int high = onearray.length -1;
    	
    	for (int i = 0; i< onearray.length;i++) {
    		System.out.println(onearray[i]);
    	}
    	
    	while (low <= high) {
    	int mid = (low+high) /2;
    	if(onearray[mid] == target) {
    		//System.out.println("[mid] == target " + mid + " target:  " + target);
    		return true;    	   
    	}
    	else if(onearray[mid]> target) {
    	//	System.out.println("[mid]> target "+mid+ " target:  " + target) ;
    		high = mid - 1;
 
    	}
    	else if(onearray[mid] < target) {
    	//	System.out.println("[mid]< target "+mid+ " target:  " + target);
    		low = mid + 1; 
    	 
    	}
    	} 
    	return false;
    }
   

    public static void main(String[] args) {
    	

    	int[][] mat = {{1,3}};

   	for (int row = 0; row < mat.length; row++  ) {
   		for (int col = 0; col < mat[row].length; col++  ) {
   		 	System.out.print(mat[row][col] +"\t");
 		}
   		System.out.println();
    		
    	}
   	
   	boolean ans= searchMatrix(mat, 3 );
    	System.out.println(" The result is " +ans);
 
    }

 
}
