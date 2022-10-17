package com.ismail.concurr.cas;

/**
 * The CAS alternative requires an implementation of the compare-and-swap instruction. 
 * This class emulates CAS. 
 * It uses synchronized instead of the actual hardware instruction to simplify the code
 * 
 * Here, value identifies a memory location, which can be retrieved by getValue(). 
 * Also, compareAndSwap() implements the CAS algorithm. 
 * 
 * @author ismail
 * @since 20221017
 */
public class EmulatedCAS
{
    private int value;
    
    public synchronized int getValue()
    {
        return value;
    }
    
    public synchronized int compareAndSwap(int expectedValue, int newValue)
    {
        int readValue = value;
        
        if (readValue == expectedValue)
            value = newValue;
        
        return readValue;
    }
}
