package com.sucheol;
import java.util.Random;

/**
 * 파일명 : C/C++ IoT 과제
 * 프로그램 설명 : 시간 측정 단위와 멤버교체 횟수 그리고, +알파(자신만의 성능평가척도)를 기준으로 작성한
 * 정렬 성능 평가 프로그램
 * +알파는 메모리 사용량을 측정하여 공간 복잡도를 측정하였다.
 * 작성자 : 2012110014 정수철
 * 정렬에 사용된 코드는 https://github.com/akshaybahadur21/Sort.git에서 사용하였다.
 * 제가 만든 코드는 메모리 측정, 정렬 실행을 위한 코드, 정렬별 랭킹 출력,
 * 정렬을 해당 프로그램에서 사용하기위한 약간의 수정, 성능평가를 하였습니다.
 */

public class test{
    private long sumTime, sumMemory;
    private int sumCount;
    private String name;

    public test(String name){
        sumMemory = 0L;
        sumTime = 0L;
        this.name = name;
    }
    public static void main(String[] args){
        int testCase = 5;
        test[] sort = new test[5];
        test t;
        System.out.println("test\n");
        t = new test("test");
        t.seletionSort(t, 1);
        
        sort[0] = new test("선택정렬");
        sort[1] = new test("삽입정렬");
        sort[2] = new test("버블정렬");
        sort[3] = new test("병합정렬");
        sort[4] = new test("퀵정렬");

        System.out.println("\n\n선택정렬\n");
        sort[0].seletionSort(sort[0], testCase);
        sort[0].printAnswer(sort[0], testCase);

        System.out.println("\n\n삽입정렬\n");
        sort[1].bubbleSort(sort[1], testCase);
        sort[1].printAnswer(sort[1], testCase);

        System.out.println("\n\n버블정렬\n");
        sort[2].bubbleSort(sort[2], testCase);
        sort[2].printAnswer(sort[2], testCase);

        System.out.println("\n\n병합정렬\n");
        sort[3].mergeSort(sort[3], testCase);
        sort[3].printAnswer(sort[3], testCase);

        System.out.println("\n\n퀵정렬\n");
        sort[4].mergeSort(sort[4], testCase);
        sort[4].printAnswer(sort[4], testCase);


        System.out.println("\n");
        t.timeRank(sort);
        t.countRank(sort);
        t.memoryRank(sort);
    }

