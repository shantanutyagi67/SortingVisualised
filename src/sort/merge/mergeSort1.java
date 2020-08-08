package sort.merge;

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


public class mergeSort1 extends JComponent implements Runnable{
	
	static JFrame frame = new JFrame("Sorting");
	static ArrayList<Double> array= new ArrayList<Double>();
	boolean sort = true;
//	int ptr1=0,ptr2=0,Times=500;
//	long comparisions=0;
	
	private void display(ArrayList<Double> array2, int len, Graphics2D g2D) {
		for(int i=0;i<array.size();i++) {
			g2D.draw(new Line2D.Double((i+3),745,(i+3),745-array.get(i)));
		}
		repaint();
//		for(int i=0;i<len;i++)
//			System.out.print(array2.get(i)+" ");
//		System.out.println();
	}
	
	private void mergesort(ArrayList<Double> array2, int l, int r, Graphics2D g2D) {
		if(l<r) {
			int m = l + ( r - l ) / 2;
			//display(array,array.size(),g2D);
			mergesort(array2,l,m,g2D);
			//display(array,array.size(),g2D);
			mergesort(array2,m+1,r,g2D);
			//display(array,array.size(),g2D);
			merge(array2,l,m,r,g2D);
			//display(array,array.size(),g2D);
			//run();
		}
	}
	
	private void merge(ArrayList<Double> array2, int l, int m, int r, Graphics2D g2D) {
		//display(array,array.size(),g2D);
		int i,j,k;
		double L[] = new double[m-l+1];
		double R[] = new double[r-m-1+1];
		for (i = 0; i < m-l+1; i++) 
	        L[i] = array2.get(l + i); 
	    for (j = 0; j < r-m; j++) 
	        R[j] = array2.get(m + 1+ j); 
	    i=0;
	    j=0;
	    k=l;
	    //loop control
	    while(i<m-l+1&&j<r-m) {
	    	//display(array,array.size(),g2D);
	    	if(L[i]<=R[j]) {
	    		array2.set(k, L[i]);
	    		i++;
	    	}
	    	else {
	    		array2.set(k, R[j]);
	    		j++;
	    	}
	    	k++;
	    }
	    display(array,array.size(),g2D);
	    while(i<m-l+1) {
	    	//display(array,array.size(),g2D);
	    	 array2.set(k, L[i]); 
	         i++; 
	         k++;
	    }
	    display(array,array.size(),g2D);
	    while(j<r-m) {
	    	//display(array,array.size(),g2D);
	    	 array2.set(k, R[j]); 
	         j++; 
	         k++;
	    }
	    display(array,array.size(),g2D);
	}
	
	public static void main(String args[]) {
		for(int i=0;i<500;i++) {
			array.add(i, 5+700.0*(new Random()).nextDouble());
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,1600,800);
		frame.getContentPane().add(new mergeSort1());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
//		mergesort(array, 0, array.size()-1);
		//display(array,array.size());
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		//g2D.translate(frame.getWidth()/2, frame.getHeight()/2);		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
    	g2D.setRenderingHints(rh);
		g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(1));
		mergesort(array, 0, array.size()-1,g2D);
		//display(array,array.size(),g2D);
		//display(array,array.size(),g2D);
//		for(int i=0;i<array.size();i++) {
////			if(i==ptr1||i==ptr2) {
////				g2D.setColor(Color.RED);
////			}
////			if(ptr1>array.size()-1) {
////				//3run();
////				g2D.setColor(Color.GREEN);
////			}
//			g2D.draw(new Line2D.Double((i+3),745,(i+3),745-array.get(i)));
//			//g2D.setColor(Color.WHITE);
//		}
		
//		if(ptr1<array.size()-1) {
//			for(int time=0;time<Times;time++)//sortTimesItem
//				sort1Item();
//			comparisions += Times;
//		}
//		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 30));
//		g2D.drawString("Selection Sort", 10, 40);
//		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 15));
//		g2D.setColor(Color.RED);
//		g2D.drawString("Comparisions: "+comparisions/1000.00+"K", 10, 60);
		//run();
		repaint();
	}
	
//	private void sort1Item() {
//		ptr2++;
//		if(ptr2==array.size()) {
//			ptr1++;
//			ptr2=ptr1;
//		}
//		if(ptr1<array.size()&&ptr2<array.size()&&array.get(ptr2)<array.get(ptr1)) {
//			Collections.swap(array, ptr1, ptr2);
//		}
//	}

	@Override
	public void run() {
		try {
			Thread.sleep(50);
			//repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
