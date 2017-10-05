CP=$1
SHARED_FP=$2
URL=$3
RMI=$4
cd src
java -cp $CP:$SHARED_FP/compute.jar -Djava.rmi.server.codebase=$URL -Djava.rmi.server.hostname=$RMI -Djava.security.policy=server.policy engine.ComputeEngine
cd ..