    public void timeRank(test t[]){
        for(int i=0, j=i+1, min=i; i<t.length-1; ){
            if(j<t.length){
                min = t[min].getTime()>t[j].getTime()?j:min;
                j++;
            }
            else{
                if(min!=i){
                    test temp = t[min];
                    t[min] = t[i];
                    t[i] = temp;
                }
                i++;
                j = i+1;
                min = i;
            }
        }
        System.out.println("시간별 순서");
        for(int i =0; i<t.length; i++){
            System.out.print(t[i].getName());
            if(i<t.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
    public void countRank(test t[]){
        for(int i=0, j=i+1, min=i; i<t.length-1; ){
            if(j<t.length){
                min = t[min].getCount()>t[j].getCount()?j:min;
                j++;
            }
            else{
                if(min!=i){
                    test temp = t[min];
                    t[min] = t[i];
                    t[i] = temp;
                }
                i++;
                j = i+1;
                min = i;
            }
        }
        System.out.println("교체가 적은 순서");
        for(int i =0; i<t.length; i++){
            System.out.print(t[i].getName());
            if(i<t.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
    public void memoryRank(test t[]){
        for(int i=0, j=i+1, min=i; i<t.length-1; ){
            if(j<t.length){
                min = t[min].getMemory()>t[j].getMemory()?j:min;
                j++;
            }
            else{
                if(min!=i){
                    test temp = t[min];
                    t[min] = t[i];
                    t[i] = temp;
                }
                i++;
                j = i+1;
                min = i;
            }
        }
        System.out.println("적은 메모리 시용량 순서");
        for(int i =0; i<t.length; i++){
            System.out.print(t[i].getName());
            if(i<t.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("");
    }

    public void printAnswer(test t, int testCase){
        System.out.println("평균 : "+(t.sumTime/(double)testCase)+"ms, "+(t.sumMemory/(double)testCase)+"byte, "+(t.sumCount/testCase)+"번 교체");
    }

    private int[] makeArray() {
        int[] arr = new int[10000];
        for(int i =0;i<10000;i++){
            arr[i] = i+1;
        }
        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);

        for(int i =0;i<10000;i++){
            int tmp, idx;
            idx = rand.nextInt(10000);
            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
    public void bubbleSort(test t, int testCase){
        long memory, time;
        int count;
        BubbleSort sort;
        for(int i = 0; i<testCase; i++){
            System.gc();
            long tmp = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            sort = new BubbleSort(t.makeArray());
            sort.Sort();
            time = sort.getTime();
            memory = Math.abs(tmp-sort.getUseMemory());
            count = sort.getCount();
            System.out.println((i+1)+". 교체횟수 : "+count+"번, 실행시간 : "+time+"ms, 사용된 메모리 : "+memory+"byte");
            t.sumMemory += memory;
            t.sumTime += time;
            t.sumCount += count;
        }
    }
    public void seletionSort(test t, int testCase){
        long memory, time;
        int count;
        SelectionSort sort;
        for(int i = 0; i<testCase; i++){
            System.gc();
            long tmp = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            sort = new SelectionSort(t.makeArray());
            sort.Sort();
            time = sort.getTime();
            memory = Math.abs(tmp-sort.getUseMemory());
            count = sort.getCount();
            System.out.println((i+1)+". 교체횟수 : "+count+"번, 실행시간 : "+time+"ms, 사용된 메모리 : "+memory+"byte");
            t.sumMemory += memory;
            t.sumTime += time;
            t.sumCount += count;
        }
    }
    public void insertionSort(test t, int testCase){
        long memory, time;
        int count;
        InsertionSort sort;
        for(int i = 0; i<testCase; i++){
            System.gc();
            long tmp = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            sort = new InsertionSort(t.makeArray());
            sort.Sort();
            time = sort.getTime();
            memory = Math.abs(tmp-sort.getUseMemory());
            count = sort.getCount();
            System.out.println((i+1)+". 교체횟수 : "+count+"번, 실행시간 : "+time+"ms, 사용된 메모리 : "+memory+"byte");
            t.sumMemory += memory;
            t.sumTime += time;
            t.sumCount += count;
        }
    }
    public void mergeSort(test t, int testCase){
        long memory, time;
        int count;
        MergeSort sort;
        for(int i = 0; i<testCase; i++){
            System.gc();
            long tmp = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            sort = new MergeSort(t.makeArray());
            sort.Sort();
            time = sort.getTime();
            memory = Math.abs(tmp-sort.getUseMemory());
            count = sort.getCount();
            System.out.println((i+1)+". 교체횟수 : "+count+"번, 실행시간 : "+time+"ms, 사용된 메모리 : "+memory+"byte");
            t.sumMemory += memory;
            t.sumTime += time;
            t.sumCount += count;
        }
    }
    public void quickSort(test t, int testCase){
        long memory, time;
        int count;
        QuickSort sort;
        for(int i = 0; i<testCase; i++){
            System.gc();
            long tmp = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            sort = new QuickSort(t.makeArray());
            sort.Sort();
            time = sort.getTime();
            memory = Math.abs(tmp-sort.getUseMemory());
            count = sort.getCount();
            System.out.println((i+1)+". 교체횟수 : "+count+"번, 실행시간 : "+time+"ms, 사용된 메모리 : "+memory+"byte");
            t.sumMemory += memory;
            t.sumTime += time;
            t.sumCount += count;
        }
    }


    public long getTime(){
        return this.sumTime;
    }
    public int getCount(){
        return this.sumCount;
    }
    public long getMemory(){
        return this.sumMemory;
    }
    public String getName(){
        return this.name;
    }
}