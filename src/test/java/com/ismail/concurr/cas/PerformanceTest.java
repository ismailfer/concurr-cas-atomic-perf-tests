package com.ismail.concurr.cas;

import org.junit.jupiter.api.Test;

/**
 * Runs a performance test on concurrency testing various implementations
 * 
 * My Test Results (best first):
 * - ReentrantLock is the best, then
 * - Synchronized, then
 * - AtomicInteger
 * 
 * @author ismail
 * @since 20221017
 */
public class PerformanceTest
{
    private static final int threadCount = 10;

    private static final int iterations = 1_000_000;

    @Test
    public void testCounter1A()
    {
        try
        {
            final Counter1A counter = new Counter1A();

            Thread[] tt = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++)
            {
                tt[i] = new Thread()
                {
                    public void run()
                    {
                        for (int m = 0; m < iterations; m++)
                            counter.increment();
                    }
                };
            }

            long nanos = System.nanoTime();

            for (int i = 0; i < threadCount; i++)
                tt[i].start();

            for (int i = 0; i < threadCount; i++)
                tt[i].join();

            nanos = System.nanoTime() - nanos;

            System.out.println(
                    "testCounter1A(synchronized) : counter=" + counter.getValue() + ", threads=" + threadCount + ", " + iterations + ", time=" + (nanos / 1000000.0) + " ms, avg=" + (0.1 * nanos / iterations) + " nanos");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCounter1B()
    {
        try
        {
            final Counter1B counter = new Counter1B();

            Thread[] tt = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++)
            {
                tt[i] = new Thread()
                {
                    public void run()
                    {
                        for (int m = 0; m < iterations; m++)
                            counter.increment();
                    }
                };
            }

            long nanos = System.nanoTime();

            for (int i = 0; i < threadCount; i++)
                tt[i].start();

            for (int i = 0; i < threadCount; i++)
                tt[i].join();

            nanos = System.nanoTime() - nanos;

            System.out.println(
                    "testCounter1B(synchronized) : counter=" + counter.getValue() + ", threads=" + threadCount + ", " + iterations + ", time=" + (nanos / 1000000.0) + " ms, avg=" + (0.1 * nanos / iterations) + " nanos");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCounter2()
    {
        try
        {
            final Counter2 counter = new Counter2();

            Thread[] tt = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++)
            {
                tt[i] = new Thread()
                {
                    public void run()
                    {
                        for (int m = 0; m < iterations; m++)
                            counter.increment();
                    }
                };
            }

            long nanos = System.nanoTime();

            for (int i = 0; i < threadCount; i++)
                tt[i].start();

            for (int i = 0; i < threadCount; i++)
                tt[i].join();

            nanos = System.nanoTime() - nanos;

            System.out.println(
                    "testCounter2(reentrant lock): counter=" + counter.getValue() + ", threads=" + threadCount + ", " + iterations + ", time=" + (nanos / 1000000.0) + " ms, avg=" + (0.1 * nanos / iterations) + " nanos");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCounter3()
    {
        try
        {
            final Counter3 counter = new Counter3();

            Thread[] tt = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++)
            {
                tt[i] = new Thread()
                {
                    public void run()
                    {
                        for (int m = 0; m < iterations; m++)
                            counter.increment();
                    }
                };
            }

            long nanos = System.nanoTime();

            for (int i = 0; i < threadCount; i++)
                tt[i].start();

            for (int i = 0; i < threadCount; i++)
                tt[i].join();

            nanos = System.nanoTime() - nanos;

            System.out.println(
                    "testCounter3(atomic)        : counter=" + counter.getValue() + ", threads=" + threadCount + ", " + iterations + ", time=" + (nanos / 1000000.0) + " ms, avg=" + (0.1 * nanos / iterations) + " nanos");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
