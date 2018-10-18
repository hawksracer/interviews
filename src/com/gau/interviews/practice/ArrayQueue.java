package com.gau.interviews.practice;

import java.util.Arrays;

public class ArrayQueue {
    private Object[] backer;
    private int head;
    private int tail;
    private int currSize = 0;

    public ArrayQueue()
    {
        backer = new Object[10];
        head = tail = -1;
    }

    public void enque(Object newEntry)
    {
        if (head == -1) // empty
        {
            backer[0] = newEntry;
            head = 0;
            tail = 0;
        }
        else if (currSize == backer.length) // full
        {
            expand();
            enque(newEntry);
        }
        else
        {
            if (tail != backer.length - 1) {
                backer[tail + 1] = newEntry;
                tail++;
            }
            else
            {
                backer[0] = newEntry;
                tail = 0;
            }
        }

        currSize++;
    }

    public Object dequeue()
    {
        Object popObj = backer[head];
        backer[head] = null;

        if (currSize > 1) {
            if (head == backer.length - 1)
            {
                head = 0;
            }
            else
            {
                head++;
            }
        }
        else {
            head = tail = -1;
        }
        currSize--;

        return popObj;
    }

    private void expand()
    {
        Object[] newBacker = new Object[backer.length * 2];
        int newIdx = 0;
        for (int i = head; i < backer.length; i++)
        {
            newBacker[newIdx] = backer[i];
            newIdx++;
        }

        if (head > 0)
        {
            for (int i = 0; i <= tail; i++)
            {
                newBacker[newIdx] = backer[i];
                newIdx++;
            }
        }

        head = 0;
        tail = currSize-1;
        backer = newBacker;
    }

    public String printStr()
    {
        return Arrays.toString(backer);
    }

    public static void main(String[] args)
    {
        ArrayQueue myQueue = new ArrayQueue();

        int entry = 1;

        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());

        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());

        myQueue.enque(entry++);
        myQueue.enque(entry++);
        myQueue.enque(entry++);
        myQueue.enque(entry++);
        myQueue.enque(entry++);
        myQueue.enque(entry++);
        myQueue.enque(entry++);
        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());

        myQueue.dequeue();
        System.out.println(myQueue.printStr());

        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());
        myQueue.dequeue();
        System.out.println(myQueue.printStr());
        myQueue.dequeue();
        System.out.println(myQueue.printStr());


        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());
        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());
        myQueue.enque(entry++);
        System.out.println(myQueue.printStr());

    }
}

