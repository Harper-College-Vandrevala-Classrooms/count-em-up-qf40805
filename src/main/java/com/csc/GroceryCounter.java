package com.csc;

public class GroceryCounter {
    private int counter;
    private int maxCounter;

    // Constructor to initialize the counter with a starting value and a maximum value
    public GroceryCounter(int startingValue, int maxCounter) {
        if (startingValue < 0 || startingValue > maxCounter) {
            throw new IllegalArgumentException("Starting value must be between 0 and " + maxCounter);
        }
        this.counter = startingValue;
        this.maxCounter = maxCounter;
    }

    // Method to increment the counter
    public void increment() {
        counter = (counter + 1) % (maxCounter + 1);
    }

    // Method to decrement the counter
    public void decrement() {
        counter = (counter - 1 + (maxCounter + 1)) % (maxCounter + 1);
    }

    // Method to decrement the tens place
    public void decrementTens() {
        if (counter >= 10) {
            counter -= 10;
        } else {
            counter = 0; // Ensure the counter does not go below 0
        }
    }

    // Method to decrement the ones place
    public void decrementOnes() {
        if (counter > 0) {
            counter--;
        }
    }

    // Method to get the current counter value
    public int getCounter() {
        return counter;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Create an instance of GroceryCounter with initial value 0 and max value 99
        GroceryCounter groceryCounter = new GroceryCounter(0, 99);

        // Testing increment
        groceryCounter.increment();
        System.out.println("Counter after increment: " + groceryCounter.getCounter()); // Expected: 1

        // Testing decrement
        groceryCounter.decrement();
        System.out.println("Counter after decrement: " + groceryCounter.getCounter()); // Expected: 0

        // Testing decrementTens
        groceryCounter = new GroceryCounter(25, 99);
        groceryCounter.decrementTens();
        System.out.println("Counter after decrementing tens: " + groceryCounter.getCounter()); // Expected: 15

        // Testing decrementOnes
        groceryCounter.decrementOnes();
        System.out.println("Counter after decrementing ones: " + groceryCounter.getCounter()); // Expected: 14

        // Additional Tests
        groceryCounter.decrementTens(); // Reducing 15 by 10
        groceryCounter.decrementTens(); // Reducing 5 by 10 should be 0
        System.out.println("Counter after decrementing tens twice: " + groceryCounter.getCounter()); // Expected: 0

        groceryCounter.decrementOnes(); // Reducing 0 by 1 should stay 0
        groceryCounter.decrementOnes(); // Still should stay 0
        System.out.println("Counter after decrementing ones twice: " + groceryCounter.getCounter()); // Expected: 0
    }
}
