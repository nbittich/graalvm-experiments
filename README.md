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