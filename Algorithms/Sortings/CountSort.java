package Algorithms.Sortings;
import java.io.*;
import java.util.*;

import Algorithms.utils.FastReader;
import Algorithms.utils.RandomInput;

public class CountSort {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        RandomInput ri=new RandomInput();
        int[] a=ri.intarray(20);

        // System.out.println(Arrays.toString(a));

        int max=Arrays.stream(a).max().getAsInt();
        int min=Arrays.stream(a).min().getAsInt();

        int[] count=new int[max+1];
        Arrays.stream(a).forEach(x->count[x]++);
        int[] sorted=new int[a.length];
        for(int i=1;i<count.length;i++)
            count[i]=count[i-1]+count[i]; // cumulative frequency array
        for(int i=a.length-1;i>=0;i--)
            sorted[count[a[i]]-- - 1]=a[i];

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sorted));


    }
}
