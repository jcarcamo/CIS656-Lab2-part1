SHARED_FOLDER=$1
cd src
javac -cp $SHARED_FOLDER/compute.jar client/ComputePi.java client/Pi.java client/ComputePrimes.java client/Primes.java client/ComputeCombined.java
mkdir $SHARED_FOLDER/client
cp client/Pi.class $SHARED_FOLDER/client
cp client/Primes.class $SHARED_FOLDER/client
cd ..
