package liuxiangwin.JavaObjectTrainningtest.TimerTask;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SimpleTimer {
	private final Timer timer = new Timer();

	private final int minutes;

	public SimpleTimer(int minutes) {
		// TODO Auto-generated constructor stub
		this.minutes = minutes;

	}
    
	public void PlaySound() {

		Toolkit.getDefaultToolkit().beep();
		Toolkit.getDefaultToolkit().beep();
		Toolkit.getDefaultToolkit().beep();
		System.out.println("One minus has passed");
		AudioPlayer p = AudioPlayer.player;

		try {
			//AudioStream stream = new AudioStream(new FileInputStream(
			//"04 Your Headstrong Ways.wav"));
			
			AudioStream stream = new AudioStream(new FileInputStream(
			"02.C'est la vie.wav"));
			
					//"Windows Startup.wav"));
			p.start(stream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Start() {
        //This  method is very important
		//To schedule a new annoynoumous  TimeTask and delay tim
		//The TimeTask is a abstract class ,it should overrid 
		//the run method put the you task int run  method.
		timer.schedule(new TimerTask() 
		{
			public void run() {
				System.out.println("==========This is run Methond=================");
				PlaySound();
				timer.cancel();
			}		
		},minutes*2);
		// },minutes*60*1000);

	}
	
	
		public static void main(String args[])
		{
			SimpleTimer simplerTimer=new SimpleTimer(1);
			simplerTimer.Start();
		}
}
