package com.codegym.thread.advaned;

/**

 Phương thức join() chờ một thread chết. Nói cách khác, nó làm cho các thread đang chạy ngừng hoạt động
 cho đến khi luồng mà nó tham gia hoàn thành nhiệm vụ của nó.
 */
class TestJoinMethod1 extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
//                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i + " --- " + this.getName());
        }
    }
    public static void main(String args[]) throws InterruptedException {
        TestJoinMethod1 t1 = new TestJoinMethod1();
        t1.setName("t1");
        TestJoinMethod1 t2 = new TestJoinMethod1();
        t2.setName("t2");
        TestJoinMethod1 t3 = new TestJoinMethod1();
        t3.setName("t3");


        t2.start();
        t2.join();
        t1.start();
        t3.start();


    }
    /**
     1
     2
     3
     4
     5
     1
     1
     2
     2
     3
     3
     4
     4
     5
     5
     */
}