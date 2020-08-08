package sort.bubble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class bubbleSort4 extends JComponent implements Runnable{
	
	static JFrame frame = new JFrame("Sorting");
	static ArrayList<Double> data= new ArrayList<Double>();
	
	public static void main(String args[]) {
		for(int i=0;i<7000;i++) {
			data.add(i, 375.00*(new Random()).nextDouble());
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,800,800);
		frame.getContentPane().add(new bubbleSort4());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
	}
	double scale=1;
	int ptr1=data.size(),ptr2=-1,Times=60000;
	long comparisions=0;
	
	public void paint(Graphics g)
	{
		scale=1 + 0.001402*(Math.sqrt(frame.getWidth()*frame.getWidth() + frame.getHeight()*frame.getHeight()) - 2*565)/2.00000;
		Graphics2D g2D = (Graphics2D) g;
		g2D.translate(frame.getWidth()/2, frame.getHeight()/2);		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
    	g2D.setRenderingHints(rh);
    	scale=1 + 0.001402*(Math.sqrt(frame.getWidth()*frame.getWidth() + frame.getHeight()*frame.getHeight()) - 2*565)/2.00000;
    	g2D.scale(scale, scale);
		//g2D.setColor(Color.WHITE);
    	//g2D.fill(new Ellipse2D.Double(0-25, 0-25, 50, 50));
		g2D.setStroke(new BasicStroke(1));
		for(int i=0;i<data.size();i++) {
			if(i==ptr2||i==ptr2+1) {
				//g2D.setColor(Color.RED);
			}
			if(ptr1<=0) {
				//3run();
				//g2D.setColor(Color.GREEN);
			}
			g2D.setColor(Color.getHSBColor((float) ((Float.parseFloat(data.get(i).toString()))/375.00), (float)1, (float)1));
			g2D.draw(new Line2D.Double(0,0,300.00*Math.cos(2*3.15159265/(double)(data.size()+1)*i),300.00*Math.sin(2*3.15159265/(double)(data.size()+1)*i)));
			//g2D.setColor(Color.WHITE);
		}
		if(ptr1>=0) {
			for(int time=0;time<Times;time++)//sortTimesItem
				sort1Item();
			comparisions += Times;
		}
//		g2D.setColor(Color.BLACK);
//		g2D.fill(new Ellipse2D.Double(0-150, 0-150, 300, 300));
		g2D.setColor(Color.WHITE);
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g2D.drawString("Bubble Sort",(float) ((-frame.getWidth()/2+10)/scale),(float) ((-frame.getHeight()/2+40)/scale));
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g2D.setColor(Color.RED);
		g2D.drawString("Comparisions: "+comparisions/1000.00+"K", (float) ((-frame.getWidth()/2+10)/scale), (float) ((-frame.getHeight()/2+70)/scale));
		run();
		//repaint();
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
