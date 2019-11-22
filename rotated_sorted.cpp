#include <iostream>
using namespace std;

int search(int A[], int target, int low, int high){

    //if (low > high) return -1;

    while(low <= high){
        int mid = low + (high - low)/2;
        if(target == A[mid]) return mid;   //target  = mid , exit
        else if(A[low] <= A[mid]){         // left side is sorted
            if(A[low] <= target && A[mid] >= target){
            high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        else{
            if(A[mid] <= target && A[high] >= target){  //right side is sorted
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    }
    return -1;
}


int main() {
    int A[] = {100, 130, 140, 160, 170, 3, 5, 7, 9, 10, 90};
    int target = 10;
    int n = sizeof(A) / sizeof(A[0]);  //size of the array
    int i = search(A, target, 0, n-1 );

    if( i != -1)
    cout << "Index = " <<i <<endl;
    else
    cout << "target not found" << endl;

}
