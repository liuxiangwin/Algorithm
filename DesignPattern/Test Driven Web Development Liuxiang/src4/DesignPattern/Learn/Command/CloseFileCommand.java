package DesignPattern.Learn.Command;

public class CloseFileCommand implements ICommand {
	 
    private IFileSystemReceiver fileSystem;
     
    public CloseFileCommand(IFileSystemReceiver fs){
        this.fileSystem=fs;
    }

	public void execute() {
		 this.fileSystem.closeFile();
		
	}  

}