package Example.Thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread{
	private JLabel timerLabel;
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
	
}
@SuppressWarnings("serial")
class ThreadTimerEx extends JFrame{
	public ThreadTimerEx() {
		setTitle("Thread Timer Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC,80));
		c.add(timerLabel);
		
		TimerThread  th = new TimerThread(timerLabel);
		
		setSize(300,180);
		setVisible(true);
		th.start();
		
	}
}
public class Timer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTimerEx();
	}
	

}
