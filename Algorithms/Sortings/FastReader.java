package Algorithms.Sortings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public void FastReader()
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(null);
        this.br=br;
        this.st=st;
    }

    public String next()
    {
        while(st==null || !st.hasMoreTokens()){
            try{st=new StringTokenizer(br.readLine());}
            catch(IOException E){E.printStackTrace();}
        }
        return st.nextToken();
    }

    int nextInt() {return Integer.parseInt(next());}
    long nextLong() {return Long.parseLong(next());}
    float nextFloat() {return Float.parseFloat(next());}
    double nextDouble() {return Double.parseDouble(next());}

    String nextLine(){
        String s="";
        try{s=br.readLine().trim();}
        catch(IOException E){E.printStackTrace();}
        return s;
    }
    String[] readstringarray(int n){
        String[] res = new String[n];
        for(int i = 0; i<n; i++)res[i] = next();
        return res;
    }
    
    int [] readintarray(int n){
        int res [] = new int [n];
        for(int i=0;i<n;i++)res[i] = nextInt();
        return res;
    }
    
    long [] readlongarray(int n){
        long res [] = new long [n];
        for(int i=0;i<n;i++)res[i] = nextLong();
        return res;
    }
    
    float[] readfloatarray(int n){
        float res[] = new float[n];
        for(int i=0;i<n;i++)res[i] = (float)nextFloat();
        return res;
    }
    
    double[] readdoublearray(int n){
        double res[] = new double[n];
        for(int i=0;i<n;i++)res[i] = (double)nextDouble();
        return res;
    }
}
