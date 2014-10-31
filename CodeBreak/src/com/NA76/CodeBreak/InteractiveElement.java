package com.NA76.CodeBreak;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class InteractiveElement {
	private AtlasRegion Texture;
	private float Width;
	private float Height;
	private float DownBorder;
	private float UpBorder;
	private float LeftBorder;
	private float RightBorder;
	private float XStartPosition;
	private float YStartPosition;

	public void setTexture(AtlasRegion texture){
		Texture = texture;
	}
	
	public AtlasRegion getTexture(){
		return Texture;
	}
	
 	public void setWidth(float width){
		Width=width;
	}
	
	public float getWidth(){
		return Width;
	}
	
	public void setHeight(float height){
		Height = height;
	}
	
	public float getHeight(){
		return Height;
	}
	
	public void setDownBorder(float downborder){
		DownBorder = downborder;
	}
	
	public float getDownBorder(){
		return DownBorder;
	}
	
	public void setUpBorder(float upborder){
		UpBorder = upborder;
	}
	
	public float getUpBorder(){
		return UpBorder;
	}
	
	public void setLeftBorder(float leftborder){
		LeftBorder = leftborder;
	}
	
	public float getLeftBorder(){
		return LeftBorder;
	}
	
	public void setRightBorder(float rightborder){
		RightBorder = rightborder;
	}
	
	public float getRightBorder(){
		return RightBorder;
	}
	
	public void setXPosition (float xstartposition){
		XStartPosition = xstartposition;
	}
	
	public float getXStartPosition(){
		return XStartPosition;
	}
	
	public void setYPosition (float ystartposition){
		YStartPosition = ystartposition;
	}
	
	public float getYStartPosition(){
		return YStartPosition;
	}
	
	public void setBorders(float left, float right, float down, float up){
		LeftBorder = left;
		RightBorder = right;
		DownBorder = down;
		UpBorder = up;
	}
	
	public void setProperties(float width, float height, float xposition, float yposition){
		Width = width;
		Height = height;
		XStartPosition = xposition;
		YStartPosition = yposition;
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(Texture, XStartPosition, YStartPosition, Width, Height);
	}
	
	public BoundingBox getBounds(){
		BoundingBox Bounds;
		float BoundXStartPosition;
		float BoundYStartPosition;
		float BoundXEndPosition;
		float BoundYEndPosition;
		Vector3 StartBound;
		Vector3 EndBound;
		BoundXStartPosition = XStartPosition + LeftBorder;
		BoundYStartPosition = YStartPosition + DownBorder;
		BoundXEndPosition = XStartPosition + Width - RightBorder;
		BoundYEndPosition = YStartPosition + Height - UpBorder;
		StartBound = new Vector3(BoundXStartPosition, BoundYStartPosition,0);
		EndBound = new Vector3(BoundXEndPosition,BoundYEndPosition,0);
		Bounds = new BoundingBox (StartBound,EndBound);
		return Bounds;
	}
	
	
	
	
}
