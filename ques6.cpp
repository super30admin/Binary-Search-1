#include <iostream>
using namespace std;

int binarysearch(int a[],int l,int h,int key)
{
    while(l<=h)
    {
        int mid=l+(h-l)/2;
        if(a[mid]==key)
        {
            return mid;
        }
        if(key>a[mid])
        {
            return binarysearch(a,mid+1,h,key);
        }
        return binarysearch(a,l,mid-1,key);
    }
    return -1;
}

int findpos(int a[],int key)
{
    int l=0,h=1;
    int val=a[h];
    while(val<key)
    {
        l=h;
        h=2*h;
        val=a[h];
    }
    return binarysearch(a,l,h,key);
}

int main() {
	int a[]={10,10,45,60,110,126};
	int pos=findpos(a,126);
	cout<<pos;
	return 0;
}