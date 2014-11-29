package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {
public static void main(String[] args) {
	ExecutorService exes=Executors.newCachedThreadPool(new HandlerThreadFactory());
	exes.execute(new ExceptionThread2());
	exes.shutdown();
}
}
