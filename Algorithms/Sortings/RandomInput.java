package Algorithms.Sortings;

import java.util.*;

public class RandomInput {

    Random rand;
    public RandomInput()
    {
        this.rand=new Random();
    }
    
    public int[] intarray(int n)
    {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=rand.nextInt(1,51);
        return a;
    }
    public int[] intarray(int n, int l, int r)
    {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=rand.nextInt(l,r+1);
        return a;
    }
    public String[] strarray(int n)
    {
        String[] srr=new String[n];
        for(int i=0;i<n;i++)
        {
            int size=rand.nextInt(1,11);
            StringBuilder s=new StringBuilder();
            for(int j=0;j<size;j++)
                s.append((char)rand.nextInt(97,123));
            srr[i]=s.toString();
        }
        return srr;
    }
}
