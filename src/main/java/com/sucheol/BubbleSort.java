package com.sucheol;

public class BubbleSort{

    private long start; 
    private long end;
    private int[] array;
    private int count;
    private long startMemory,endMemory;
    private long times, useMemory;
    public BubbleSort(){
    }
    public BubbleSort(int[] array){
        this.array = array;
    }
    public int[] Sort(int[] array){
        int temp;
        boolean alreadySorted = true;
        this.count = 0;
        // Runtime.getRuntime().gc();
        // this.startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    count++;
                    alreadySorted = false;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            if (alreadySorted == true){
                break;
            }
        }
        this.end = System.currentTimeMillis();
        Runtime.getRuntime().gc();
        this.endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.times = end-start;
        // this.useMemory =  startMemory - endMemory;
        this.useMemory = endMemory;
        System.out.println("교체 횟수 : "+count+", 실행시간 : "+(end-start)+"ms, 사용된 메모리 : "+useMemory+"byte");
        return array;
    }
    public int[] Sort(){
        int temp;
        boolean alreadySorted = true;
        this.count = 0;
        // Runtime.getRuntime().gc();
        // this.startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.start = System.currentTimeMillis();
        for (int i = 0; i < this.array.length; i++){
            for (int j = 0; j < this.array.length - 1; j++){
                if (this.array[j] > this.array[j + 1]){
                    count++;
                    alreadySorted = false;
                    temp = this.array[j + 1];
                    this.array[j + 1] = this.array[j];
                    this.array[j] = temp;
                }
            }
            if (alreadySorted == true){
                break;
            }
        }
        this.end = System.currentTimeMillis();
        this.endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.times = end-start;
        // this.useMemory = endMemory - startMemory;
        this.useMemory = endMemory;
        // System.out.println("교체 횟수 : "+count+", 실행시간 : "+(end-start)+"ms, 사용된 메모리 : "+(endMemory-startMemory)+"byte");
        return this.array;
    }

    public long getUseMemory(){
        return useMemory;
    }
    public long getTime(){
        return times;
    }
    public int getCount(){
        return this.count;
    }
}