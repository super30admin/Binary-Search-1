//Search a Sorted Array of unknowm length

#include<iostream>
using namespace std;

int searchUnknown(int arr[], int t){
    int s=0, e=1;
    while(s<=e){
        if(arr[e]==t){
            return e;
        }
        else if(arr[e]<t){
            e*=2;
            s++;
        }
        else{
            while(s<e){
                int m=s+(e-s)/2;

                if(arr[m]==t){
                    return m;
                }
                else if(arr[m]>t){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
    }
    return -1;
}

int main(){
    int arr[]={2,4,6,7,10,12,15,18,19,26,28,29,32,37,40};
    int t;
    cout<<"Enter target value: ";
    cin>>t;

    cout<<searchUnknown(arr,t)<<endl;
    
    return 0;
}