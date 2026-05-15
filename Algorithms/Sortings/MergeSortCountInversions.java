package Algorithms.Sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Algorithms.utils.RandomInput;

public class MergeSortCountInversions {
    static int count=0;
    public static void main(String[] args) {
        count=0;
        RandomInput ri=new RandomInput();
        int[] a=ri.intarray(5);
        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));

        // Inversions a[i]>a[j] && i<j
        System.out.println(count);
    }

    public static void mergeSort(int[] a, int l, int r)
    {
        if(l>=r) // use this instead of l==r to cover empty array edge case (a,0,-1)
            return;
        int mid=(l+r)/2;
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, r);
        merge(a, l, mid, r);
    }

    public static void merge(int[] a, int l, int mid, int r)
    {
        List<Integer> temp=new ArrayList<>();
        int i=l, j=mid+1;
        while(i<=mid && j<=r)
        {
            if(a[i]<=a[j])
                temp.add(a[i++]);
            else
            {
                temp.add(a[j++]);
                count+=mid-i+1; // count inversions
            }
        }

        while(i<=mid)
            temp.add(a[i++]);
        while(j<=r)
            temp.add(a[j++]);
        for(int x=l;x<=r;x++)
            a[x]=temp.get(x-l);
    }
}
