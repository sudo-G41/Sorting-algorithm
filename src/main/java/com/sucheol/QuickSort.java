package com.sucheol;

public class QuickSort{
    private long start; 
    private long end;
    private int[] array;
    private int count;
    private long startMemory,endMemory;
    private long times, useMemory;
    public QuickSort(){
    }
    public QuickSort(int[] array){
        this.array = array;
    }
    public void Sort(){
        boolean alreadySorted = true;
        this.count = 0;
        this.start = System.currentTimeMillis();
        QuickSort(this.array, 0, this.array.length-1);
        this.end = System.currentTimeMillis();
        this.times = this.end-this.start;
        this.endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.useMemory = endMemory;
    }
    public void QuickSort(int array[],int start,int end){
		if(start<end){
            int pIndex=QuickPartition(array,start,end);
            QuickSort(array,start,pIndex-1);
            QuickSort(array,pIndex+1,end);
		}
		else
			return;
		
	}
    public int QuickPartition(int array[],int start,int end){
		int temp;
		int pivot=array[end];
		int pIndex=start;
		for(int i=start;i<end;i++){
			if(array[i]<=pivot){
                temp=array[i];
                array[i]=array[pIndex];
                array[pIndex]=temp;
                pIndex++;
                this.count++;
			}
		}
        temp=array[pIndex];
        array[pIndex]=array[end];
        array[end]=temp;
        this.count++;
        return pIndex;
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