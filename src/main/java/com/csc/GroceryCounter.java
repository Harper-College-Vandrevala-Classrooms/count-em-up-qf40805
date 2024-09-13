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
        int tens = (counter / 10) % 10;
        if (tens > 0) {
            counter -= 10;
        } else {
            counter = Math.max(0, counter - 10);
        }
    }

    // Method to decrement the ones place
    public void decrementOnes() {
        if (counter > 0) {
            counter--;
        } else {
            counter = 0;
        }
    }

    // Method to decrement the tenths place (if applicable)
    public void decrementTenths() {
        // Assuming tenths place is not applicable for a 4-digit counter
        // This method can be implemented if needed for a different context
    }

    // Method to decrement the hundredths place (if applicable)
    public void decrementHundreths() {
        // Assuming hundredths place is not applicable for a 4-digit counter
        // This method can be implemented if needed for a different context
    }

    // Method to get the current counter value
    public int getCounter() {
        return counter;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        GroceryCounter groceryCounter = new GroceryCounter(0, 99);
        groceryCounter.increment();
        System.out.println("Counter after increment: " + groceryCounter.getCounter());
        groceryCounter.decrement();
        System.out.println("Counter after decrement: " + groceryCounter.getCounter());
        groceryCounter.decrementTens();
        System.out.println("Counter after decrementing tens: " + groceryCounter.getCounter());
        groceryCounter.decrementOnes();
        System.out.println("Counter after decrementing ones: " + groceryCounter.getCounter());
    }
}
