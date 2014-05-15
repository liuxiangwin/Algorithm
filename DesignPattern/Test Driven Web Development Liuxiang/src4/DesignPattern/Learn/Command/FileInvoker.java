package DesignPattern.Learn.Command;

public class FileInvoker {
	 
    public ICommand command;
     
    public FileInvoker(ICommand c){
        this.command=c;
    }
     
    public void execute(){
        this.command.execute();
    }
}