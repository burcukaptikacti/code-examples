### JAVA NOTES

#### Performance Notes

* A throughput measurement is based on the amount of work that can be accomplished in a certain period of time. In a client-server test, a throughput measurement means that clients have no think time. 

* The response time: the amount of time that elapses between the sending of a request from a client and the receipt of the response. The difference between a response time test and a throughput test (assuming the latter is client-server based) is that client threads in a response time test sleep for some period of time between operations. This is referred to as think time. The important measurement is the response time for the request: the effectiveness of the server is based on how quickly it responds to that **fixed load**.


##### TIPS
*  If the CPU usage has increased, it’s time to consult the profile information to see what is taking more time. If the time spent in GC has increased, it’s time to consult the heap profiles to see what is consuming more memory. If CPU time and GC time have decreased, contention somewhere has likely slowed down performance: stack data can point to particular synchronization bottlenecks.

##### JIT
* The JIT compiler comes in two flavors : client and server. The primary difference between the two compilers is their aggressiveness in compiling code. The client compiler begins compiling sooner than the server compiler does. This means that during the beginning of code execution, the client compiler will be faster, because it will have compiled correspondingly more code than the server compiler. The engineering trade-off here is the knowledge the server compiler gains while it waits: that knowledge allows the server compiler to make better optimizations in the compiled code. Ultimately, code produced by the server compiler will be faster than that produced by the client compiler.The obvious question here is why there needs to be a choice at all: couldn’t the JVM start with the client compiler, and then use the server compiler as code gets hotter? That technique is known as tiered compilation. With tiered compilation, code is first compiled by the client compiler; as it becomes hot, it is recompiled by the server compiler.

##### GARBAGE COLLECTORS:
* **Throughput Collector: **  The throughput collector has two basic operations: it collects the young generation, and it collects the old generation.

* **CMS Collector: ** CMS has three basic operations: CMS collects the young generation (stopping all application threads), CMS runs a concurrent cycle to clean data out of the old generation and If necessary, CMS performs a full GC.
Concurrent mode failures and promotion failures in CMS are quite expensive; CMS should be tuned to avoid these as much as possible.
The old generation initially fills up by placing the objects right next to each other. When some amount of the old generation is filled (by default, 70%), the concurrent cycle begins and the background CMS thread(s) start scanning the old generation for garbage. At this point, a race is on: CMS must complete scanning the old generation and freeing objects before the remainder (30%) of the old generation fills up. If the concurrent cycle loses the race, CMS will experience a concurrent mode failure.There are multiple ways to attempt to avoid this failure: Make the old generation larger, either by shifting the proportion of the new generation to the old generation, or by adding more heap space altogether. /Run the background thread more often. / Use more background threads.


* **G1 :** has four main operations: A young collection, A background, concurrent cycle, A mixed collection, If necessary, a full GC

##### HEAP MEMORY PRACTICES
* The **retained memory** of an object is the amount of memory that would be freed if the object itself were eligible to be collected. 
* The **shallow size** of an object is the size of the object itself. If the object contains a reference to another object, the 4 or 8 bytes of the reference is included, but the size of the target object is not included.
* The **deep size** of an object includes the size of those objects. The difference between the deep size of an object and the retained memory of an object lies in objects that are otherwise shared. 

**Out Of Memory** 
 For both permgen and the regular heap, out of memory errors most frequently occur because of memory leaks; heap analysis tools can help to find the root cause of the leak
* No native memory is available for the JVM.
* The permgen (in Java 7 and earlier) or metaspace (in Java 8) is out of memory: The root cause can be two things: the first is simply that the application uses more classes than can fit in the default perm space; the solution to that is to increase the size of permgen. The second case is trickier: it involves a classloader memory leak. 
* The Java heap itself is out of memory: the application has too many live objects for the given heap size.
* The JVM is spending too much time performing GC.


