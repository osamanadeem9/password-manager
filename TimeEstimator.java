package sample;

import javafx.scene.text.Text;

import java.awt.*;

public class TimeEstimator {
    public double estimator_numeric(String password, int passlength){
        double combinations=0;
        char []pass = password.toCharArray();
        int[]intpass = new int[passlength];
        for (int i=0; i<passlength; i++){
            intpass[i] = (int)pass[i];
            if (intpass[i]>=48 && intpass[i]<=57){
                intpass[i]-=48;
            }
        }
        for (int i=0; i<passlength; i++){

            combinations += intpass[i]*(Math.pow(10, passlength-i-1));

        }
        return combinations;
    }
    public double estimator_alpha(String password, int passlength){
        double combinations=0;
        char []pass = password.toCharArray();
        int[]intpass = new int[passlength];
        for (int i=0; i<passlength; i++){
            intpass[i] = (int)pass[i];
            if (intpass[i]>=97 && intpass[i]<=122){
                intpass[i]-=97;
            }
        }
        for (int i=0; i<passlength; i++){

            combinations += intpass[i]*(Math.pow(26, passlength-i-1));

        }
        combinations+=1;
        return combinations;
    }
    public double estimator_alphaNumeric(String password, int passlength){
        double combinations=0;
        char []pass = password.toCharArray();
        int[]intpass = new int[passlength];
        for (int i=0; i<passlength; i++){
            intpass[i] = (int)pass[i];
            if (intpass[i]>=97 && intpass[i]<=122){
                intpass[i]-=97;
            }
            if (intpass[i]>=48 && intpass[i]<=57){
                intpass[i]-=22;
            }
        }
        for (int i=0; i<passlength; i++){

            combinations += intpass[i]*(Math.pow(36, passlength-i-1));

        }
        combinations+=1;
        return combinations;
    }
    public double estimator_alphaNumericAndSpecial(String password, int passlength){
        double combinations=0;
        char []pass = password.toCharArray();
        int[]intpass = new int[passlength];
        for (int i=0; i<passlength; i++){
            intpass[i] = (int)pass[i];
            if (intpass[i]>=97 && intpass[i]<=122){
                intpass[i]-=97;
            }
            if (intpass[i]>=48 && intpass[i]<=57){
                intpass[i]-=22;
            }
            if (intpass[i]== 46){
                intpass[i]-=10;
            }
            if (intpass[i]==38){
                intpass[i]-=1;
            }
            if (intpass[i]==64){
                intpass[i]-=26;
            }
        }
        for (int i=0; i<passlength; i++){
            combinations += intpass[i]*(Math.pow(39, passlength-i-1));
        }
        combinations+=1;
        return combinations;
    }


}
