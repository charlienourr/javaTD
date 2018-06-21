package fr.dauphine.javaavance.nourrycharles.td00;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PrimeCollectionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PrimeCollectionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PrimeCollectionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public static boolean isPrime(Integer i){
        if (i==0){
            return false;
        }
        boolean retour=true;
        Integer j=2;
        while(j<=Math.sqrt(i) && retour){
            if(i%j==0){
                retour=false;
            }
            j++;
        }
        return retour;
    }
    public void testPrimeCollection()
    {
        assertTrue( true );
        test0IsPrime();
        testTwoIsPrime();
        test9IsNotPrime();
    }
    public void test0IsPrime() {assertFalse(isPrime(0));}

    public void testTwoIsPrime() {assertTrue(isPrime(2));}

    public void test9IsNotPrime() {assertFalse(isPrime(9));}
}
