public class Task1 {
    public static void generateNullPointerException() {
        String[] array = null;
        int length = array.length;  // This line will cause a NullPointerException
    }

    public static void main(String[] args) {
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("A NullPointerException occurred!");
            System.out.println("Exception message: " + e.toString());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
    }
}
