package Pong;

import java.awt.Color;

public class Wall extends Block {
	//instance variables
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	//Constructors
	public Wall() {
		super();
	}
	
	public Wall(int l, int r, int t, int b) {
		super(l,t,r-l,b-t);
		setLeft(l);
		setRight(r);
		setTop(t);
		setBottom(b);
	}
	
	public Wall(int l, int r, int t, int b, Color c) {
		super(l,t,r-l,b-t,c);
		setLeft(l);
		setRight(r);
		setTop(t);
		setBottom(b);
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public int getTop() {
		return top;
	}

	public int getBottom() {
		return bottom;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}
	
	public String toString() {
		return left + "," + right + "," + top + "," + bottom;
	}

}
