#include <iostream>
using namespace std;

//regular binary search

int BinarySearch(int A[], int target, int low, int high){
    while (low <= high){
        int mid = low + (high - low)/2;
        if(target == A[mid]) return mid;  //found target, exit
        else if (target < A[mid]) high = mid -1;
        else
            low = mid + 1;
    }
    return -1;
}

//modified binary search

int newBinarySearch(int A[], int target){
    int low = 0;
    int high = 1;
    while(A[high] < target) {
        low = high;
        high = 2 * high;  //doubling the higher index
    }
    return BinarySearch(A, target, low, high);
}



int main() {

    int A[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}; 
    int ans = newBinarySearch(A, 10);
    if (ans==-1)
        cout << "Element not found";
    else
        cout << "Element found at index " << ans << endl;
    return 0;
}
