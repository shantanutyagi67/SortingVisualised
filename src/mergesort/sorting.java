package mergesort;

public class sorting {

	public static void main(String[] args) {
		int array[] = {6,3,8,1,9,7,2,5,4,0};
		mergesort(array, 0, 9);
		display(array,10);
	}

	private static void display(int[] array, int len) {
		for(int i=0;i<len;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	private static void mergesort(int[] array, int l, int r) {
		if(l<r) {
			int m = l + ( r - l ) / 2;
			mergesort(array,l,m);
			mergesort(array,m+1,r);
			merge(array,l,m,r);
		}
	}

	private static void merge(int[] array, int l, int m, int r) {
		int i,j,k;
		int L[] = new int[m-l+1];
		int R[] = new int[r-m-1+1];
		for (i = 0; i < m-l+1; i++) 
	        L[i] = array[l + i]; 
	    for (j = 0; j < r-m; j++) 
	        R[j] = array[m + 1+ j]; 
	    i=0;
	    j=0;
	    k=l;
	    //loop control
	    while(i<m-l+1&&j<r-m) {
	    	display(array,10);
	    	if(L[i]<=R[j]) {
	    		array[k] = L[i];
	    		i++;
	    	}
	    	else {
	    		array[k] = R[j];
	    		j++;
	    	}
	    	k++;
	    }
	    while(i<m-l+1) {
	    	display(array,10);
	    	 array[k] = L[i]; 
	         i++; 
	         k++;
	    }
	    while(j<r-m) {
	    	display(array,10);
	    	 array[k] = R[j]; 
	         j++; 
	         k++;
	    }
	}

}
