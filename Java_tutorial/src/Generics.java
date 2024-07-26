
class Printe <T> {
	T loger ;	
	
	Printe(T loger){
		this.loger=loger;
	}
	void printfunction (){
		System.out.println(loger);
	}
}


public class Generics{
		public static void main(String args[]) {
		Printe<String> abc = new Printe<>("23fss");
		abc.printfunction();
		Printe<Integer> cde = new Printe<>(23);
		cde.printfunction();
		Printe<Float> xyz = new Printe<>(23f);
		xyz.printfunction();
		}

}