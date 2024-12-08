package interview;

public class TransposeRowToColumn {

	public static void main(String[] args) {

		String [][] array = {{"A","B","C","D"},{"1","2","3","4"},{"10","20","30","40"}};
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<=3;j++) {
				System.out.print(array[i][j]+"   ");
			}
			System.out.println();
		}
		System.out.println("==============Transpose rows to columns ==============================");
		
		// transpose rows to columns
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(array[j][i]+"   ");
			}
			System.out.println();
		}
	}

}
