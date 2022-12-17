import java.util.ArrayList;
import java.util.Collections;

class Test extends Thread {

    static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    static ArrayList<Integer> evenList = new ArrayList<Integer>();
    static ArrayList<Integer> oddList = new ArrayList<Integer>();
    static ArrayList<Integer> mergeList = new ArrayList<Integer>();
    static boolean[] flag = { true, true };

    public static void main(String[] args) {
        try {
            Test t1 = new Test();
            Test t2 = new Test();
            Test t3 = new Test();
            t1.start();
            t2.start();
            while (flag[0] || flag[1]);
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
            flag[0] = false;

        } else if (Thread.currentThread().getName().equals("Thread-1")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    oddList.add(arr[i]);
                }

            }
            Collections.sort(oddList);
            flag[1] = false;

        } else if (Thread.currentThread().getName().equals("Thread-2")) {
            try {

                mergeList.addAll(evenList);
                mergeList.addAll(oddList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
