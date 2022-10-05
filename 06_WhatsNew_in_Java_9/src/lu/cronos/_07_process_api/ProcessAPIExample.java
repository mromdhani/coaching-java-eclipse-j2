package lu.cronos._07_process_api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProcessAPIExample {

	public static void main(String[] args) {

		try {

			// Getting the Current Process handle
			ProcessHandle currentProcessHandleImpl = ProcessHandle.current();

			// Get process Id of current native process
			System.out.println("Native process ID of the process: " + currentProcessHandleImpl.pid());

			System.out.println("\nIs process alive: " + currentProcessHandleImpl.isAlive());
			// Parent of the process
			System.out.println("\nProcess's parent " + currentProcessHandleImpl.parent());
			// Direct children of the process
			System.out.println("\nNombre of Direct children: " + currentProcessHandleImpl.children().count());

			// Process snapshot of the current running process with ProcessHandle.Info:
			ProcessHandle.Info processInfo = currentProcessHandleImpl.info();

			System.out.println("\nProcess snapshot of the current running process:");
			System.out.println("User : " + processInfo.user().get());
			System.out.println("Start Time : " + processInfo.startInstant().get());

			// Starting a Child process 			
			ProcessBuilder pb = new ProcessBuilder("notepad.exe");
			Process process = pb.start();	
			
			// Triggering action on Process Termination			
			ProcessHandle processHandle  = process.toHandle();
			CompletableFuture<ProcessHandle> onProcessExit = processHandle.onExit();
			onProcessExit.thenAccept(ph -> { System.out.printf("PID: %d has stopped.", ph.pid());});
			onProcessExit.get();  // Wait for the future to complete
		} catch (IOException  | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

}
