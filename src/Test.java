
public class Test {
	public static void main(String[] args) {
		int max = 0;
		int[] arr=new int[]{50,1,2,33,4,45,67,7};
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(max);
	}
}
