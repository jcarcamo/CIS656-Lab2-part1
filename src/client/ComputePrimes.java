package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import compute.Compute;

public class ComputePrimes {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            Primes task = new Primes(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
            List<Integer> primes = comp.executeTask(task);
            for(Integer i:primes){
            	System.out.print(i+",");
            }
        } catch (Exception e) {
            System.err.println("ComputePrimes exception:");
            e.printStackTrace();
        }
    }
}
