package com.ismail.concurr.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Consider AtomicInteger, which lets you update an int value atomically. 
 * We can use this class to implement the counter 
 * 
 * @author ismail
 * @since 20221017
 */
public class Counter3
{
    private AtomicInteger value = new AtomicInteger();

    public int getValue()
    {
        return value.get();
    }
    
    public int increment()
    {
        int readValue = value.get();
        int newValue = readValue + 1;
        
        while (value.compareAndSet(readValue, newValue) == false)
        {
            readValue = value.get();
            newValue = readValue + 1;
        }
        
        return newValue;
    }
}
