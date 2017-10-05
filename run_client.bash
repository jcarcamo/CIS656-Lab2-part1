CP=$1
SHARED_FILES=$2
URL=$3
RMI=$4
cd src
java -cp $CP:$SHARED_FILES/compute.jar -Djava.rmi.server.codebase=$URL -Djava.security.policy=client.policy client.ComputeCombined $RMI
