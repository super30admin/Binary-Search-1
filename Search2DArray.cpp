// Time Complaxity  = O(log(n)) approximatley, since using this solution we syill have to check each row's end value.
// Space Complaxity =  O(1) I am not using any additinal space here.
// Runtime: 3 ms, faster than 84.36% of C++ online submissions for Search a 2D Matrix.
// Memory Usage: 9.6 MB, less than 5.13% of C++ online submissions for Search a 2D Matrix.



class Solution {
public:
    bool binarySearch (vector <int> arr, int target){
        int low = 0, high = arr.size()-1;
        
        while (low <= high) {
            int mid = (low+high)/2;
            
            if (arr[mid] == target) return true;
            
            if (arr[mid] > target)
                high = mid -1;
            else
                low = mid + 1;
        }
        return false;
    }
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if(m == 0) return false;
        int n = matrix[0].size();
        if(n == 0) return false;
        
        int row = 0, col = n-1;
        while(col >= 0 && row < m){
            if(matrix[row][col] == target){
                return true;
            }else if(target < matrix[row][col]){
                //the current column's value is larger than target so target must be in this row only if it is present
                if (binarySearch(matrix[row], target))
                    return true;
                else 
                    return false;
            }else{
                //the current row's value are all smaller than target
                row++;
            }
        }
        
        return false;
        
    }
};