package genericclasses.atomicoperations;

//*****  Locks  ************
//If two threads try to get and update the value at the same time,
// it may result in lost updates.  One of the ways to manage access to an
// object is to use locks. This can be achieved by using the synchronized keyword in
// the method signature. The synchronized keyword ensures that only
// one thread can enter the method at one time
//Additionally, we need to add the volatile keyword to ensure proper reference visibility among threads.

public class LocksInAtomicOperations {
    private volatile int counter;

    public synchronized void increment() {
        counter++;
    }
}
