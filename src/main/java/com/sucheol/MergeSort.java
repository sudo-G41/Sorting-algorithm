package com.sucheol;

public class MergeSort{
    private long start; 
    private long end;
    private int[] array;
    private int count;
    private long startMemory,endMemory;
    private long times, useMemory;
    public MergeSort(){
    }
    public MergeSort(int[] array){
        this.array = array;
    }
    public void Sort(){
        boolean alreadySorted = true;
        this.count = 0;
        this.start = System.currentTimeMillis();
        mergeSort(this.array, this.array.length);
        this.end = System.currentTimeMillis();
        this.times = this.end-this.start;
        this.endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.useMemory = endMemory;
    }
    
    public void mergeSort(int[] array, int len)
	{   if(len<2){return;}
		int mid=len/2;
		int left[]=new int[mid];
		int right[]=new int[len-mid];
		for(int i=0;i<mid;i++)
			left[i]=array[i];
		for(int i=mid;i<len;i++)
			right[i-mid]=array[i];
		mergeSort(left,mid);
		mergeSort(right,len-mid);
		merge(left,right,array);
	}
	public void merge(int left[],int right[],int array[])
	{
		int nL=left.length;
		int nR=right.length;
		int i,j,k;
		i=j=k=0;
		while(i<nL&&j<nR)
		{
			if(left[i]<=right[j])
			{
				array[k]=left[i];
				i++;
                k++;
                this.count++;
			}
			else
			{
				array[k]=right[j];
				j++;
                k++;
                this.count++;
			}
		}
		while(i<nL)
		{
			array[k]=left[i];
			i++;
            k++;
            this.count++;
		}
		while(j<nR)
		{
			array[k]=right[j];
			j++;
            k++;
            this.count++;
		}
	}

    public long getUseMemory(){
        return this.useMemory;
    }
    public long getTime(){
        return this.times;
    }
    public int getCount(){
        return this.count;
    }
}