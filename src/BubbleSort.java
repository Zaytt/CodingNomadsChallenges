public class BubbleSort{
	public static void main(String args[]){
		if(args.length < 2) return;	

		int[] array = new int[args.length];
		int z = 0;
		for(String x: args) { 
			array[z] = Integer.valueOf(x); 
			z++;
		}	
		int n = array.length;
		for(int i = 0; i < n-1; i++)
			for(int j = 0; j < n-i-1; j++ )
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp; 
				}
		for(int x:array) System.out.print(x);
		System.out.println();
		
	
	}

}
