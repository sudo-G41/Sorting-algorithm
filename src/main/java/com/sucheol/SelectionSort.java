package com.sucheol;

public class SelectionSort{
    private long start; 
    private long end;
    private int[] array;
    private int count;
    private long startMemory,endMemory;
    private long times, useMemory;
    public SelectionSort(){
    }
    public SelectionSort(int[] array){
        this.array = array;
    }
    public void Sort(){
        boolean alreadySorted = true;
        this.count = 0;
        this.start = System.currentTimeMillis();
        for(int i = 0;i<this.array.length-1;i++){
            int min = i;
            for(int j = i+1; j<this.array.length; j++){
                min = this.array[min]>this.array[j]?j:min;
            }
            if(min!=i){
                int temp = this.array[min];
                this.array[min] = this.array[i];
                this.array[i] = temp;
                this.count++;
            }
        }
        this.end = System.currentTimeMillis();
        this.times = this.end-this.start;
        this.endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.useMemory = endMemory;
        // for(int val : array){
        //     System.out.print(val+", ");
        // }
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