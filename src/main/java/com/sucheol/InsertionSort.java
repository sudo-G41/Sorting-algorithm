package com.sucheol;

public class InsertionSort{
    private long start; 
    private long end;
    private int[] array;
    private int count;
    private long startMemory,endMemory;
    private long times, useMemory;

    public InsertionSort(){

    }
    public InsertionSort(int[] array){
        this.array = array;
    }
    public void Sort(){
        boolean alreadySorted = true;
        this.count = 0;
        this.start = System.currentTimeMillis();
        for(int i = 1;i<this.array.length;i++){
            int j = i-1;
            int insert = array[i];
            while(j>-1&&array[j]>insert){
                array[j+1] = array[j];
                j--;
                this.count++;
            }
            array[j+1] = insert;
        }
        this.end = System.currentTimeMillis();
        this.times = this.end-this.start;
        this.endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.useMemory = endMemory;
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