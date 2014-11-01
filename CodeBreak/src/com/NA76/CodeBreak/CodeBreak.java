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
	

	private float halfHeight;
	private float halfWidth;
	private Assets assetsManager;
	private int firstValue;
	private int secondValue;
	private int thirdValue;
	private int fourthValue;
	private Time time;
	private Score score;
	
	private InteractiveElement blueColor;
	private InteractiveElement firstSpaceColorSelected;
	private InteractiveElement redColor;
	private InteractiveElement greenColor;
	private InteractiveElement purpleColor;
	private InteractiveElement yellowColor;
	private InteractiveElement whiteColor;
	private InteractiveElement helpButton;
	private InteractiveElement checkButton;
	private InteractiveElement tryAgainButton;
	private InteractiveElement fullHitsImage;
	private InteractiveElement halfHitsImage;
	
	private final static int BLUE_ID 	= 1;
	private final static int RED_ID 		= 2;
	private final static int GREEN_ID 	= 3;
	private final static int PURPLE_ID	= 4;
	private final static int YELLOW_ID 	= 5;
	private final static int WHITE_ID	= 6;
	
	
	private int[] firstSpaceColor;
	private boolean[] firstSpaceIsEmpty;
	private int[] secondSpaceColor;
	private boolean[] secondSpaceIsEmpty;
	private int[] thirdSpaceColor;
	private boolean[] thirdSpaceIsEmpty;
	private int[] fourthSpaceColor;
	private boolean[] fourthSpaceIsEmpty;
	private int touchedColor;

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
		codeIsCorrect = false;
		hitsList = new boolean[]{false,false,false,false};
		halfHitsList = new ArrayList <Integer> ();
		blueColor = new InteractiveElement();
		redColor = new InteractiveElement();
		greenColor = new InteractiveElement();
		purpleColor = new InteractiveElement();
		yellowColor = new InteractiveElement();
		whiteColor = new InteractiveElement();
		firstSpaceColorSelected = new InteractiveElement();
		helpButton = new InteractiveElement();
		checkButton = new InteractiveElement();
		tryAgainButton = new InteractiveElement();
		fullHitsImage = new InteractiveElement();
		halfHitsImage = new InteractiveElement();
		time = new Time();
		score = new Score();
		
		firstValue = getRandom();
		secondValue = getRandom();
		thirdValue = getRandom();
		fourthValue = getRandom();
		
	}
	
	private void nextLevel(){
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
		codeIsCorrect = false;
		hitsList = new boolean[]{false,false,false,false};
		halfHitsList = new ArrayList <Integer> ();
		blueColor = new InteractiveElement();
		redColor = new InteractiveElement();
		greenColor = new InteractiveElement();
		purpleColor = new InteractiveElement();
		yellowColor = new InteractiveElement();
		whiteColor = new InteractiveElement();
		firstSpaceColorSelected = new InteractiveElement();
		helpButton = new InteractiveElement();
		checkButton = new InteractiveElement();
		tryAgainButton = new InteractiveElement();
		fullHitsImage = new InteractiveElement();
		halfHitsImage = new InteractiveElement();
		time = new Time();
		
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
		
		camera = new OrthographicCamera(ElementSizes.SCREEN_WIDTH, ElementSizes.SCREEN_HEIGHT);
		
		Vector3 touchPoint;
		touchPoint = new Vector3();
		BoundingBox firstSpaceBound = new BoundingBox();
		BoundingBox secondSpaceBound = new BoundingBox();
		BoundingBox thirdSpaceBound = new BoundingBox();
		BoundingBox fourthSpaceBound = new BoundingBox();

		BoundingBox closeHelpBound = new BoundingBox();
		
		



		blueColor.setTexture(assetsManager.Blue);
		blueColor.setProperties(ElementSizes.CODE_COLOR_WIDTH, ElementSizes.CODE_COLOR_HEIGHT, ScreenMap.X_VALUE_FIRST_COLOR_SELECTION_BAR, ScreenMap.Y_VALUE_SELECTION_BAR);
		blueColor.setBorders(0f, 0f, 0f, 0f);
		redColor.setTexture(assetsManager.Red);
		redColor.setProperties(ElementSizes.CODE_COLOR_WIDTH, ElementSizes.CODE_COLOR_HEIGHT,  ScreenMap.X_VALUE_SECOND_COLOR_SELECTION_BAR, ScreenMap.Y_VALUE_SELECTION_BAR);
		redColor.setBorders(0, 0, 0, 0);
		greenColor.setTexture(assetsManager.Green);
		greenColor.setProperties(ElementSizes.CODE_COLOR_WIDTH, ElementSizes.CODE_COLOR_HEIGHT,  ScreenMap.X_VALUE_THIRD_COLOR_SELECTION_BAR, ScreenMap.Y_VALUE_SELECTION_BAR);
		greenColor.setBorders(0f, 0f, 0f, 0f);
		purpleColor.setTexture(assetsManager.Purple);
		purpleColor.setProperties(ElementSizes.CODE_COLOR_WIDTH, ElementSizes.CODE_COLOR_HEIGHT, ScreenMap.X_VALUE_FOURTH_COLOR_SELECTION_BAR, ScreenMap.Y_VALUE_SELECTION_BAR);
		purpleColor.setBorders(0f, 0f, 0f, 0f);
		yellowColor.setTexture(assetsManager.Yellow);
		yellowColor.setProperties(ElementSizes.CODE_COLOR_WIDTH, ElementSizes.CODE_COLOR_HEIGHT,  ScreenMap.X_VALUE_FIFTH_COLOR_SELECTION_BAR, ScreenMap.Y_VALUE_SELECTION_BAR);
		yellowColor.setBorders(0f, 0f, 0f, 0f);
		whiteColor.setTexture(assetsManager.White);
		whiteColor.setProperties(ElementSizes.CODE_COLOR_WIDTH, ElementSizes.CODE_COLOR_HEIGHT,  ScreenMap.X_VALUE_SIXTH_COLOR_SELECTION_BAR, ScreenMap.Y_VALUE_SELECTION_BAR);
		helpButton.setTexture(assetsManager.help);
		helpButton.setProperties(ElementSizes.HELP_BUTTON_WIDTH, ElementSizes.HELP_BUTTON_HEIGHT,  ScreenMap.X_VALUE_HELP_BUTTON, ScreenMap.Y_VALUE_HELP_BUTTON);
		helpButton.setBorders(0f, 0f, 0f, 0f);
		checkButton.setTexture(assetsManager.btnCheck);
		checkButton.setBorders(0f, 0f, 0f, 0f);
		tryAgainButton.setTexture(assetsManager.tryAgain);
		tryAgainButton.setProperties(44f, 44f, -22, -60);
		tryAgainButton.setBorders(0f, 0f, 0f, 0f);
		fullHitsImage.setBorders(0f, 0f, 0f, 0f);
		halfHitsImage.setBorders(0f, 0f, 0f, 0f);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		
		batch.draw(assetsManager.background, ScreenMap.X_VALUE_BACKGROUND, ScreenMap.Y_VALUE_BACKGROUND, 480, 800);
		time.count(Gdx.graphics.getDeltaTime());		
		time.draw(batch);
		score.draw(batch);
		
		helpButton.draw(batch);
		
		
		//
		blueColor.draw(batch);
//		batch.draw(assetsManager.Blue, -halfWidth + 27f,-halfWidth + 27f, 75, 75);		
		redColor.draw(batch);
//		batch.draw(assetsManager.Red, -halfWidth + 98f,-halfHeight + 29f, 75, 75);		
		greenColor.draw(batch);
//		batch.draw(assetsManager.Green, -halfWidth + 169f,-halfHeight + 29f, 75, 75);		
		purpleColor.draw(batch);
//		batch.draw(assetsManager.Purple, -halfWidth + 240f,-halfHeight + 29f, 75, 75);
		yellowColor.draw(batch);		
//		batch.draw(assetsManager.Yellow, -halfWidth + 311f,-halfHeight + 29f, 75, 75);
		whiteColor.draw(batch);		
//		batch.draw(assetsManager.White, -halfWidth + 382f,-halfHeight + 27f, 75, 75);
		
		
		
		
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
			drawClues(fullHits,halfHits,round);
		}
		
