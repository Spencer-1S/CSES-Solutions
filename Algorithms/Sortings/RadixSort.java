package Algorithms.Sortings;

import java.lang.reflect.Array;
import java.util.Arrays;

import Algorithms.utils.RandomInput;

public class RadixSort {
    
    public int[] countSort(int[] a, int exp)
    {
        int max=Arrays.stream(a).max().getAsInt();
        int min=Arrays.stream(a).min().getAsInt();

        int[] count=new int[10];
        Arrays.stream(a).forEach(x->count[x/exp % 10]++);
        
        for(int i=1;i<count.length;i++)
            count[i]=count[i-1]+count[i];
        
        int[] sorted=new int[a.length];
        for(int i=a.length-1;i>=0;i--)
            sorted[count[a[i]/exp % 10]-- - 1]=a[i];
        return sorted;
    }
    
    public static void main(String[] args) {
        RadixSort rs=new RadixSort();
        RandomInput ri=new RandomInput();

        int[] a=ri.intarray(20, 1, 701);
        
        int max=Arrays.stream(a).max().getAsInt();
        int maxdigits=(int)Math.log10(max)+1;

        System.out.println(Arrays.toString(a));

        // if base of number systme is x then maxdigits = floor(log_x(max))+1
        int exp=1;
        for(int i=1;i<=maxdigits;i++)
        {
            a=rs.countSort(a, exp);
            exp*=10;
        }

        System.out.println(Arrays.toString(a));
        
    }
}
