package DesignPattern.Learn.Command;

public class IFileSystemReceiverFactory {

	public static IFileSystemReceiver getUnderlyingFileSystem() {
		String osNameString = System.getProperty("os.name");
		
		System.out.println("Underlying OS is:" + osNameString);
		
		if (osNameString.contains("Windows")) {
			return new WindowsFileSystemReceiver();
		} else {
			return new UnixFileSystemReceiver();
		}
	}

}
