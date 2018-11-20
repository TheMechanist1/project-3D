package com.Three.ThreeD.input;

public class Controller {
	public double x, y, z, rotation, xa, ya, za, rotationa;
	public static boolean turnleft = false;
	public static boolean turnright = false;
	public static boolean walk = false;
	public static boolean crouchWalk = false;
	public static boolean runWalk = false;
	public void tick(boolean forward, boolean back, boolean left, boolean right, boolean jump, boolean crouch, boolean sprint) {
		double rotationSpeed = 0.02;
		double jumpHeight = 0.5;
		double walkSpeed = 0.5;
		double xMove = 0;
		double zMove = 0;

		if (forward) {
			zMove++;
			walk = true;
		}

		if (back) {
			zMove--;
			walk = true;
		}

		if (left) {
			xMove--;
			walk = true;
		}

		if (right) {
			xMove++;
			walk = true;
		}
		if (jump) {
			y += jumpHeight;
			sprint = false;
		}
		
		if (crouch) {
			y -= jumpHeight - 0.2;
			walkSpeed = 0.2;
			sprint = false;
			crouchWalk = true;
		}
		
		if (forward & sprint) {
			zMove++;
			walkSpeed = 0.7;
			walk = true;
			runWalk = true;
		}
		
		if(!forward && !back && !left && !right) {
			walk = false;
		}
		
		if(!crouch) {
			crouchWalk = false;
		}
		
		if(!sprint) {
			runWalk = false;
		}
			

		if (turnleft) {
			rotationa -= rotationSpeed;
		}

		if (turnright) {
			rotationa += rotationSpeed;
		}

		xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
		za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;
		
		x += xa;
		y *= 0.9;
		z += za;
		xa *= 0.1;
		za *= 0.1;
		rotation += rotationa;
		rotationa *= 0.1;

	}
}
