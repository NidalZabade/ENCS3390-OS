import java.util.ArrayList;
import java.util.Collections;

class Test extends Thread {

    static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    static ArrayList<Integer> evenList = new ArrayList<Integer>();
    static ArrayList<Integer> oddList = new ArrayList<Integer>();
    static ArrayList<Integer> mergeList = new ArrayList<Integer>();


    public static void main(String[] args) {
        try {
            Test t1 = new Test();
            Test t2 = new Test();
            Test t3 = new Test();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            t3.start();

            System.out.println(evenList.toString());
            System.out.println(oddList.toString());
            System.out.println(mergeList.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    evenList.add(arr[i]);
                }
            }
            Collections.sort(evenList);
            

        } else if (Thread.currentThread().getName().equals("Thread-1")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    oddList.add(arr[i]);
                }
            
            }
            Collections.sort(oddList);
            

        } else if (Thread.currentThread().getName().equals("Thread-2")) {
            mergeList.addAll(evenList);
            mergeList.addAll(oddList);
            
            
        }
    }

}
