package com.codegym.thread.advaned;

public class YieldExample {
    /**

     Trong ví dụ này, chúng ta tạo ra hai luồng t1 và t2. Mỗi luồng chạy một vòng lặp với 5 lần lặp,
     in ra một chuỗi với tên của luồng và số thứ tự lặp. Trong vòng lặp, chúng ta sử dụng
     phương thức yield() để cho phép các luồng khác có thể chạy.
     Khi chúng ta chạy chương trình, ta sẽ thấy rằng các luồng sẽ chạy xen kẽ lẫn nhau
     thay vì chạy hoàn toàn riêng biệt. Khi một luồng gọi phương thức yield(),
     bộ lập lịch của hệ thống có thể chuyển bộ xử lý cho luồng khác để giúp tăng hiệu suất của hệ thống.
     */
    public static void main(String[] args) {
        // Tạo ra luồng thứ nhất
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });

        // Tạo ra luồng thứ hai
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });
        // Tạo ra luồng thứ hai
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 3 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });
        // Tạo ra luồng thứ hai
        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 4 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });

        // Khởi động hai luồng
        t4.start();
        t3.start();
        t2.start();
        t1.start();
    }
}