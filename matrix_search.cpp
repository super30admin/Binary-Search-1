// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty() || matrix.size() == 0){
            return false;
        }
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int row = mid/n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
};

int main(){
    class Solution s;
    vector<vector<int>> matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int value = 3;
    bool x = s.searchMatrix(matrix, value);
    std::cout << x << std::endl;
    return 0;
}
