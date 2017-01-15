package Mmn14.Q1;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * This class represent a queue with priority according to the Maman14 requirements
 */

public class PriorityQueue {

    private LinkedList[] _priorityQueue;

    final int MIN_PRIORITY = 1, MAX_PRIORITY = 10;

    public PriorityQueue(int priority) {

        if (priority < MIN_PRIORITY || priority > MAX_PRIORITY) {
            priority = MAX_PRIORITY;
        }

        _priorityQueue = new LinkedList[priority];

        for (int i = 0; i < priority; i++) {
            _priorityQueue[i] = new LinkedList();
        }
    }

    /**
     * This Function add value to the queue according to the priority.
     *
     * @param value
     * @param priority
     */
    public void add(Object value, int priority) {
        if (priority < MIN_PRIORITY - 1 || priority >= getPriority()) {
            priority = getPriority() - 1;
        }
        _priorityQueue[priority].addLast(value);
    }

    /**
     * Poll out the most priority value in the list
     *
     * @returns the value that polled out.
     */
    public Object poll() {
        Object o = null;

        for (int i = getPriority() - 1; 0 <= i && o == null; i--) {
            o = _priorityQueue[i].pollFirst();
        }

        return o;
    }

    /**
     * Check if the queue contains value
     *
     * @param o param to check if the queue contains
     * @return true if the queue contain the value
     */
    public Boolean contains(Object o) {
        Boolean isContain = false;

        for (int i = getPriority() - 1; 0 <= i && isContain == false; i--) {
            isContain = _priorityQueue[i].contains(o);
        }

        return isContain;
    }

    /**
     * Remove value from the queue
     *
     * @param o the value to remove from the list
     * @return true if the value removed
     */
    public Boolean remove(Object o) {
        Boolean isDelete = false;

        for (int i = getPriority() - 1; 0 <= i && isDelete == false; i--) {
            isDelete = _priorityQueue[i].remove(o);
        }

        return isDelete;
    }

    /**
     * @return the queue size
     */
    public int size() {
        int size = 0;

        for (int i = getPriority() - 1; 0 <= i; i--) {
            size += _priorityQueue[i].size();
        }

        return size;
    }

    /**
     * @return iterator over the elements in the queue - will point to the value with the highest priority to te lowest
     */
    public Iterator iterator() {
        LinkedList list = new LinkedList();
        for (int i = getPriority() - 1; 0 <= i; i--) {
            list.addAll(_priorityQueue[i]);
        }

        return list.iterator();
    }


    public int getPriority() {
        return _priorityQueue.length;
    }

    public String toString() {
        String s = "[ ";
        Iterator it = this.iterator();
        while (it.hasNext()) {

            s += it.next() + ", ";
        }
        s = s.substring(0, s.length() - 2);
        s += " ]";

        return s;
    }

}
