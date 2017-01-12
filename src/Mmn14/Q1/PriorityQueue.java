package Mmn14.Q1;


import java.util.LinkedList;

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

    public void add(Object value, int priority) {
        if (priority < MIN_PRIORITY || priority > MAX_PRIORITY) {
            priority = MAX_PRIORITY;
        }
        _priorityQueue[priority].addFirst(value);
    }

    public Object poll() {
        Object o = null;

        for (int i = getPriority(); 0 < i && o == null; i--) {
            o = _priorityQueue[i].pollFirst();
        }

        return o;
    }

    public Boolean contains(Object o) {
        Boolean isContain = false;

        for (int i = getPriority(); 0 < i && isContain == false; i--) {
            isContain = _priorityQueue[i].contains(o);
        }

        return isContain;
    }

    public Boolean remove(Object o) {
        Boolean isDelete = false;

        for (int i = getPriority(); 0 < i && isDelete == false; i--) {
            isDelete = _priorityQueue[i].remove(o);
        }

        return isDelete;
    }

    public int size() {
        int size = 0;

        for (int i = getPriority(); 0 < i; i--) {
            size += _priorityQueue[i].size();
        }

        return size;
    }

    public int getPriority() {
        return _priorityQueue.length;
    }


}
