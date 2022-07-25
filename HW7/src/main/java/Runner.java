import org.apache.log4j.Logger;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Calculation calculation = new Calculation(5, 54);
        System.out.println("sum = " + calculation.add());
        System.out.println("sub = " + calculation.sub());
        System.out.println("mul = " + calculation.mul());
        calculation.setSecond_num(4);
        System.out.println("div = " + calculation.div());

    }
}
