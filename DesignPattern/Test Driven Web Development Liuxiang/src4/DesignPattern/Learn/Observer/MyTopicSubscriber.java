package DesignPattern.Learn.Observer;

public class MyTopicSubscriber implements IObserver {
    
    private String name;
    private ISubject topic;
     
    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);
    }
 
   
    public void setSubject(ISubject sub) {
        this.topic=sub;
    }
 
}