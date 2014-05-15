package DesignPattern.Learn.Command;

public class Client {

	public static void main(String args[]) {
		// Creating the receiver object
		IFileSystemReceiver fs = IFileSystemReceiverFactory
				.getUnderlyingFileSystem();

		// creating command and associating with receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);

		openFileCommand.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		
		writeFileCommand.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		

		closeFileCommand.execute();
	}
	
	
	

	private static void tirgerByFileInvoker() {
		// Creating the receiver object
		IFileSystemReceiver fs = IFileSystemReceiverFactory
				.getUnderlyingFileSystem();

		// creating command and associating with receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);

		/*
		 * // Creating invoker and associating with Command FileInvoker file =
		 * new FileInvoker(openFileCommand);
		 * 
		 * // perform action on invoker object file.execute();
		 */

		openFileCommand.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		/*
		 * file = new FileInvoker(writeFileCommand); file.execute();
		 */

		writeFileCommand.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		/*
		 * file = new FileInvoker(closeFileCommand); file.execute();
		 */

		closeFileCommand.execute();

	}
}