
public class TestSets {
	public static void main(String args[]) {
		int n = 8;
		Sets sets = new Sets(n);
		sets.initialize(); // parent 배열 초기화.
		int set0[] = { 0 }; 
		int set1[] = { 1 };
		int set2[] = { 2 };
		int set3[] = { 3 };
		int set4[] = { 4 };
		int set5[] = { 5 };
		int set6[] = { 6 };
		int set7[] = { 7 };

		sets.addSet(set0);
		sets.addSet(set1);
		sets.addSet(set2);
		sets.addSet(set3);
		sets.addSet(set4);
		sets.addSet(set5);
		sets.addSet(set6);
		sets.addSet(set7);
		
		sets.printAll(); // set이 완료된 초기 배열을 출력해본다.
		
		sets.weightedUnion(0, 1);
		sets.printSets();
		sets.printAll();
		System.out.println("");
		
		sets.weightedUnion(2, 3);
		sets.printSets();
		sets.printAll();
		System.out.println("");

		sets.weightedUnion(4, 5);
		sets.printSets();
		sets.printAll();
		System.out.println("");
		
		sets.weightedUnion(6, 7);
		sets.printSets();
		sets.printAll();
		System.out.println("");
		
		sets.weightedUnion(0, 3);
		sets.printSets();
		sets.printAll();
		System.out.println("");
		
		sets.weightedUnion(4, 7);
		sets.printSets();
		sets.printAll();
		System.out.println("");
		
		sets.weightedUnion(0, 7);
		sets.printSets();
		sets.printAll();
		System.out.println("");
		
	}
}
