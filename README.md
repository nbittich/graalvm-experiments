build java native image : 

docker run --rm -v $PWD/:/app openjdk:17-alpine javac /app/TestJava.java

docker run --rm -v $PWD/:/app  ghcr.io/graalvm/native-image TestJava

=====

build rust:

docker run --rm -v $PWD/:/app --workdir=/app rust:1.62.0 rustc testrust.rs

====

time ./testrust

len: 70000000

real    0m13,999s
user    0m13,059s
sys     0m0,928s

====

time ./testjava

len: 70000000

real    0m33,996s
user    0m28,577s
sys     0m5,400s
====

time node testjs.js

```
<--- Last few GCs --->

[130395:0x6209730]    12799 ms: Scavenge 1983.3 (2018.7) -> 1983.0 (2030.4) MB, 7.3 / 0.0 ms  (average mu = 0.151, current mu = 0.108) allocation failure 
[130395:0x6209730]    12817 ms: Scavenge 1993.9 (2033.4) -> 1994.6 (2035.2) MB, 9.1 / 0.0 ms  (average mu = 0.151, current mu = 0.108) allocation failure 
[130395:0x6209730]    12826 ms: Scavenge 1994.7 (2035.2) -> 1993.8 (2058.2) MB, 9.1 / 0.0 ms  (average mu = 0.151, current mu = 0.108) allocation failure 


<--- JS stacktrace --->

FATAL ERROR: Ineffective mark-compacts near heap limit Allocation failed - JavaScript heap out of memory
 1: 0xb09980 node::Abort() [node]
 2: 0xa1c235 node::FatalError(char const*, char const*) [node]
 3: 0xcf784e v8::Utils::ReportOOMFailure(v8::internal::Isolate*, char const*, bool) [node]
 4: 0xcf7bc7 v8::internal::V8::FatalProcessOutOfMemory(v8::internal::Isolate*, char const*, bool) [node]
 5: 0xeaf465  [node]
 6: 0xeaff46  [node]
 7: 0xebe46e  [node]
 8: 0xebeeb0 v8::internal::Heap::CollectGarbage(v8::internal::AllocationSpace, v8::internal::GarbageCollectionReason, v8::GCCallbackFlags) [node]
 9: 0xec1da5 v8::internal::Heap::HandleGCRequest() [node]
10: 0xe4f447 v8::internal::StackGuard::HandleInterrupts() [node]
11: 0x11fb805 v8::internal::Runtime_StackGuard(int, unsigned long*, v8::internal::Isolate*) [node]
12: 0x15f0b19  [node]
Aborted (core dumped)
```