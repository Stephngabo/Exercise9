package pl.vistula.multithreads;

public class Priority implements Runnable {
    int count;
    Thread thread;
    static volatile boolean stop = false;
    static String currentName;
    static volatile int fastestCount = 0; // Counter for the fastest high priority thread

    // Create a new thread
    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    // Start executing the thread
    public void run() {
        System.out.println(thread.getName() + " starts to operate");
        do {
            count++;
            if (!currentName.equals(thread.getName())) {
                currentName = thread.getName();
                System.out.println(currentName + " is executed");
            }
        } while (!stop && count < 10_000_000);

        stop = true;
        System.out.println("\n" + thread.getName() + " finishes running");

        if (thread.getPriority() == Thread.MAX_PRIORITY) {
            // If it's a high priority thread, increment the fastestCount
            synchronized (Priority.class) {
                fastestCount++;
            }
        }
    }
}

class PriorityDemo {
    public static void main(String[] args) {
        int fastestHighPriorityCount = 0; // Counter for the number of times the high priority thread finishes first

        for (int i = 0; i < 10; i++) {
            Priority mt1 = new Priority("High priority thread");
            Priority mt2 = new Priority("Thread with low priority");

            // Set thread priorities
            mt1.thread.setPriority(Thread.MAX_PRIORITY);
            mt2.thread.setPriority(Thread.MIN_PRIORITY);

            // Start the threads
            mt1.thread.start();
            mt2.thread.start();

            try {
                mt1.thread.join();
                mt2.thread.join();
            } catch (InterruptedException e) {
                System.out.println("The main thread is interrupted.");
            }

            System.out.println("\nHigh priority thread counted to " + mt1.count);
            System.out.println("Thread with low priority counted to " + mt2.count);

            if (mt1.count < mt2.count) {
                fastestHighPriorityCount++;
            }

            // Reset the stop and fastestCount for the next run
            Priority.stop = false;
            Priority.fastestCount = 0;
        }

        System.out.println("\nThe high priority thread was the fastest " + fastestHighPriorityCount + " out of 10 times.");
    }
}
