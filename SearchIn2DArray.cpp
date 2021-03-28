#include <bits/stdc++.h>

using namespace std;

/* We are doing Binary search here.
 * Time Complexity   : O(log(n)) - Search space is divided by half every iteration
 * Space Complexity  : O(1)      - No extra space is being used 
 */
bool searchMatrix(vector<vector<int>>& matrix, int target)
{
    int rows = matrix.size(), cols = matrix[0].size();
    int low = 0, high = (rows * cols) - 1;
    int mid, row, col;
    while (low <= high) {
        mid = (low + (high - low) / 2);
        row = mid / cols;
        col = mid % cols;
    
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
        
    return false;
}

int main (int argc, char *argv[])
{
    vector<vector<int>> m =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    if (argc != 2) {
        cout << "USAGE: " << argv[0] << " <number>" << endl;
        return 0;
    }

    if (searchMatrix(m, atoi(argv[1]))) {
        cout <<argv[1] << " is present in the Matrix " << endl;
    } else {
        cout <<argv[1] << " is not present in the Matrix " << endl;
    }

    return 0;
}
