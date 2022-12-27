package Example.Thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
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
		
		// thread 강제 종료 버튼 생성
		JButton killbtn = new JButton("kill");
		c.add(killbtn);
		killbtn.addActionListener(e->{
			th.interrupt();
			killbtn.setEnabled(false);
		});
		setSize(300,180);
		setVisible(true);
		
		//Thread 시작 
		th.start();
		
	}
}

public class Timer {

	public static void main(String[] args) {
		new ThreadTimerEx();
		
		////// Thread 의 정보 출력 ///////
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		System.out.println("현재 스레드 이름 = " + name);
		System.out.println("현재 스레드 ID = " + id);
		System.out.println("현재 스레드 우선순위 값 = " + priority);
		System.out.println("현재 스레드 상태 = " + s);// TODO Auto-generated method stub
		
	}
	

}
