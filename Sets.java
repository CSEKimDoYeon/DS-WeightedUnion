
public class Sets {
	private int parent[]; // size = 8;
	private int size;

	// 초기 생성자, n 값을입력받음.
	public Sets(int n) {
		this.size = n;
		this.parent = new int[size];
	}

	// parent 배열 초기화
	public void initialize() {
		this.parent = new int[size];
	}

	// set 배열을 입력받아서 parent 배열을 초기화한다. 집합의 Root index는 0번째 원소로 설정한다.
	public void addSet(int set[]) {
		parent[set[0]] = -(set.length); // parent의 index는 set 배열의 크기에 -를 곱한 값이다.
		for (int i = 1; i < set.length; i++) {
			parent[set[i]] = set[0];
		}
	}

	// Root에 속한 원소들을 출력한다.
	public void printSets() {
		for (int i= 0; i < parent.length; i++) {
			if (parent[i] < 0 ) {
				// 해당 element가 root 라면
				System.out.print("[Root : " + i + "]");
				
				if (parent[i] == (-1)*parent.length) { // 만약 parent[i]가 -(배열의 크기라면) 모든 원소를 가지는 최상위 루트이므로.
					for (int x=0 ; x<parent.length ; x++) {
						if(parent[x]>=0) {
							System.out.print(" "+x+" "); // 해당 루트를 제외한 모든 원소를 출력한다.
						}
					}
				}
				
				for (int j=0; j<parent.length ;j++) {
					if(parent[j]==i) { // index i와 값이 같은 parent[j] value 를 출력한다.
						System.out.print(" "+ j +" ");
						for (int k=0 ; k<parent.length ;k++) { 
							if(parent[k]==j) // index j와 값이 같은 parent[j] value를 출력한다.
								System.out.print(" "+k+" ");
						}
					}
					
				}
				//이제 해당 루트의 자식들을 출력한다.
				System.out.println("");	
			}
		}
	}

	public void printAll() { // parent 배열을 출력한다.
		for (int i = 0; i < parent.length; i++) {
			System.out.print(parent[i]+" ");
		}
		System.out.println();
	}
	public void weightedUnion(int i, int j) { // i가 속한 집합과 j 가 속한 집합을
		// 가중치 병합 한다.
		System.out.println("weightedUnion (" + i + "," + j + ")");
		int temp = (-1) * (objectSize(i) + objectSize(j)); // 두 집합의 size를 더한 값에 -1을 곱하여 저장한다.

		if (objectSize(i) >= objectSize(j)) { // i가 속한 집합의 크기가 j가 속한 집합의 크기보다 크거나 같다면.
			parent[collapsingFind(j)] = i; // j의 TopRoot는 를 i로 바꾼다.
			parent[i] = temp; // 두 집합의 크기를 합한 값은 i에 들어간다.
		} else { // i가 속한 집합의 크기가 j가 속한 집합의 크기보다 작다면.
			parent[collapsingFind(i)] = j; // i의 TopRoot 를 j로 바꾼다.
			parent[j] = temp; // 두 집합의 크기를 합한 값은 j에 들어간다.
		}
	}
	public int collapsingFind(int a) { // a가 속한 집합의 TopRoot를 찾는다. 
		if(parent[a]<0) {
			return a; // collapsingFind가 실행되었을 때 첫 parent[a]가 음수라면 
					// TopRoot 이므로 a를 반환한다.
		}
		if (parent[a] >= 0) { // parent[a] 가 양수라면 자식이므로.
			if (parent[parent[a]] < 0) { //다음 element가 root 라면.
				return parent[a]; // parent[a]를 return한다.
			}
			return collapsingFind(parent[parent[a]]); // TopRoot가
			// 나올 때 까지 재귀함수를 돌린다.
		} else
			return a;

	}
	public int objectSize(int a) { // a가 속한 집합의 크기를 구한다.
		return (-1) * parent[collapsingFind(a)]; //TopRoot의 값은 음수이므로 양수로 변환한다.
	}
}
