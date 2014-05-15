package DesignPattern.Learn.Command;

public class WindowsFileSystemReceiver implements IFileSystemReceiver {
	 
	
    public void openFile() {
        System.out.println("Opening file in Windows OS");
         
    }

    public void writeFile() {
        System.out.println("Writing file in Windows OS");
    }

    public void closeFile() {
        System.out.println("Closing file in Windows OS");
    }
 
}