//		 
		if (btnCheckIsVisible){
//			btnCheckBound = assignBoundCheck(round);
			drawBtnCheck(round);			
		}
		
		if (winnerMessageIsVisible){
			batch.draw(assetsManager.winnerMessage, -200,-70, 400, 140);
			tryAgainButton.draw(batch);
		} else {
			if (LoserMessageIsVisible){
				batch.draw(assetsManager.loserMessage, -200,-70, 400, 140);
				tryAgainButton.draw(batch);
				
			}
		}
		if(helpMessageIsVisible){
			batch.draw(assetsManager.helpMessage, ScreenMap.X_VALUE_HELP_MESSAGE,ScreenMap.Y_VALUE_HELP_MESSAGE, 390, 650);
			closeHelpBound = new BoundingBox(new Vector3(-195,-325,0), new Vector3(195,325,0));
		}
		
		
		batch.end();
		
		
		
		if (Gdx.input.justTouched()){
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));	
			touchedColor = 0;
				
			if(helpButton.getBounds().contains(touchPoint)){
					helpMessageIsVisible = true;				
			}
			if(helpMessageIsVisible){	
				if(closeHelpBound.contains(touchPoint)){
					helpMessageIsVisible = false;
				}
			}else{
				if (blueColor.getBounds().contains(touchPoint) && round <9){
					touchedColor = BLUE_ID;				
				}else if (redColor.getBounds().contains(touchPoint) && round <9){
					touchedColor = RED_ID;				
				}else if (greenColor.getBounds().contains(touchPoint) && round <9){
					touchedColor = GREEN_ID;
				}else if (purpleColor.getBounds().contains(touchPoint) && round <9){
					touchedColor = PURPLE_ID;
				}else if (yellowColor.getBounds().contains(touchPoint) && round <9){
					touchedColor = YELLOW_ID;
				}else if (whiteColor.getBounds().contains(touchPoint) && round <9){
					touchedColor = WHITE_ID;
				}
			
			if(LoserMessageIsVisible ){
				if(tryAgainButton.getBounds().contains(touchPoint)){
					dispose();
					create();
				}
			}else if ( winnerMessageIsVisible){
				if(tryAgainButton.getBounds().contains(touchPoint)){
					dispose();
					nextLevel();
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
				if(checkButton.getBounds().contains(touchPoint)){
//					
					fullHits[round-1] = countFullHits(firstSpaceColor[round-1], secondSpaceColor[round-1],thirdSpaceColor[round-1], fourthSpaceColor[round-1]);
					if (fullHits[round-1] == 4){
						winnerMessageIsVisible = true;
						int scoreForMatch = ((300 - time.getTime()) * 15);
						scoreForMatch = scoreForMatch + ((8-round)*1000);
						score.addToScore(scoreForMatch);

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

		float xValue;
		float yValue;
		
		yValue = getYValueForAttempt(round); 
		xValue = getXValueForPosition(space);
	
		
		switch (spaceColor[round-1]){
			case 1: 
				firstSpaceColorSelected.setTexture(assetsManager.Blue);
				firstSpaceColorSelected.setProperties(75f, 75f, xValue, yValue);
				firstSpaceColorSelected.draw(batch);
				break;
			case 2: 				
				firstSpaceColorSelected.setTexture(assetsManager.Red);
				firstSpaceColorSelected.setProperties(75f, 75f, xValue, yValue);
				firstSpaceColorSelected.draw(batch);
				break;
			case 3: 
				firstSpaceColorSelected.setTexture(assetsManager.Green);
				firstSpaceColorSelected.setProperties(75f, 75f, xValue, yValue);
				firstSpaceColorSelected.draw(batch);
				break;
			case 4: 
				firstSpaceColorSelected.setTexture(assetsManager.Purple);
				firstSpaceColorSelected.setProperties(75f, 75f, xValue, yValue);
				firstSpaceColorSelected.draw(batch);
				break;
			case 5: 
				firstSpaceColorSelected.setTexture(assetsManager.Yellow);
				firstSpaceColorSelected.setProperties(75f, 75f, xValue, yValue);
				firstSpaceColorSelected.draw(batch);
				break;
			case 6: 
				firstSpaceColorSelected.setTexture(assetsManager.White);
				firstSpaceColorSelected.setProperties(75f, 75f, xValue, yValue);
				firstSpaceColorSelected.draw(batch);
				break;
				}
				
		if (round>1){
			round = round - 1;
			drawSpaces(space, spaceColor, round);
		}		
		
		return false;
	}
	
	private boolean drawBtnCheck (int round){
	
		float xValue = ScreenMap.X_VALUE_CHECK;
		float yValue;			
		yValue = getYValueForAttempt(round);	
		
		checkButton.setProperties(150f, 75f, xValue, yValue);
		checkButton.draw(batch);
	
		return false;
	}
	
//	private BoundingBox assignBoundCheck (int round){
//		BoundingBox bound = new BoundingBox();
//		float yIncrementPerRound = 70f;
//		float xValue = (-halfWidth + 15f);
//		float downYValue = (-halfHeight + 45f);
//		float upYValue;
//		downYValue = downYValue + (yIncrementPerRound * round);
//		upYValue = downYValue + 60;
//		
//		bound = new BoundingBox(new Vector3(xValue,downYValue, 0), new Vector3(xValue + 150f,upYValue,0));
////				
//		return bound;
//	}
	
	
	
	private boolean drawClues (int[] fHits, int[] hHits, int round){
		float yValue = 0f;
		setFullHitImage(fHits, round-2);
		setHalfHitImage(hHits, round-2);
		yValue = getYValueForAttempt(round-1);
		fullHitsImage.setProperties(65f, 65f, ScreenMap.X_VALUE_FULL_HIT_CLUE, yValue+5f);
		halfHitsImage.setProperties(65f, 65f, ScreenMap.X_VALUE_HALF_HIT_CLUE, yValue+5f);
		fullHitsImage.draw(batch);
		halfHitsImage.draw(batch);				
		if (round>2){
			round = round - 1;
			drawClues(fHits, hHits, round);
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
		downXValue = -240 + 104f;
		downYValue = -400 + 45f;
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
	
	private float getXValueForPosition(int Position){
		float xValue = 0f;
		switch (Position){
		case 1:
			xValue = ScreenMap.X_VALUE_FIRST_COLOR_ATTEMPT;
			break;
		case 2:
			xValue = ScreenMap.X_VALUE_SECOND_COLOR_ATTEMPT;
			break;
		case 3:
			xValue = ScreenMap.X_VALUE_THIRD_COLOR_ATTEMPT;
			break;
		case 4:
			xValue = ScreenMap.X_VALUE_FOURTH_COLOR_ATTEMPT;
			break;			
		}
		
		return xValue;
	}
	
	private float getYValueForAttempt(int Attempt){
		float yValue =0f;
		switch (Attempt){
			case 1:
				yValue = ScreenMap.Y_VALUE_FIRST_ATTEMPT;
				break;
			case 2:
				yValue = ScreenMap.Y_VALUE_SECOND_ATTEMPT;
				break;
			case 3:
				yValue = ScreenMap.Y_VALUE_THIRD_ATTEMPT;
				break;
			case 4:
				yValue = ScreenMap.Y_VALUE_FOURTH_ATTEMPT;
				break;
			case 5:
				yValue = ScreenMap.Y_VALUE_FIFTH_ATTEMPT;
				break;
			case 6:
				yValue = ScreenMap.Y_VALUE_SIXTH_ATTEMPT;
				break;
			case 7:
				yValue = ScreenMap.Y_VALUE_SEVENTH_ATTEMPT;
				break;
			case 8:
				yValue = ScreenMap.Y_VALUE_EIGHT_ATTEMPT;
				break;
		}
		
		return yValue;
	}
	
	private void setFullHitImage(int[] fHits, int round){
		switch (fHits[round]){
			case 0:
				fullHitsImage.setTexture(assetsManager.fullHitZero);
				break;
			case 1:
				fullHitsImage.setTexture(assetsManager.fullHitOne);
				break;
			case 2:
				fullHitsImage.setTexture(assetsManager.fullHitTwo);
				break;
			case 3:
				fullHitsImage.setTexture(assetsManager.fullHitThree);
				break;
			case 4:
				fullHitsImage.setTexture(assetsManager.fullHitFour);
				break;
		}
	}
	
	private void setHalfHitImage(int[] hHits, int round){
		switch (hHits[round]){
			case 0:
				halfHitsImage.setTexture(assetsManager.halfHitZero);
				break;
			case 1:
				halfHitsImage.setTexture(assetsManager.halfHitOne);
				break;
			case 2:
				halfHitsImage.setTexture(assetsManager.halfHitTwo);
				break;
			case 3:
				halfHitsImage.setTexture(assetsManager.halfHitThree);
				break;
			case 4:
				halfHitsImage.setTexture(assetsManager.halfHitFour);
				break;
		}
	}



}



//setear Bounds de los espacios de colores en un metodo
//considerar cambiar los firstSpaceIsEmpty a array