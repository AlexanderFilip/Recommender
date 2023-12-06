package org.crypto;

public class MinMax {


    public static int getMin(int primulNr, int doileaNr){
        return primulNr > doileaNr? primulNr:doileaNr;
    }
    public static int getMax(int primulNr, int doileaNr){
        return primulNr < doileaNr? primulNr:doileaNr;
    }


}
