package src.src.com.epam.ihor_novikov.java.lecture_3.task_1;

public class OperationsWithArray {
    public static void main(String[] args) {
        OperationsWithArray operationsWithArray = new OperationsWithArray();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 20) - 10);
            System.out.println(array[i]);
        }
        System.out.println("sum of elements placed on even positions is " + operationsWithArray.sumOfEvenPositionElement(array));

    }

    public int sumOfEvenPositionElement(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

}
