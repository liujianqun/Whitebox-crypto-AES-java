/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.xklinec.whiteboxAES.generator;

import java.security.SecureRandom;

/**
 *
 * @author ph4r05
 */
public class GenUtils {
    
    private SecureRandom rand;

    public GenUtils() {
    }

    public GenUtils(SecureRandom rand) {
        this.rand = rand;
    }
    
    /**
     * Generates random permutation of an integer array of given size.
     * Initializes the array if int>0.
     * 
     * @param bijection
     * @param size
     * @param init
     * @return 
     */
    public int randomPermutation(int[] bijection, int size, int init){
        int i;
        if (init >= 0) {
            for (i = 0; i < size; i++) {
                bijection[i] = i + init;
            }
        }

        return randomPermutation(bijection, size);
    }
    
    /**
     * Generates random permutation of integer array of given size.
     * Secure random is provided by class.
     * @param bijection
     * @param size
     * @return 
     */
    public int randomPermutation(int[] bijection, int size){
        return randomPermutation(bijection, size, rand);
    }
    
    /**
     * Generates random permutation of integer array of given size.
     * Secure random is provided by user.
     * 
     * @param bijection
     * @param size
     * @param rand
     * @return 
     */
    public static int randomPermutation(int[] bijection, int size, SecureRandom rand){
        // yes, we start from second element on purpose, to produce uniform distribution
        for (int i = 1; i < size; i++) {
            // rnd is index from interval [0, i]
            int rnd = rand.nextInt(i + 1);

            // swap values
            int tmp = bijection[rnd];
            bijection[rnd] = bijection[i];
            bijection[i] = tmp;
        }

        return 0;
    }
    
    public <T> int randomPermutation(T[] bijection, int size){
        return randomPermutation(bijection, size, rand);
    }
    
    /**
     * Generates random permutation of given generic array.
     * 
     * @param <T>
     * @param bijection
     * @param size
     * @param rand
     * @return 
     */
    public static <T> int randomPermutation(T[] bijection, int size, SecureRandom rand){
        // yes, we start from second element on purpose, to produce uniform distribution
        for (int i = 1; i < size; i++) {
            // rnd is index from interval [0, i]
            int rnd = rand.nextInt(i + 1);

            // swap values
            T tmp = bijection[rnd];
            bijection[rnd] = bijection[i];
            bijection[i] = tmp;
        }

        return 0;
    }
    
    /**
     * Generates random bijection and its inverse on integer type of given size.
     * Secure random is provided by class.
     * 
     * @param bijection
     * @param inverse
     * @param size
     * @param init
     * @param rand
     * @return 
     */
    public int generateRandomBijection(int[] bijection, int[] inverse, int size, boolean init){
        return generateRandomBijection(bijection, inverse, size, init, rand);
    }
    
    /**
     * Generates random bijection and its inverse on integer type of given size.
     * Secure random is provided by user.
     * 
     * @param bijection
     * @param inverse
     * @param size
     * @param init
     * @param rand
     * @return 
     */
    public static int generateRandomBijection(byte[] bijection, byte[] inverse, int size, boolean init, SecureRandom rand){
	int i;
        if (init) {
            for (i = 0; i < size; i++) {
                bijection[i] = (byte)i;
                inverse[i] = (byte)i;
            }
        }

        // yes, we start from second element on purpose, to produce uniform distribution
        for (i = 1; i < size; i++) {
            // rnd is index from interval [0, i]
            int rnd = rand.nextInt(i + 1);

            // swap indexes
            byte idx = inverse[bijection[rnd]];
            inverse[bijection[rnd]] = inverse[bijection[i]];
            inverse[bijection[i]] = idx;

            // swap values
            byte tmp = bijection[rnd];
            bijection[rnd] = bijection[i];
            bijection[i] = tmp;
        }

        return 0;
    }
    
    /**
     * Generates random bijection and its inverse on integer type of given size.
     * Secure random is provided by user.
     * 
     * @param bijection
     * @param inverse
     * @param size
     * @param init
     * @param rand
     * @return 
     */
    public static int generateRandomBijection(int[] bijection, int[] inverse, int size, boolean init, SecureRandom rand){
	int i;
        if (init) {
            for (i = 0; i < size; i++) {
                bijection[i] = i;
                inverse[i] = i;
            }
        }

        // yes, we start from second element on purpose, to produce uniform distribution
        for (i = 1; i < size; i++) {
            // rnd is index from interval [0, i]
            int rnd = rand.nextInt(i + 1);

            // swap indexes
            int idx = inverse[bijection[rnd]];
            inverse[bijection[rnd]] = inverse[bijection[i]];
            inverse[bijection[i]] = idx;

            // swap values
            int tmp = bijection[rnd];
            bijection[rnd] = bijection[i];
            bijection[i] = tmp;
        }

        return 0;
    }

    public SecureRandom getRand() {
        return rand;
    }

    public void setRand(SecureRandom rand) {
        this.rand = rand;
    }
    
   
}
