package com.cap.day9.threads;

class RoomBookTask implements Runnable {

	Integer roomsBooked = 0;
	String str = "test";

	public void bookRooms() {
		synchronized (str) {
			for (int i = 0; i < 1000; i++) {
				roomsBooked = roomsBooked + 1;
			}
		}

	}

	@Override
	public void run() {
		this.bookRooms();
//		System.out.println("Room booked by :" + Thread.currentThread().getName());	
	}
}

public class ThreadDemo4 {

	public static void main(String[] args) throws InterruptedException {
		RoomBookTask runnable = new RoomBookTask();

		for (int i = 0; i < 10000; i++) {

			Thread t = new Thread(runnable);
			t.start();
		}
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(2000);
		System.out.println(runnable.roomsBooked);

	}

}
