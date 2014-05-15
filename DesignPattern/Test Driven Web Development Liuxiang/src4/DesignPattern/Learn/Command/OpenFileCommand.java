package DesignPattern.Learn.Command;

public class OpenFileCommand implements ICommand {

	private IFileSystemReceiver ifileSystem;

	public OpenFileCommand(IFileSystemReceiver ifileSystemReceiver) {
		this.ifileSystem = ifileSystemReceiver;
	}

	public void execute() {
		// open command is forwarding request to openFile method
		this.ifileSystem.openFile();
	}

}
