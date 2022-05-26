//Time Complexity- O(logn)
//Space Complexity- O(1)

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int n=matrix.size();
        int m=matrix[0].size();
        
        int low=0;
        int high=(n*m)-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[mid/m][mid%m]==target){   //Compare the target with the current element.
                return true;
            }
            if(matrix[mid/m][mid%m]<target){    //If the target is greater, update low
                low=mid+1;
            }
            else{                               //If the target is greater, update high
                high=mid-1;
            }
        }
        return false;
    }
};