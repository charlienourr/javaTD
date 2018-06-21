package fr.dauphine.javaavance.nourrycharles.td00;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Integer;
/**
 * Hello world!
 *
 */
public class PrimeCollection 
{
	private int totototo;
	private ArrayList<Integer> numbers;
	
	public PrimeCollection(){
		totototo=0;
		numbers=new ArrayList<Integer>();
	}
	
	public void initRandom(int n,int m){
		Random r=new Random();
		for(int i=0;i<n;i++){
			numbers.add((Integer)(r.nextInt(m)));
		}
	}
	

	public String toString(){
		String s ="";
		for(int i=0;i<numbers.size();i++){
			s+=numbers.get(i).toString()+" ";
		}
		return s;
	}
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
	
	public void printPrimes(){
		for(int i=0;i<numbers.size();i++){
			if(isPrime(numbers.get(i))){
				System.out.print(numbers.get(i) + " ");
			}
		}
	}

	public int getToto() {
		return totototo;
	}
	
	public void setToto(int toto) {
		this.totototo = toto;
	}
	
    public static void main( String[] args )
    {
    	PrimeCollection p=new PrimeCollection();
    	p.initRandom(100, 2000);
    	//System.out.println("Ma Liste :\n"+ p.toString());
    	//System.out.println(isPrime(4));
    	//System.out.println(isPrime(11));
    	//System.out.println(isPrime(911));
    	//System.out.println("Nombres premiers de la liste:");
    	p.printPrimes();
        //System.out.println( "Bonjour!" );
        
    }
}
