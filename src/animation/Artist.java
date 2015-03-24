package animation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Artist implements GLEventListener, MouseListener, MouseMotionListener, KeyListener{
	
	private GLU glu;
	
	private double angle = 0;
	
	private Camera camera;
	
	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0.3f, 0.3f, 0.3f, 0.0f); 
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
		gl.glShadeModel(GL2.GL_SMOOTH);
		this.glu = new GLU();
		camera = new Camera(0, 0, 0,180 , 0);
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
	      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
	      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
	      gl.glLoadIdentity();  // reset the model-view matrix
	      
	      this.camera.setCamera(this.glu);
	      
	      gl.glColor3d(0, 1, 0);
	      this.drawRectangle(gl, -50, -2, -50, 50, 50);
	      gl.glColor3d(0, 0, 0);
	      
	      this.drawRectangle(gl, -10, -1.99, -50, 10, 50);
	      
	      gl.glTranslated(0, 0, -9);
	      this.angle++;
	      gl.glRotated(this.angle, 1, 0.7, 0.5);
	      gl.glColor3d(1, 0, 0);
	      
	      
	      this.drawCuboid(gl, -1, 1, 1, 1, -1, -1);
	      
	      
	      
	      gl.glBegin(GL2.GL_TRIANGLES);
	      
	      gl.glVertex3d(0, 0, 0);
	      gl.glVertex3d(0.5, 0, 0);
	      gl.glVertex3d(0.25, 0.5, 0);
	      
	      gl.glEnd();
		
	}
	
	private void drawRectangle(GL2 gl, double x1, double y1, double z1,
			double x2, double z2){
		
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y1, z1);
		
		gl.glEnd();
		
	}
	
	private void drawCuboid(GL2 gl, double x1, double y1, double z1,
			double x2, double y2, double z2){
		
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y1, z1);
		
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(x1, y2, z1);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y2, z1);
		
		gl.glColor3d(0, 0, 1);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x2, y1, z1);
		gl.glVertex3d(x2, y2, z1);
		gl.glVertex3d(x1, y2, z1);
		
		gl.glColor3d(1, 1, 0);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x1, y2, z2);
		
		gl.glColor3d(0, 1, 1);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x1, y2, z1);
		
		gl.glColor3d(1, 0, 1);
		gl.glVertex3d(x2, y1, z1);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y2, z1);
		
		gl.glEnd();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		GL2 gl = drawable.getGL().getGL2();
		
		if(height <= 0){
			height = 1;
		}
		
		double aspect = width / height;
		
		gl.glViewport(0, 0, width, height);
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		this.glu.gluPerspective(45.0, aspect, 0.1f, 100f);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		this.camera.acceptKey(arg0.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
