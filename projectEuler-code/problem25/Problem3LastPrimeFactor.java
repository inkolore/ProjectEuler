package projectEuler.problem25;

import java.util.ArrayList;
import java.util.List;
import projectEuler.general.Prime;

public class Problem3LastPrimeFactor {
	
	public static void main(String[] args) {
		// https://projecteuler.net/problem=3
		// What is the largest prime factor of the number 600851475143 ?
		
		long number = 600851475143l;
		long numberInitial = number;
	
		// Is it possible to not have to memorize primes ?
		// Current idea : Find next prime p by having already computed primes before it
		// Then if p divides number,
		//		set biggestDivisor as p
		//		divide number by p until it can't
		int biggestDivisor = 1;
		List<Integer> computedPrimes = new ArrayList<>();
		
		// Kind of ugly but I don't know if worth making it better
		int p = 2;
		computedPrimes.add((Integer) p);
		while((number % p) == 0) {
			biggestDivisor = p;
			number = number / p;
		}
		p = 3;
		computedPrimes.add((Integer) p);
		while((number % p) == 0) {
			biggestDivisor = p;
			number = number / p;
		}
		
		while(number > 1) {
			p = Prime.computeNextPrime(computedPrimes);
			computedPrimes.add((Integer) p);
			
			while((number % p) == 0) {
				biggestDivisor = p;
				number = number / p;
			}
		}
		
		System.out.printf("The biggest divisor of %s is %s %n", numberInitial, biggestDivisor);
	}
}
