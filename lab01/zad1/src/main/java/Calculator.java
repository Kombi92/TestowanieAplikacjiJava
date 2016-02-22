/**
 * Created by Konrad on 15.02.2016.
 */
public class Calculator {

    public Calculator() {
        System.out.println("Calculator: " + this + '\n');
    }

    public int add(int n1, int  n2){

        return n1 + n2;
    }

    public int sub(int n1,int  n2){

        return n1 - n2;
    }

    public int multi(int n1,int  n2){

        return n1 * n2;
    }

    public int div(int n1,int  n2){

        return n1 / n2;
    }

    public boolean greater(int n1,int  n2){

        if(n1>n2)
            return true;
        else
            return false;
    }
}
