package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import compute.Compute;

public class ComputeCombined {
    public static void main(String args[]) {
    	if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
        	boolean finished = false;
        	String line;
        	
            BufferedReader is;
            String name = "Compute";
        	is = new BufferedReader(new InputStreamReader(System.in) );
        	
        	Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            Pi taskPi;
            BigDecimal pi;
            
            Primes taskPrimes;
            int min,max;
            List<Integer> primes;
            
        	while(true) {
        		System.out.println("Please select a task, \n1. Compute Pi, \n2. Compute Primes, \n3. Exit. ");	
                line = is.readLine();
                switch(line){
                case "1":
                	System.out.println("Please enter the number places Pi is to be computed");
                	line = is.readLine();
                	taskPi = new Pi(Integer.parseInt(line));
                    pi = comp.executeTask(taskPi);
                    System.out.println("The result is: \n" + pi +"\n\n");
                	break;
                case "2":
                	System.out.println("Please enter a min value");
                	line = is.readLine();
                	min = Integer.parseInt(line);
                	System.out.println("Please enter a max value");
                	line = is.readLine();
                	max = Integer.parseInt(line);
                	if(min<max){
	                	taskPrimes = new Primes(min,max);                   
	                    System.out.println("The result is:");
	                    primes = comp.executeTask(taskPrimes);
	                    for(Integer i:primes){
	                    	System.out.print(i+",");
	                    }
	                    System.out.println("\n\n");
                    }else{
                    	System.out.println("Max has to be greater than min.\n\n");
                    }
                	break;
                case "3":
                	finished = true;
                	break;
                	
                }
                if(finished){
                	break;
                }
            }
        	System.out.println("Bye");
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ComputeCombined exception:");
            e.printStackTrace();
        }
    }
}
