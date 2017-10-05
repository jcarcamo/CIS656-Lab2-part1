SHARED_FOLDER=$1
cd src
javac compute/Compute.java compute/Task.java
jar cvf ../output/compute.jar compute/*.class
mv ../output/compute.jar $SHARED_FOLDER/.
cd ..
