### NOTES

* A throughput measurement is based on the amount of work that can be accomplished in a certain period of time. In a client-server test, a throughput measurement means that clients have no think time. 

* The response time: the amount of time that elapses between the sending of a request from a client and the receipt of the response. The difference between a response time test and a throughput test (assuming the latter is client-server based) is that client threads in a response time test sleep for some period of time between operations. This is referred to as think time. The important measurement is the response time for the request: the effectiveness of the server is based on how quickly it responds to that **fixed load**.


#### TIPS
*  If the CPU usage has increased, it’s time to consult the profile information to see what is taking more time. If the time spent in GC has increased, it’s time to consult the heap profiles to see what is consuming more memory. If CPU time and GC time have decreased, contention somewhere has likely slowed down performance: stack data can point to particular synchronization bottlenecks.