//When it is indicated to perform the efficient approach of searching, we can use binary search while searching from the array if it is sorted. There can be multiple approaches to solve this problem using binary search, I use the approach which uses the methodology to convert it into 1d and then perform the search operation. 

//There can be two ways of calculating the mid = low + (high-low)/2, or low+high/2

//Time Complexity:O(m*n) + O(logn)
//Space Complexity: O(m*n)
//Does this code run on Leetcode: Yes
//Any difficulties faced during this execution : No in brute force approach. 

//The first approach is an approach which saves the 2d matrix in a list and then performs binary search. It can be considered as a brute force approach. 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length; 
        int low = 0;
        int high = m * n - 1;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        for (int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                nums.add(matrix[i][j]);
    
        boolean ans = binarySearch(nums, low, high, target);
        
        if (ans == true)
            return true;
        else
            return false;
    }
    
    public boolean binarySearch(ArrayList<Integer> nums, int low, int high, int target)
    {

        while (low <= high) {
            int mid = low + (high - low) / 2;
 
            // Check if x is present at mid
            if (nums.get(mid) == target)
                return true;
 
            // If x greater, ignore left half
            if (nums.get(mid) < target)
                low = mid + 1;
 
            // If x is smaller, ignore right half
            else
                high = mid - 1;
        }
    return false;
    }
}

//The second apporach is an approach which further reduces the time and space complexity by following certain math principles. 

//Time Complexity:O(logm) + O(logn)
//Space Complexity: No extra space required. 
//Does this code run on Leetcode: Yes
//Any difficulties faced during this execution : No in brute force approach. 
    
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length; 
        int low = 0;
        int high = m * n - 1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            int row = mid/n;
            int col = mid % n; 
            
            if(matrix[row][col] == target)
                return true;
        
            if(matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid-1;
        }
        
    return false;
    }
}