**Using Less Memory**
*The size of an object is not always immediately apparent: ob‐ jects are padded to fit on 8-byte boundaries, and object refer‐ ence sizes are different between 32- and 64-bit JVMs. Even null instance variables consume space within object classes.
* what about object fields that hold the result of a calculation based on pieces of data? This is the classic computer science trade-off of time versus space: is it better to spend the memory (space) to store the value, or better to spend the time (CPU cycles) to calculate the value as needed? In Java, though, the trade-off applies to CPU time as well, since the additional memory can cause GC to consume more CPU cycles.
* Use lazy initialization only when the common code paths will leave variables uninitialized. Lazy initialization of thread-safe code is unusual but can often piggyback on existing synchronization. Use double-checked locking for lazy initialization of code using thread-safe objects.
* The amount of live data is more important even than the size of the heap; it is faster to process a 3 GB old generation with few surviving objects than to process a 1 GB old generation where 75% of the objects survive.
*  Object initialization performance depends on the object. You should only consider reusing objects with a very high initialization cost, and only then if the cost of initializing those objects is one of the dominant operations in your program.
*  When initialization of objects takes a long time, don’t be afraid to explore object pooling or thread-local variables to reuse those expensive-to-create objects. As always, though, strike a balance: large object pools of generic classes will most certainly lead to more performance issues than they solve.Leave these techniques to classes that are expensive to initialize, and when the number of the reused objects will be small.
* There are trade-offs between reusing an object via an object pool or using a thread-local variable. In general, thread-local variables are easier to work with, assuming that a one-to-one correspondence between threads and reusable objects is desired.
* Weak references should be used when the referent in question will be used by several threads simultaneously. Otherwise, the weak reference is too likely to be reclaimed by the garbage collector: objects that are only weakly referenced are reclaimed at every GC cycle.
* It is as if we are saying to the JVM: “Hey, as long as someone else is interested in this object, let me know where it is, but if they no longer need it, throw it away and I will re-create it myself.” Compare that to a soft reference, which essentially says: “Hey, try and keep this around as long as there is enough memory and as long as it seems that someone is occasionally accessing it.” Not understanding this distinction is the most frequent performance issue that occurs when using weak references. Don’t make the mistake of thinking that a weak reference is just like a soft reference except that it is freed more quickly: a softly referenced object will be available for (usually) minutes or even hours, but a weakly referenced object will be available only for as long as its referent is still around (subject to the next GC cycle clearing it).

##### THREADS
The guidelines apply to the performance of CAS-based utilities compared to traditional synchronization: 
* If access to a resource is uncontended, then CAS-based protection will be slightly faster than traditional synchronization (though no protection at all will be slightly faster still).
* If access to a resource is lightly or moderately contended, CAS-based protection will be faster (often much faster) than traditional synchronization.
* As access to the resource becomes heavily contended, traditional synchronization will at some point become the more efficient choice. In practice, this occurs only on very large machines running a large number of threads.
* CAS-based protection is not subject to contention when values are read and not written.

* Thread stacks can show how significantly threads are blocked (since a thread that is blocked is already at a safepoint). If successive thread dumps show a large number of threads blocked on a lock, then you can conclude that the lock in question has significant contention. If successive thread dumps show a large number of threads blocked waiting for I/O, then you can conclude that whatever I/O they are reading needs to be tuned (e.g., if they are making a database call, the SQL they are executing needs to be tuned, or the database itself needs to be tuned).

##### DATABASES


**JDBC** 

* JDBC drivers can be written to perform more work within the Java application (the database client) or to perform more work on the database server.The thin driver is written to have a fairly small footprint within the Java application: it relies on the database server to do more processing. The thick driver is just the opposite: it offloads work from the database at the expense of requiring more processing and more memory on the Java client.

* In most circumstances, code should use a PreparedStatement rather than a Statement for its JDBC calls. The difference is that prepared statements allow the database to reuse information about the SQL that is being executed. Prepared statements provide their performance benefit when they are pooled—that is, when the actual PreparedStatement object is reused. 

*  Transactions affect the speed of applications in two ways: trans‐ actions are expensive to commit, and the locking associated with transactions can prevent database scaling.










 