package 알고리즘3주차;

import java.util.Arrays;

public class assign4{
	static int min=1000;
	static int max=100000;
	static int arr_random[]=new int[max];
	static int arr_reverse[]=new int[max];
	static int temp[]=new int[max];
	static int tempM[]=new int[max];
	public static void main(String[] args) {
		random(100000,arr_random);
		reverse(100000,arr_reverse);
		System.out.println("\t\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000");
		System.out.print("Bubble\t");
	 		for(int i=min;i<=max;i*=10){
			for(int k=0;k<i;k++) temp[k]=arr_random[k];
			System.out.print("\t\t"+String.format("%.3f",bubble_sort(temp,i)));
			for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
			System.out.print("\t\t"+String.format("%.3f",bubble_sort(temp,i)));
		}
		System.out.println();
		System.out.print("Insertion");
		for(int i=min;i<=max;i*=10){
			for(int k=0;k<i;k++) temp[k]=arr_random[k];
			System.out.print("\t\t"+String.format("%.3f",insertion_sort(temp,i)));
			for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
			System.out.print("\t\t"+String.format("%.3f",insertion_sort(temp,i)));
		}
		System.out.println();
		System.out.print("Selection");
		for(int i=min;i<=max;i*=10){
			for(int k=0;k<i;k++) temp[k]=arr_random[k];
			System.out.print("\t\t"+String.format("%.3f",selection_sort(temp,i)));
			for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
			System.out.print("\t\t"+String.format("%.3f",selection_sort(temp,i)));
		}
		System.out.println();
		System.out.print("Merge\t");
		for(int i=min;i<=max;i*=10)
		{
			double avg=0.0,avg1=0.0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<i;k++) temp[k]=arr_random[k];
				long start = System.currentTimeMillis();
				merge_sort(temp,0,i-1);
				long end = System.currentTimeMillis();
				avg+=(end-start)/1000.0;
				for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
				start = System.currentTimeMillis();
				merge_sort(temp,0,i-1);
				end = System.currentTimeMillis();
				avg1+=(end-start)/1000.0;
			}
			System.out.print("\t\t"+String.format("%.3f",avg/10.0));
			System.out.print("\t\t"+String.format("%.3f",avg1/10.0));
		}
		System.out.println();
		System.out.print("Quick1\t");
		for(int i=min;i<=max;i*=10)
		{
			double avg=0.0,avg1=0.0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<i;k++) temp[k]=arr_random[k];
				long start = System.currentTimeMillis();
				Quick_sort_last(temp,0,i-1);
				long end = System.currentTimeMillis();
				avg+=(end-start)/1000.0;
				for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
				start = System.currentTimeMillis();
				if(i!=100000)
				Quick_sort_last(temp,0,i-1);
				end = System.currentTimeMillis();
				avg1+=(end-start)/1000.0;
			}
			System.out.print("\t\t"+String.format("%.3f",avg/10.0));
			System.out.print("\t\t"+String.format("%.3f",avg1/10.0));
		}
		System.out.println();
		System.out.print("Quick2\t");
		for(int i=min;i<=max;i*=10)
		{
			double avg=0.0,avg1=0.0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<i;k++) temp[k]=arr_random[k];
				long start = System.currentTimeMillis();
				Quick_sort_median(temp,0,i-1);
				long end = System.currentTimeMillis();
				avg+=(end-start)/1000.0;
				for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
				start = System.currentTimeMillis();
				Quick_sort_median(temp,0,i-1);
				end = System.currentTimeMillis();
				avg1+=(end-start)/1000.0;
			}
			System.out.print("\t\t"+String.format("%.3f",avg/10.0));
			System.out.print("\t\t"+String.format("%.3f",avg1/10.0));
		}
		System.out.println();
		System.out.print("Quick3\t");
		for(int i=min;i<=max;i*=10)
		{
			double avg=0.0,avg1=0.0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<i;k++) temp[k]=arr_random[k];
				long start = System.currentTimeMillis();
				Quick_sort_randomized(temp,0,i-1);
				long end = System.currentTimeMillis();
				avg+=(end-start)/1000.0;
				for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
				start = System.currentTimeMillis();
				Quick_sort_randomized(temp,0,i-1);
				end = System.currentTimeMillis();
				avg1+=(end-start)/1000.0;
			}
			System.out.print("\t\t"+String.format("%.3f",avg/10.0));
			System.out.print("\t\t"+String.format("%.3f",avg1/10.0));
		}
		System.out.println();
		System.out.print("Heap\t");
		for(int i=min;i<=max;i*=10)
		{
			double avg=0.0,avg1=0.0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<i;k++) temp[k]=arr_random[k];
				long start = System.currentTimeMillis();
				build_max_heap(temp,i-1);
				long end = System.currentTimeMillis();
				avg+=(end-start)/1000.0;
				for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
				start = System.currentTimeMillis();
				build_max_heap(temp,i-1);
				end = System.currentTimeMillis();
				avg1+=(end-start)/1000.0;
			}
			System.out.print("\t\t"+String.format("%.3f",avg/10.0));
			System.out.print("\t\t"+String.format("%.3f",avg1/10.0));
			}
		System.out.println();
		System.out.print("Library\t");
		for(int i=min;i<=max;i*=10)
		{
			double avg=0.0,avg1=0.0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<i;k++) temp[k]=arr_random[k];
				long start = System.currentTimeMillis();
				Arrays.sort(temp);
				long end = System.currentTimeMillis();
				avg+=(end-start)/1000.0;
				for(int k=max-i,q=0;k<max;k++,q++) temp[q]=arr_reverse[k];
				start = System.currentTimeMillis();
				Arrays.sort(temp);
				end = System.currentTimeMillis();
				avg1+=(end-start)/1000.0;
			}
			System.out.print("\t\t"+String.format("%.3f",avg/10.0));
			System.out.print("\t\t"+String.format("%.3f",avg1/10.0));
			}
	}
	static void random(int a, int[] arr)
	{
		for( int i =0;i<a;i++)
			arr[i]=(int)(Math.random()*a+1);
	}
	static void reverse(int a, int arr[])
	{for (int i=a;i>0;i--)
		arr[a-i]=i;
	}
	static double bubble_sort (int arr[],int l) {
		double avg=0.0;
		for(int k=0;k<10;k++) {
			long start = System.currentTimeMillis();
			for(int i=l;i>0;i--) {
				for(int j=0;j<l-1;j++)
				{
					if(arr[j]>arr[j+1])
						swap(arr,j,j+1);
				}
			}long end = System.currentTimeMillis();
			avg+=(end-start)/1000.0;
		}
		return avg/10.0;
	}
	static double insertion_sort(int arr[],int m) {
		double avg=0.0;
		for(int k=0;k<10;k++) {
			long start = System.currentTimeMillis();
			for(int i=1;i<m;i++) {
				int tmp=arr[i]; int j=i-1;
				for(;j>=0;j--)
				{
					if(tmp<arr[j]) {
						arr[j+1]=arr[j];
					}
				}
				arr[j+1]=tmp;}
			long end = System.currentTimeMillis();
			avg+=(end-start)/1000.0;
		}
		return avg/10.0;
	}
	static double selection_sort(int arr[],int m) {
		double avg=0.0;
		for(int k=0;k<10;k++) {
			long start = System.currentTimeMillis();
			for(int i=m-1;i>0;i--)
			{int large =i;
			for(int j=0;j<m-1;j++) {
				if(arr[j]>arr[large])
					large=j;
			}
			if(i!=large)
				swap(arr,i,large);
			}
			long end = System.currentTimeMillis();
			avg+=(end-start)/1000.0;
		}
		return avg/10.0;
	}
	static void merge_sort(int arr[],int p,int r) {
		if(p<r) {
			int q=(p+r)/2;
			merge_sort(arr,p,q);
			merge_sort(arr,q+1,r);
			merge(arr,p,q,r);
		}
	}
	static void merge(int arr[],int p,int q,int r) {
		int i=p, j=q+1,k=p;
		while(i<=q&&j<=r) {
			if(arr[i]<=arr[j])
				tempM[k++]=arr[i++];
			else
				tempM[k++]=arr[j++];
		}
		while(i<=q)
			tempM[k++]=arr[i++];
		while(j<=r)
			tempM[k++]=arr[j++];
		for(int a=p;a<=r;a++)
			arr[a]=tempM[a];
	}
	static int partition_last(int arr[],int p, int r) {
		int x = arr[r], i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] < x)
				swap(arr,++i,j);
		}
		swap(arr,++i,r);
		return i;
	}

	static void Quick_sort_last(int arr[],int p, int r) {
		if (p < r) {
			int q = partition_last(arr,p,r);
			Quick_sort_last(arr,p, q - 1);
			Quick_sort_last(arr,q + 1, r);
		}
	}
	static int partition_median(int arr[],int p, int r) {
		int index=three_median(arr,p,r,(p+r)/2),i=p-1;
		int x= arr[index];
		swap(arr,r,index);
		for (int j = p; j < r; j++) {
			if (arr[j] < x)
				swap(arr,++i,j);
		}
		swap(arr,++i,r);
		return i;
	}

	static void Quick_sort_median(int arr[],int p, int r) {
		if (p < r) {
			int q = partition_median(arr,p,r);
			Quick_sort_median(arr,p, q - 1);
			Quick_sort_median(arr,q + 1, r);
		}
	}
	static int partition_randomized(int arr[],int p, int r) {
		int random = (int)(Math.random()*(r-p+1))+p;
		int x = arr[random], i = p-1;
		swap(arr,r,random);
		for (int j = p; j < r; j++) {
			if (arr[j] < x) {
				swap(arr,++i,j);
			}
		}
		swap(arr,++i,r);
		return i;
	}
	static void Quick_sort_randomized(int arr[],int p, int r) {
		if (p < r) {
			int q = partition_randomized(arr,p, r);
			Quick_sort_randomized(arr,p, q - 1);
			Quick_sort_randomized(arr,q + 1, r);
		}
	}
	static int three_median(int arr[],int a, int b, int c)
	{int mid;
	if(arr[a]>=arr[b]&&arr[a]<=arr[c]||arr[a]<=b&&arr[a]>=arr[c])
		mid=a;
	else if(arr[b]>=arr[a]&&arr[b]<=arr[c]||arr[b]<=arr[a]&&arr[b]>=arr[c])
		mid=b;
	else 
		mid=c;
	return mid;
	}
	static void build_max_heap(int []arr,int length) {
		int n=length;
		for(int i=n/2;i>=0;i--)
		Max_heapify(arr,n,i);
		for(int i=n;i>0;i--) {
			swap(arr,0,i);
			Max_heapify(arr,i,0);
		}
	}
	static void Max_heapify(int arr [],int length, int i) {
		int p=i;
		int l=i*2+1;
		int r=i*2+2;
		if(l<length&&arr[p]<arr[l])
			p=l;
		if(r<length&&arr[p]<arr[r])
			p=r;
		if(i!=p)
		{
			swap(arr,p,i);
			Max_heapify(arr,length,p);
		}
	}
	static void swap(int []arr, int a, int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}

