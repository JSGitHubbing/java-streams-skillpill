package com.skillpill.streams;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class DynamicStream {

	public static void main(String[] args) {
		// My queue
		BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(10);

		// A Stream of it's contents.
		Stream<BigInteger> biStream = Stream.generate(() -> {
			try {
				return queue.take();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		// Thread that adds elements to the queue
		addDataToQueue(queue);

		// DEMO - Consumes the queue printing contents as they arrive.
		biStream.filter(x -> x.mod(BigInteger.TWO) == BigInteger.ZERO).limit(20).forEach(x -> System.out.println(x));

		System.out.print("END OF STREAM");

	}

	private static void addDataToQueue(BlockingQueue<BigInteger> queue) {
		new Thread(new Runnable() {
			final AtomicInteger i = new AtomicInteger();

			@Override
			public void run() {
				while (true) {
					// Add a new number to the queue.
					if (queue.remainingCapacity() > 0) {
						queue.add(BigInteger.valueOf(i.getAndIncrement()));
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}
}
