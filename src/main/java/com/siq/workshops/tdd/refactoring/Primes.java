package com.siq.workshops.tdd.refactoring;

import java.util.ArrayList;

public class Primes {
	public static ArrayList Generate(int maxValue) {
        ArrayList result = new ArrayList();
        int[] primes = GenerateArray(maxValue);

        for (int i = 0; i < primes.length; ++i)
            result.add(primes[i]);

        return result;
    }

	@Deprecated
	public static int[] GenerateArray(int maxValue) {
		if (maxValue >= 2) {
			// declarations
			int s = maxValue + 1; // size of array
			Boolean[] f = new Boolean[s];

			int i;
			// initialize the array to true
			for (i = 0; i < s; i++)
				f[i] = true;

			// get rid of known nonprimes
			f[0] = f[1] = false;
			// sieve
			int j;
			for (i = 2; i < Math.sqrt(s) + 1; i++) {
				for (j = 2 * i; j < s; j += i)
					f[j] = false; // multiple is not prime
			}

			// how many primes are there?
			int count = 0;
			for (i = 0; i < s; i++)
				if (f[i]) // if prime
					count++; // bump count

			int[] primes = new int[count];
			// move the primes into the result
			for (i = 0, j = 0; i < s; i++) {
				if (f[i]) // if prime
					primes[j++] = i;
			}

			return primes;
		} // maxValue >= 2
		else
			return new int[0]; // return null array
	}
}
