package DesignPattern.Learn.Command;

public class WriteFileCommand implements ICommand {
	 
    private IFileSystemReceiver ifileSystem;
     
    public WriteFileCommand(IFileSystemReceiver ifileSystemReceiver){
        this.ifileSystem=ifileSystemReceiver;
    }

    public void execute() {
        this.ifileSystem.writeFile();
    }
 
}
