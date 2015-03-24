package animation;

import javax.media.opengl.glu.GLU;

public class Camera {
	
	public static final double VIEW_RANGE = 2;
	
	public static final int LOOK_LEFT = 37;
	
	public static final int LOOK_RIGHT = 39;
	
	public static final int LOOK_UP = 38;
	
	public static final int LOOK_DOWN = 40;
	
	private double posX;
	
	private double posY;
	
	private double posZ;
	
	private double viewX;
	
	private double viewY;
	
	private double viewZ;
	
	private double horisontalAngle;
	
	private double verticalAngle;
	
	public Camera(double posX, double posY, double posZ, 
			double hAngle, double vAngle){
		
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.horisontalAngle = hAngle;
		this.verticalAngle = vAngle;
		this.correctView();
		
	}
	
	public void setCamera(GLU glu){
		glu.gluLookAt(this.posX, this.posY, this.posZ, 
				this.posX+this.viewX, this.posY +this.viewY, 
				this.posZ + this.viewZ, 
				0, 1, 0);
	}
	
	public void correctView(){
		double correctViewRange = 0;
		
		this.viewY = VIEW_RANGE * Math.sin(
				this.verticalAngle*(Math.PI/180));
		correctViewRange = VIEW_RANGE * Math.cos(
				this.verticalAngle*(Math.PI/180));
		
		this.viewX = correctViewRange * Math.cos(
				this.horisontalAngle*(Math.PI/180));
		this.viewZ = correctViewRange * Math.sin(
				this.horisontalAngle*(Math.PI/180));
	}

	public double getHorisontalAngle() {
		return horisontalAngle;
	}
	
	public double getVerticalAngle() {
		return verticalAngle;
	}

	public void setHorisontalAngle(double angle) {
		if(angle < 0){
			angle +=360;
		}
		if(angle > 360){
			angle -= 360;
		}
		this.horisontalAngle = angle;
	}
	
	public void setVerticalAngle(double angle) {
		if(angle > 89){
			angle=89;
		}
		if(angle < -89){
			angle = -89;
		}
		this.verticalAngle = angle;
	}
	
	public void acceptKey(int input){
		
		switch(input){
		case LOOK_LEFT:
			this.setHorisontalAngle(this.getHorisontalAngle() -1);
			break;
		case LOOK_RIGHT:
			this.setHorisontalAngle(this.getHorisontalAngle() +1);
			break;
		case LOOK_UP:
			this.setVerticalAngle(this.getVerticalAngle() + 1);
			break;
		case LOOK_DOWN:
			this.setVerticalAngle(this.getVerticalAngle() -1);
			break;
		}
		this.correctView();
	}
	
	
}
