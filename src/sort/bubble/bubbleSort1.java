package sort.bubble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class bubbleSort1 extends JComponent implements Runnable{
	
	static JFrame frame = new JFrame("Sorting");
	static ArrayList<Double> data= new ArrayList<Double>();
	
	public static void main(String args[]) {
		for(int i=0;i<1570;i++) {
			data.add(i, 5+700.0*(new Random()).nextDouble());
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,1600,800);
		frame.getContentPane().add(new bubbleSort1());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
	}
	
	int ptr1=data.size(),ptr2=-1,Times=2000;
	long comparisions=0;
	
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		//g2D.translate(frame.getWidth()/2, frame.getHeight()/2);		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
    	g2D.setRenderingHints(rh);
		g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(1));
		for(int i=0;i<data.size();i++) {
			if(i==ptr2||i==ptr2+1) {
				g2D.setColor(Color.RED);
			}
			if(ptr1<=0) {
				//3run();
				g2D.setColor(Color.GREEN);
			}
			g2D.draw(new Line2D.Double((i+3),745,(i+3),745-data.get(i)));
			g2D.setColor(Color.WHITE);
		}
		if(ptr1>=0) {
			for(int time=0;time<Times;time++)//sortTimesItem
				sort1Item();
			comparisions += Times;
		}
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g2D.drawString("Bubble Sort", 10, 40);
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g2D.setColor(Color.RED);
		g2D.drawString("Comparisions: "+comparisions/1000.00+"K", 10, 60);
		//run();
		repaint();
	}
	
	private void sort1Item() {
		ptr2++;
		if(ptr2>=ptr1) {
			ptr1--;
			ptr2=0;
		}
		if(ptr1>0&&ptr2+1<data.size()&&data.get(ptr2+1)<data.get(ptr2)) {
			Collections.swap(data, ptr2+1, ptr2);
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(50);
			repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
