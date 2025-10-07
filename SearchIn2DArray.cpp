#include <bits/stdc++.h>

using namespace std;

/* We are doing Binary search here.
 * Time Complexity   : O(log(m * n)) - Search space is divided by half every iteration
 * Space Complexity  : O(1)      - No extra space is being used 
 */
bool searchMatrix(vector<vector<int>>& matrix, int target)
{
    int rows = matrix.size();
    int cols = matrix[0].size();

    int low = 0, high = (rows * cols) - 1;
    int i, j;

    int mid = low + (high - low) / 2;
    while (low <= high) {
        i = mid / cols;
        j = mid % cols;
    
        if (matrix[i][j] == target) {
            return true;
        }

        if (matrix[i][j] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }

        mid = low + (high - low) / 2;
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
