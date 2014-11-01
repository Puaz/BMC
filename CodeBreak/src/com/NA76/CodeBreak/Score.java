package com.NA76.CodeBreak;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
	private int score;

	private InteractiveElement millionsElement;
	private InteractiveElement hundredthousandsElement;
	private InteractiveElement tenthousandsElement;
	private InteractiveElement thousandsElement;
	private InteractiveElement hundredsElement;
	private InteractiveElement tensElement;
	private InteractiveElement onesElement;
	private TextAssets assetScore;
	
	private static int MILLION = 1000000;
	private static int HUNDREDTHOUSAND = 100000;
	private static int TENTHOUSAND = 10000;
	private static int THOUSAND = 1000;
	private static int HUNDRED = 100;
	private static int TEN = 10;
	
	
	Score(){
		score = 0;
		millionsElement = new InteractiveElement();
		hundredthousandsElement = new InteractiveElement();
		tenthousandsElement = new InteractiveElement();
		thousandsElement = new InteractiveElement();
		hundredsElement = new InteractiveElement();
		tensElement = new InteractiveElement();
		onesElement = new InteractiveElement();
		assetScore = new TextAssets();
	}
	
	public void setScore(int Score)
	{
		score = Score;
		
	}
	
	public int getScore ()
	{
		return score;
	}
	
	public void addToScore(int Add)
	{
		System.out.print("Score Level: " + Add);
		score = score + Add;
		System.out.print("Score Total: " + score);
	}
	
	public void draw(SpriteBatch batch)
	{
		int millions = 0;
		int hundredthousands = 0;
		int tenthousands = 0;
		int thousands = 0;
		int hundreds = 0;
		int tens = 0;
		int ones = 0;
		int printedScore = 0;
		
		millionsElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_MILLION, ScreenMap.Y_VALUE_SCORE);
		hundredthousandsElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_HUNDRED_THOUSAND, ScreenMap.Y_VALUE_SCORE);
		tenthousandsElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_TEN_THOUSAND, ScreenMap.Y_VALUE_SCORE);
		thousandsElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_THOUSAND, ScreenMap.Y_VALUE_SCORE);
		hundredsElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_HUNDRED, ScreenMap.Y_VALUE_SCORE);
		tensElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_TEN, ScreenMap.Y_VALUE_SCORE);
		onesElement.setProperties(ElementSizes.SCORE_FONT_WIDTH, ElementSizes.SCORE_FONT_HEIGHT, ScreenMap.X_VALUE_ONE, ScreenMap.Y_VALUE_SCORE);
		
		if (score>0){
			printedScore = score;
			millions = printedScore /MILLION;
//			System.out.print("M" + millions);
			printedScore = printedScore - millions * MILLION;
			hundredthousands = printedScore/ HUNDREDTHOUSAND;
//			System.out.print("HT" + hundredthousands);
			printedScore = printedScore - hundredthousands * HUNDREDTHOUSAND;
			tenthousands = printedScore/ TENTHOUSAND;
//			System.out.print("TT" + tenthousands);
			printedScore = printedScore - tenthousands * TENTHOUSAND;
			thousands = printedScore/ THOUSAND;
//			System.out.print("T" + thousands);
			printedScore = printedScore - thousands * THOUSAND;
			hundreds = printedScore/ HUNDRED;
//			System.out.print("H" + hundreds);
			printedScore = printedScore - hundreds * HUNDRED;
			tens = printedScore/ TEN;
//			System.out.print("t" + tens);
			printedScore = printedScore - tens * TEN;
			ones = printedScore;
//			System.out.print("On" + ones);			
		}
		
		textureSelector(millionsElement, millions);
		textureSelector(hundredthousandsElement, hundredthousands);
		textureSelector(tenthousandsElement, tenthousands);
		textureSelector(thousandsElement, thousands);
		textureSelector(hundredsElement, hundreds);
		textureSelector(tensElement, tens);
		textureSelector(onesElement, ones);
		
		millionsElement.draw(batch);
		hundredthousandsElement.draw(batch);
		tenthousandsElement.draw(batch);
		thousandsElement.draw(batch);
		hundredsElement.draw(batch);
		tensElement.draw(batch);
		onesElement.draw(batch);
		
		
		
		
	}
	
	private void textureSelector (InteractiveElement element, int Score)
	{
		switch (Score)
		{
		case 0:
			element.setTexture(assetScore.Zero);
			break;
		case 1:
			element.setTexture(assetScore.One);
			break;
		case 2:
			element.setTexture(assetScore.Two);
			break;
		case 3:
			element.setTexture(assetScore.Three);
			break;
		case 4:
			element.setTexture(assetScore.Four);
			break;
		case 5:
			element.setTexture(assetScore.Five);
			break;
		case 6:
			element.setTexture(assetScore.Six);
			break;
		case 7:
			element.setTexture(assetScore.Seven);
			break;
		case 8:
			element.setTexture(assetScore.Eight);
			break;
		case 9:
			element.setTexture(assetScore.Nine);
			break;
		default:
			element.setTexture(assetScore.Zero);
			break;
				
		
		}	
	}
	

	

}
