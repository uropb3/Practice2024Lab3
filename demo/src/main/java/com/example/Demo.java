package com.example;

public class Demo {
    public void run() {
        RingBuffer<Integer> buffer = new RingBufferImpl<Integer>(2);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.poll();

        for (var n : buffer) {
            System.out.println(n);
        }
    }
}