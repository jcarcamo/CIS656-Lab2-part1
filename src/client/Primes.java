package client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import compute.Task;

public class Primes implements Task<List<Integer>>, Serializable {

    private static final long serialVersionUID = 228L;

  
    private final int min;
    private final int max;

    /**
     * Construct a task to calculate primes
     * @throws Exception 
     */
    public Primes(int min, int max) throws Exception {
    	if(max < min){
    		throw new Exception("max is lesser than min");
    	}
        this.min = min;
        this.max = max;
    }

    /**
     * Calculate primes.
     * Interface implementation
     */
    public List<Integer> execute(){
    	return computePrimes(min, max);
    }
    
    /**
     * Calculate primes.
     * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     * @return List<Integer> with primes
     */
    public List<Integer> computePrimes(int min, int max){
    	boolean sieve[] = new boolean[max+1];
    	Arrays.fill(sieve,true);
    	
    	for(int i=2; i < Math.sqrt(max);i++){
    		if(sieve[i]){
    			int pow2i = (int) Math.pow(i, 2);
    			for(int j = pow2i, k=1; j <= max; j = pow2i + k*i,k++){
    				sieve[j] = false;    				
    			}
    		}
    	}
    	
    	List<Integer> result = new ArrayList<>();
    	for(int i = min; i<sieve.length; i++){
    		if(sieve[i]){
    			result.add(i);
    		}
    	}
    	return result;
    }
}
