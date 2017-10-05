SHARED_FOLDER=$1
cd src
javac -cp $SHARED_FOLDER/compute.jar engine/ComputeEngine.java
cd ..
