class CustomException1 extends Exception {
    public CustomException1(String message) {
        super(message);
    }
}

class CustomException2 extends Exception {
    public CustomException2(String message) {
        super(message);
    }
}

class CustomException3 extends Exception {
    public CustomException3(String message) {
        super(message);
    }
}

class ExceptionHandlingExample {
    public static void throwCustomException(int value) throws CustomException1, CustomException2, CustomException3 {
        if (value == 1) {
            throw new CustomException1("Custom Exception 1 occurred.");
        } else if (value == 2) {
            throw new CustomException2("Custom Exception 2 occurred.");
        } else if (value == 3) {
            throw new CustomException3("Custom Exception 3 occurred.");
        }
    }

    public static void main(String[] args) {
        int value = 2;  // Value to determine which custom exception to throw

        try {
            throwCustomException(value);
        } catch (CustomException1 | CustomException2 | CustomException3 e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
