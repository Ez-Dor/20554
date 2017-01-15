package Mmn14.Q1;


import java.util.Random;

/**
 * This class should check the priority queue bu integers.
 */

public class PriorityQueueTesterByInteger {

    public static void main(String arg[]) {

        Random random = new Random();
        final int MAX_PRIORITY = 10, MAX_ELEMENTS_FOR_QUEUE = 30, maxValue = 20;

        //choose random priority and size
        int priority = random.nextInt(MAX_PRIORITY) + 1; //priority should be between 1-10
        int queueSize = random.nextInt(MAX_ELEMENTS_FOR_QUEUE) + 10; //queue size will be between 10 - 40

        //init the priorityQueue with random values
        PriorityQueue priorityQueue = new PriorityQueue(priority);
        for (int i = 0; i < queueSize; i++) {
            priorityQueue.add(random.nextInt(maxValue), random.nextInt(priority));
        }

        //show the list
        System.out.println("List Size: " + priorityQueue.size());
        System.out.println("The List: " + priorityQueue);

        //poll from the list
        System.out.println("Poll from the list: " + priorityQueue.poll());
        System.out.println("Poll from the list: " + priorityQueue.poll());
        System.out.println("Poll from the list: " + priorityQueue.poll());

        //show the list
        System.out.println("List Size: " + priorityQueue.size());
        System.out.println("The List: " + priorityQueue);

        //check if random numbers is contain the list and try to remove them
        for (int i = 0; i < priority; i++) {
            int randomNumber = random.nextInt(maxValue);
            System.out.println("The list contains " + randomNumber + ": " + priorityQueue.contains(randomNumber));
            System.out.println("Remove number from the list success: " + priorityQueue.remove(randomNumber));
        }

        //show the list
        System.out.println("List Size: " + priorityQueue.size());
        System.out.println("The List: " + priorityQueue);


    }

}
