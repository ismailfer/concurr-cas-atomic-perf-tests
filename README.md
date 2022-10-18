# Compare and Swap Operation (CAS) - Performance Tests

When doing low-latency development; we have to approach it as a science; that means:
- Have a theory
- Run experiments
- Reach a conclusion
- Write a law

Sometimes that seems to work better; does not really work better in real life.

## What are we testing?

Runs a performance test on concurrency testing various implementations; like:

- Synchronized
- EmulatedCAS using Synchronized
- Reentrant Lock
- AtomicInteger

## Test Results

My Test Results (best first):
- AtomicInteger
- ReentrantLock
- Synchronized
- AtomicInteger (compareAndSet)


