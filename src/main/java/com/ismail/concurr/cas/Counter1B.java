package com.ismail.concurr.cas;

/**
 * The following class uses EmulatedCAS to implement a non-synchronized counter 
 * (pretend that EmulatedCAS doesn't require synchronized): 
 * 
 * increment() repeatedly invokes compareAndSwap() until readValue's value doesn't change. 
 * It's then free to change this value. When no lock is involved, 
 * contention is avoided along with excessive context switching. 
 * 
 * Performance improves and the code is more scalable. 
 * 
 * @author ismail
 * @since 20221017
 */
public class Counter1B
{
    private EmulatedCAS value = new EmulatedCAS();

    public int getValue()
    {
        return value.getValue();
    }
    
    public int increment()
    {
        int readValue = value.getValue();
        int newValue = readValue + 1;
        
        while (value.compareAndSwap(readValue, newValue) != readValue)
        {
            readValue = value.getValue();
            newValue = readValue + 1;
        }
        
        return newValue;
    }
}
