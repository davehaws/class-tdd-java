package com.siq.workshops.tdd.refactoring;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.siq.workshops.tdd.refactoring.Primes;

public class PrimesTest {
	private int[] knownPrimes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

	@Test
	public void Zero() {
		int[] primes = Primes.GenerateArray(0);
		assertEquals(0, primes.length);
	}

	@Test
	public void ListZero() {
		ArrayList primes = Primes.Generate(0);
		assertEquals(0, primes.size());
	}

	@Test
	public void Single() {
		int[] primes = Primes.GenerateArray(2);
		assertEquals(1, primes.length);
		assertEquals(2, primes[0]);
	}

	@Test
	public void ListSingle() {
		ArrayList primes = Primes.Generate(2);
		assertEquals(1, primes.size());
		assertTrue(primes.contains(2));
	}

	@Test
	public void Prime() {
		int[] centArray = Primes.GenerateArray(100);
		assertEquals(25, centArray.length);
		assertEquals(97, centArray[24]);
	}

	@Test
	public void ListPrime() {
		ArrayList centList = Primes.Generate(100);
		assertEquals(25, centList.size());
		assertEquals(97, centList.get(24));
	}

	@Test
	public void Basic() {
        int[] primes = Primes.GenerateArray(knownPrimes[knownPrimes.length - 1]);
        assertEquals(knownPrimes.length, primes.length);

        int i = 0;

        for (int p = 0; p < primes.length; p++) {
	        int prime = primes[p];
            assertEquals(knownPrimes[i++], prime);
        }
    }

	@Test
    public void ListBasic() {
        ArrayList primes = Primes.Generate(knownPrimes[knownPrimes.length - 1]);
        assertEquals(knownPrimes.length, primes.size());

        int i = 0;
        for (int p = 0; p < primes.size(); p++) {
	        int prime = (Integer) primes.get(p);
            assertEquals(knownPrimes[i++], prime);
        }
    }

	@Test
    public void Lots() {

        int bound = 10101;
        int[] primes = Primes.GenerateArray(bound);

        for (int p = 0; p < primes.length; p++) {
	        int prime = (Integer) primes[p];
            assertTrue("is prime", IsPrime(prime));
        }

        for (int p = 0; p < primes.length; p++) {
	        int prime = (Integer) primes[p];
            if (IsPrime(prime))
                assertTrue("contains primes", Contains(prime, primes));
            else
                assertFalse("contains primes", Contains(prime, primes));
        }
    }

	@Test
    public void ListLots() {
        int bound = 10101;

        ArrayList primes = Primes.Generate(bound);
        for (int p = 0; p < primes.size(); p++) {
	        int prime = (Integer) primes.get(p);
            assertTrue("is prime", IsPrime(prime));
        }

        for (int p = 0; p < primes.size(); p++) {
	        int prime = (Integer) primes.get(p);
            if (IsPrime(prime))
                assertTrue("contains primes",primes.contains(prime));
            else
                assertFalse("doesn't contain composites", primes.contains(prime));
        }
    }

	private static boolean IsPrime(int n) {
		if (n < 2)
			return false;
		boolean result = true;
		double x = Math.sqrt(n);
		int i = 2;
		while (result && i <= x) {
			result = (0 != n % i);
			i += 1;
		}
		return result;
	}

	private static boolean Contains(int value, int[] primes) {
        for (int p = 0; p < primes.length; p++) {
	        int prime = primes[p];
	        if (prime == value) {
	        	return true;
	        }
        }
        return false;
	}

}
