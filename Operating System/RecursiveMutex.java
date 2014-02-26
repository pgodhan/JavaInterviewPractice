public class RecursiveMutex {

	private boolean isLocked = false;
	
	// Store the identity which locked the resource
	Thread lockedBy = null; // Initially setting it to null
	
	private int count = 0; // To keep track of the number of times the resource
							// was acquired by the same thread

	public synchronized void lock() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		try {
			// Check if the calling thread is not the thread who has locked the
			// resource else it will lead to deadlock
			while (isLocked && callingThread != lockedBy)
				wait();

			// Acquire the lock on release and set the lockedBy = callingThread
			// and increment the count by 1
			isLocked = true;
			lockedBy = callingThread;
			count++;
		} finally { // Free the lock on exception
			isLocked = false;
		}

	}

	public synchronized void unlock() {
		// Decrement lock count
		if (Thread.currentThread() == this.lockedBy)
			count--;

		// When count has reach 0 release the lock and notify
		if (count == 0) {
			isLocked = false;
			notify();
		}
	}
}
