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









 