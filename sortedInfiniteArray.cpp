#include<iostream>
using namespace std;



void find(int arr[], int key)
{
    int n=0;
    int left = 0, right = 2^n;
    int val = arr[0];


    while (val < key)       //check if value is in array is less than key. only then increase the range of the array.
    {
        n++;
        left = right;        // store previous right value
        right = 2^n;      // exponential increase of right.
        val = arr[right]; // update new val
    }


     binarySearch(arr,left, right, key);
}


void binarySearch(int arr[], int left, int right, int x)    //Binary search implemented.
{
    if (right>=left) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == x) {
            cout << "Found at index " << mid;
            return;
        }
        if (arr[mid] > x)
            binarySearch(arr, left, mid - 1, x);
        else {
            binarySearch(arr, mid + 1, right, x);
        }

    }

    cout<<"Not Found";
}



int main()
{
    int arr[] = {4,6,8,12,15,90,120,141,999};

     find(arr, 12);

    return 0;
}