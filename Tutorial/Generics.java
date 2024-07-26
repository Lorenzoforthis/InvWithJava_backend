package best_pratice;


class Print <T> {
	T loger ;	
	
	Print(T loger){
		this.loger=loger;
		
}


public class Generices{
	public static void main(String args[]) {
	
		Print<Integer> abc = new Print<Integer>(23);
		System.out.print(abc);
	
	
	}

}}
