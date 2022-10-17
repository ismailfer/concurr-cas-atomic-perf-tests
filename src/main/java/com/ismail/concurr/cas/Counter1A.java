package com.ismail.concurr.cas;

/**
 * Counter example that lets you read its current value and increment the counter. 
 * This class implements a counter based on synchronized
 *  
 * High contention for the monitor lock will result in excessive context switching 
 * that can delay all of the threads and result in an application that doesn't scale well. 
 *  
 * https://www.infoworld.com/article/2078848/java-concurrency-java-101-the-next-generation-java-concurrency-without-the-pain-part-2.html?page=3
 * 
 * @author ismail
 * @since 20221017
 */
public class Counter1A
{
    private int value;

    public synchronized int getValue()
    {
        return value;
    }
    
    public synchronized int increment()
    {
        return ++value;
    }
}
