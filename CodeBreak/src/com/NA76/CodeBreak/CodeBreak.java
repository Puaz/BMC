package com.NA76.CodeBreak;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class CodeBreak implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private float height;
	private float width;
	private float halfHeight;
	private float halfWidth;
	private Assets assetsManager;
	private int firstValue;
	private int secondValue;
	private int thirdValue;
	private int fourthValue;
	
	
	private int[] firstSpaceColor;
	private boolean[] firstSpaceIsEmpty;
	private int[] secondSpaceColor;
	private boolean[] secondSpaceIsEmpty;
	private int[] thirdSpaceColor;
	private boolean[] thirdSpaceIsEmpty;
	private int[] fourthSpaceColor;
	private boolean[] fourthSpaceIsEmpty;
	private int touchedColor;
	private static int blueId;
	private static int redId;
	private static int greenId;
	private static int purpleId;
	private static int yellowId;
	private static int whiteId;
	private boolean btnCheckIsVisible;
	private boolean winnerMessageIsVisible;
	private boolean LoserMessageIsVisible;
	private boolean helpMessageIsVisible;
	private int round;
	private boolean codeIsCorrect;
	private int[] fullHits;
	private int[] halfHits;
	private boolean[] hitsList;
	private ArrayList <Integer> halfHitsList;
	
	
	
	@Override
	public void create() {
		height = 800;
		halfHeight = height/2;
		width = 480;
		halfWidth = width/2;
		assetsManager = new Assets();		
		batch = new SpriteBatch();
		btnCheckIsVisible = false;
		winnerMessageIsVisible = false;
		LoserMessageIsVisible = false;
		helpMessageIsVisible = false;
		firstSpaceIsEmpty = new boolean[]{true,true,true,true,true,true,true,true,true};
		secondSpaceIsEmpty = new boolean[]{true,true,true,true,true,true,true,true,true};
		thirdSpaceIsEmpty = new boolean[]{true,true,true,true,true,true,true,true,true};
		fourthSpaceIsEmpty = new boolean[]{true,true,true,true,true,true,true,true,true};
		firstSpaceColor = new int [9];
		secondSpaceColor = new int [9];
		thirdSpaceColor = new int [9];
		fourthSpaceColor = new int [9];
		fullHits = new int[9];
		halfHits = new int[9];
		round = 1;
		blueId=1;
		redId=2;
		greenId=3;
		purpleId=4;
		yellowId=5;
		whiteId=6;
		codeIsCorrect = false;
		hitsList = new boolean[]{false,false,false,false};
		halfHitsList = new ArrayList <Integer> ();
		
		firstValue = getRandom();
		secondValue = getRandom();
		thirdValue = getRandom();
		fourthValue = getRandom();
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		assetsManager.dispose();
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera = new OrthographicCamera(width, height);
		
		Vector3 touchPoint;
		touchPoint = new Vector3();
		BoundingBox blueBound;
		BoundingBox redBound;
		BoundingBox greenBound;
		BoundingBox purpleBound;
		BoundingBox yellowBound;
		BoundingBox whiteBound;
		BoundingBox firstSpaceBound = new BoundingBox();
		BoundingBox secondSpaceBound = new BoundingBox();
		BoundingBox thirdSpaceBound = new BoundingBox();
		BoundingBox fourthSpaceBound = new BoundingBox();
		BoundingBox btnCheckBound = new BoundingBox();
		BoundingBox btnTryAgainBound = new BoundingBox();
		BoundingBox helpBound = new BoundingBox();
		BoundingBox closeHelpBound = new BoundingBox();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		batch.draw(assetsManager.background, -width/2, -height/2, width, height);
		batch.draw(assetsManager.help, halfWidth - 50, halfHeight -50, 34, 34);
		helpBound = new BoundingBox(new Vector3 (halfWidth -48, halfHeight - 48,0), new Vector3( halfWidth -18, halfHeight-18,0));
		
		//
		
		batch.draw(assetsManager.Blue, -halfWidth + 27f,-halfHeight + 29f, 75, 75);
		blueBound = new BoundingBox(new Vector3(-halfWidth + 33f,-halfHeight + 30f,0), new Vector3(-halfWidth + 93,-halfHeight + 90,0));
		
		batch.draw(assetsManager.Red, -halfWidth + 98f,-halfHeight + 29f, 75, 75);
		redBound = new BoundingBox(new Vector3(-halfWidth + 104f,-halfHeight + 30f,0), new Vector3(-halfWidth + 164,-halfHeight + 90,0));
		
		batch.draw(assetsManager.Green, -halfWidth + 169f,-halfHeight + 29f, 75, 75);
		greenBound = new BoundingBox(new Vector3(-halfWidth + 175f,-halfHeight + 30f,0), new Vector3(-halfWidth + 235,-halfHeight + 90,0));
		
		batch.draw(assetsManager.Purple, -halfWidth + 240f,-halfHeight + 29f, 75, 75);
		purpleBound = new BoundingBox(new Vector3(-halfWidth + 246f,-halfHeight + 30f,0), new Vector3(-halfWidth + 306,-halfHeight + 90,0));
		
		batch.draw(assetsManager.Yellow, -halfWidth + 311f,-halfHeight + 29f, 75, 75);
		yellowBound = new BoundingBox(new Vector3(-halfWidth + 317f,-halfHeight + 30f,0), new Vector3(-halfWidth + 377,-halfHeight + 90,0));
		
		batch.draw(assetsManager.White, -halfWidth + 382f,-halfHeight + 27f, 75, 75);
		whiteBound = new BoundingBox(new Vector3(-halfWidth + 388f,-halfHeight + 30f,0), new Vector3(-halfWidth + 448,-halfHeight + 90,0));
		
		
		
		if (!firstSpaceIsEmpty[0]){
			firstSpaceBound = assignBounds(1, round); 
			drawSpaces(1, firstSpaceColor, round);			
		}		
		
		
		if (!secondSpaceIsEmpty[0]){
			secondSpaceBound = assignBounds(2, round);
			drawSpaces(2, secondSpaceColor, round);
		}		
		
		
		if (!thirdSpaceIsEmpty[0]){
			thirdSpaceBound = assignBounds(3, round);
			drawSpaces(3, thirdSpaceColor, round);
		}		
		
		
		if (!fourthSpaceIsEmpty[0]){
			fourthSpaceBound = assignBounds(4, round);
			drawSpaces(4, fourthSpaceColor, round);					
		}
		
		if (round>1){
			drawHits(fullHits,halfHits,round,1);
		}
		
//		 
		if (btnCheckIsVisible){
			btnCheckBound = assignBoundCheck(round);
			drawBtnCheck(round);			
		}
		
		if (winnerMessageIsVisible){
			batch.draw(assetsManager.winnerMessage, -200,-70, 400, 140);
		} else {
			if (LoserMessageIsVisible){
				batch.draw(assetsManager.loserMessage, -200,-70, 400, 140);
				batch.draw(assetsManager.tryAgain, -22, -60, 44, 44);
				btnTryAgainBound = new BoundingBox(new Vector3(-20f,-60f,0), new Vector3(20f,-20f,0));
			}
		}
		if(helpMessageIsVisible){
			batch.draw(assetsManager.helpMessage, -195,-325, 390, 650);
			closeHelpBound = new BoundingBox(new Vector3(-195,-325,0), new Vector3(195,325,0));
		}
		
		
		batch.end();
		
		
		
		if (Gdx.input.justTouched()){
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));	
			touchedColor = 0;
				
			if(helpBound.contains(touchPoint)){
					helpMessageIsVisible = true;				
			}
			if(helpMessageIsVisible){	
				if(closeHelpBound.contains(touchPoint)){
					helpMessageIsVisible = false;
				}
			}else{
				if (blueBound.contains(touchPoint) && round <9){
					touchedColor = blueId;				
				}else if (redBound.contains(touchPoint) && round <9){
					touchedColor = redId;				
				}else if (greenBound.contains(touchPoint) && round <9){
					touchedColor = greenId;
				}else if (purpleBound.contains(touchPoint) && round <9){
					touchedColor = purpleId;
				}else if (yellowBound.contains(touchPoint) && round <9){
					touchedColor = yellowId;
				}else if (whiteBound.contains(touchPoint) && round <9){
					touchedColor = whiteId;
				}
			
			if(LoserMessageIsVisible){
				if(btnTryAgainBound.contains(touchPoint)){
					dispose();
					create();
				}
			}
			if(!firstSpaceIsEmpty[round-1]){
				if (firstSpaceBound.contains(touchPoint)){
					firstSpaceIsEmpty[round-1] = true;
					firstSpaceColor[round-1] = 0;
			}}
			
			if(!secondSpaceIsEmpty[round-1]){
				if (secondSpaceBound.contains(touchPoint)){
					secondSpaceIsEmpty[round-1] = true;
					secondSpaceColor[round-1] = 0;
			}}
			
			if(!thirdSpaceIsEmpty[round-1]){
			if (thirdSpaceBound.contains(touchPoint)){
				thirdSpaceIsEmpty[round-1] = true;
				thirdSpaceColor[round-1] = 0;
			}}
			
			if(!fourthSpaceIsEmpty[round-1]){
			if (fourthSpaceBound.contains(touchPoint)){
				fourthSpaceIsEmpty[round-1] = true;
				fourthSpaceColor[round-1] = 0;
			}}
			
					
			if (touchedColor > 0){
				if (firstSpaceIsEmpty[round-1]){
					firstSpaceColor[round-1] = touchedColor;
					firstSpaceIsEmpty[round-1] = false;
				}else if (secondSpaceIsEmpty[round-1]){
					secondSpaceColor[round-1] = touchedColor;
					secondSpaceIsEmpty[round-1] = false;
				}else if (thirdSpaceIsEmpty[round-1]){
					thirdSpaceColor[round-1] = touchedColor;
					thirdSpaceIsEmpty[round-1] = false;
				}else if (fourthSpaceIsEmpty[round-1]){
					fourthSpaceColor[round-1] = touchedColor;
					fourthSpaceIsEmpty[round-1] = false;
				}
			}			
			if (!firstSpaceIsEmpty[round-1] && !secondSpaceIsEmpty[round-1] && !thirdSpaceIsEmpty[round-1] && !fourthSpaceIsEmpty[round-1]){
				btnCheckIsVisible = true;
				if(btnCheckBound.contains(touchPoint)){
//					
					fullHits[round-1] = countFullHits(firstSpaceColor[round-1], secondSpaceColor[round-1],thirdSpaceColor[round-1], fourthSpaceColor[round-1]);
					if (fullHits[round-1] == 4){
						winnerMessageIsVisible = true;
					} else{
						halfHits[round-1] = countHalfHits(); 
						btnCheckIsVisible = false;
						hitsList = new boolean[]{false,false,false,false};
						halfHitsList = new ArrayList <Integer> ();
						if (round<=8){	round = round + 1;
							if(round==9){
								LoserMessageIsVisible=true;
							}
						}
					}
					
				}
			}else{
					btnCheckIsVisible = false;
					}
			
		}
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	private boolean drawSpaces (int space, int[] spaceColor, int round){
		float yIncrementPerRound = 72f;
		float xIncrementPerSpace = 71f;
		float xValue = (-halfWidth + 98f);
		float yValue = (-halfHeight + 39f);
		
		yValue = yValue + (yIncrementPerRound * round); 
		xValue = xValue + (xIncrementPerSpace * space);
			
		
		switch (spaceColor[round-1]){
			case 1: batch.draw(assetsManager.Blue,xValue,yValue, 75, 75); break;
			case 2: batch.draw(assetsManager.Red, xValue,yValue, 75, 75); break;
			case 3: batch.draw(assetsManager.Green, xValue,yValue, 75, 75); break;
			case 4: batch.draw(assetsManager.Purple, xValue,yValue, 75, 75); break;
			case 5: batch.draw(assetsManager.Yellow, xValue,yValue, 75, 75); break;
			case 6: batch.draw(assetsManager.White, xValue,yValue, 75, 75); break;}
				
		if (round>1){
			round = round - 1;
			drawSpaces(space, spaceColor, round);
		}		
		
		return false;
	}
	
	private boolean drawBtnCheck (int round){
		float yIncrementPerRound = 72f;
		float xValue = (-halfWidth + 15f);
		float yValue = (-halfHeight + 39f);				
		yValue = yValue + (yIncrementPerRound * round);		
		
		batch.draw(assetsManager.btnCheck, xValue,yValue, 150,75);		
		return false;
	}
	
	private BoundingBox assignBoundCheck (int round){
		BoundingBox bound = new BoundingBox();
		float yIncrementPerRound = 70f;
		float xValue = (-halfWidth + 15f);
		float downYValue = (-halfHeight + 45f);
		float upYValue;
		downYValue = downYValue + (yIncrementPerRound * round);
		upYValue = downYValue + 60;
		
		bound = new BoundingBox(new Vector3(xValue,downYValue, 0), new Vector3(xValue + 150f,upYValue,0));
//				
		return bound;
	}
	
	
	
	private boolean drawHits (int[] fHits, int[] hHits, int round, int spaceIndex){
		float yIncrementPerRound = 72f;
		float xIncrementPerSpace = 29f;		
		float xValue = (-halfWidth + 42f);
		float yValue = (-halfHeight + 3f);
		int fHitsLatestIndex;
		int hHitsLatestIndex;		
		fHitsLatestIndex = fHits[round-2];
		hHitsLatestIndex = hHits[round-2] + fHitsLatestIndex;
		
		switch(spaceIndex){
		case 1: 
			yValue = yValue + (yIncrementPerRound * round); 
			xValue = xValue + xIncrementPerSpace;
			break;
		case 2:
			yValue = yValue + (yIncrementPerRound * round); 
			xValue = xValue + 2 * xIncrementPerSpace;
			break;
		case 3:
			yValue = yValue + (yIncrementPerRound * round) - xIncrementPerSpace; 
			xValue = xValue + xIncrementPerSpace;
			break;
		case 4:
			yValue = yValue + (yIncrementPerRound * round) - xIncrementPerSpace; 
			xValue = xValue + 2 * xIncrementPerSpace;
			break;			
		}			
		
		if (spaceIndex <= fHitsLatestIndex){
			batch.draw(assetsManager.fullHit,xValue,yValue, 26, 26);
			spaceIndex = spaceIndex + 1;			
		}else if (spaceIndex <= hHitsLatestIndex){
			batch.draw(assetsManager.halfHit,xValue,yValue, 26, 26);
			spaceIndex = spaceIndex + 1;
		}
		if (spaceIndex <= hHitsLatestIndex){
		drawHits(fHits, hHits, round, spaceIndex);	}
				
		if (round>2){
			round = round - 1;
			drawHits(fHits, hHits, round, 1);
		}		
		
		return false;
	}
	
	private BoundingBox assignBounds(int space, int round){
		BoundingBox bound;
		bound = new BoundingBox();
		float upXValue;
		float downXValue;
		float upYValue;
		float downYValue;
		float yIncrementPerRound;
		float xIncrementPerSpace;
		
		yIncrementPerRound = 70f * round;
		xIncrementPerSpace = 71f * space;
		downXValue = -halfWidth + 104f;
		downYValue = -halfHeight + 45f;
		upXValue = downXValue + 60f;
		upYValue = downYValue + 60f;
		
		downXValue = downXValue + xIncrementPerSpace;
		upXValue = upXValue + xIncrementPerSpace;
		downYValue = downYValue + yIncrementPerRound;
		upYValue = upYValue + yIncrementPerRound;
		bound = new BoundingBox(new Vector3(downXValue,downYValue,0), new Vector3(upXValue,upYValue,0));
		return bound;
	}
	
	
	private int countFullHits(int firstRoundValue, int secondRoundValue, int thirdRoundValue, int fourthRoundValue){
		int hitCounter = 0;
		if (firstRoundValue == firstValue){
			hitCounter = hitCounter + 1;
			hitsList[0] = true;			
		} else {	halfHitsList.add(firstRoundValue);	}
		if (secondRoundValue == secondValue){
			hitCounter = hitCounter +1;
			hitsList[1] = true;			
		} else {	halfHitsList.add(secondRoundValue);	}
		if (thirdRoundValue == thirdValue){
			hitCounter = hitCounter + 1;
			hitsList[2] = true;
		} else {	halfHitsList.add(thirdRoundValue);	}
		if (fourthRoundValue == fourthValue){
			hitCounter = hitCounter + 1;
			hitsList[3] = true;
		} else {	halfHitsList.add(fourthRoundValue);	}
		
		return hitCounter;
	}
	
	private int countHalfHits(){
		int halfHitsCounter=0;
		boolean hitOccurs;
		for(int i=0; i<halfHitsList.size(); i++){
			hitOccurs = false;
			if (!hitsList[0] && !hitOccurs){
				if (firstValue == halfHitsList.get(i)){
					hitOccurs = true;
					hitsList[0] = true;
					
				}
			}
			if (!hitsList[1] && !hitOccurs){
				if (secondValue == halfHitsList.get(i)){
					hitOccurs = true;
					hitsList[1] = true;
				}
			}
			if (!hitsList[2] && !hitOccurs){
				if (thirdValue == halfHitsList.get(i)){
					hitOccurs = true;
					hitsList[2] = true;
				}
			}
			if (!hitsList[3] && !hitOccurs){
				if (fourthValue == halfHitsList.get(i)){
					hitOccurs = true;
					hitsList[3] = true;
				}
			}
			if (hitOccurs){	halfHitsCounter = halfHitsCounter +1;	}
		}
		
		
		return halfHitsCounter;
	}
	
	
	private int getRandom(){
		int RandomValue;
		RandomValue = (int) Math.floor((Math.random()*6)+1);
		return RandomValue;
	}
	

	
}



//setear Bounds de los espacios de colores en un metodo
//considerar cambiar los firstSpaceIsEmpty a array