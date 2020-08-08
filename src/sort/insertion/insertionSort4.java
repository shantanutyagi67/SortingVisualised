package sort.insertion;

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


public class insertionSort4 extends JComponent implements Runnable{
	
	static JFrame frame = new JFrame("Sorting");
	static ArrayList<Double> data= new ArrayList<Double>();
	
	public static void main(String args[]) {
		for(int i=0;i<1000;i++) {
			data.add(i, 375.00*(new Random()).nextDouble());
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,800,800);
		frame.getContentPane().add(new insertionSort4());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
	}
	
	int ptr1=0,ptr2=1,Times=500,cnt=0;;
	long comparisions=0;
	
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.translate(frame.getWidth()/2, frame.getHeight()/2);		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
    	g2D.setRenderingHints(rh);
		//g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(1));
		for(int i=0;i<data.size();i++) {
			if(i==ptr1||i==ptr2) {
				//g2D.setColor(Color.RED);
			}
			if(ptr2>=data.size()) {
				//3run();
				//g2D.setColor(Color.GREEN);
			}
			g2D.setColor(Color.getHSBColor((float) ((Float.parseFloat(data.get(i).toString()))/375.00), (float)1, (float)1));
			g2D.draw(new Line2D.Double(0,0,300*Math.cos(2*3.15159265/data.size()*i),300*Math.sin(2*3.15159265/data.size()*i)));
		}
		if(ptr2<data.size()) {
			for(int time=0;time<Times;time++) {//sortTimesItem
				ptr1=ptr2-cnt;
				cnt++;
				sort1Item();
			}
			comparisions += Times;
		}
		g2D.setColor(Color.WHITE);
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g2D.drawString("Insertion Sort", -390, -360);
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g2D.setColor(Color.RED);
		g2D.drawString("Comparisions: "+comparisions/1000.00+"K", -390, -340);
		//run();
		repaint();
	}
	
	private void sort1Item() {
		ptr1--;
		if(ptr1<0) {
			ptr2++;
			ptr1=ptr2-1;
			cnt=1;
		}
		if(ptr1>=0&&ptr1+1<data.size()&&data.get(ptr1+1)<data.get(ptr1)) {
			Collections.swap(data, ptr1, ptr1+1);
		}
		else if(ptr1>=0&&ptr1+1<data.size()&&data.get(ptr1+1)>data.get(ptr1)) {
			ptr2++;
			ptr1=ptr2;
			cnt=0;
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
