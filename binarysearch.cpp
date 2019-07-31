#include<iostream>
using namespace std;

class BinarySearch
{
public:
    int binarySearch(int arr[],int left,int right,int targ)
    {

        int mid = left + (right - left) / 2;

        if (targ == arr[mid]) {
            cout << "Found";
            return 0;
        } else if (targ < arr[mid]) {
            binarySearch(arr, left, mid, targ);
        }
        else if (targ > arr[mid])
        {
            binarySearch(arr, mid + 1, right, targ);
        }
        else
            cout<<"Not found";
        return -1;
    }

};
int main()
{
    BinarySearch bs1;
    int arr[]={4,5,6,7,0,1,2};

    int target =1;
    int size= sizeof(arr)/ sizeof(arr[0]);
    bs1.binarySearch(arr,0,size-1,target);

    return 0;
}