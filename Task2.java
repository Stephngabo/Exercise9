public class Task2 {
    public static void processValue(int value) {
        try {
            if (value == 0) {
                int result = 10 / value;  // Throws ArithmeticException
                System.out.println("Result: " + result);
            } else {
                int[] array = new int[5];
                int element = array[value];  // Throws ArrayIndexOutOfBoundsException
                System.out.println("Element: " + element);
            }
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    public static void main(String[] args) {
        int value1 = 0;
        int value2 = 7;
        int value3 = 10;

        processValue(value1);
        processValue(value2);
        processValue(value3);
    }
}
