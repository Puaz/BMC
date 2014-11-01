package com.NA76.CodeBreak;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Time {
	private int time;
	private float timer;
	private InteractiveElement tenMinutes;
	private InteractiveElement oneMinutes;
	private InteractiveElement timeSeparator;
	private InteractiveElement tenSeconds;
	private InteractiveElement oneSeconds;
	private TextAssets assetTime;
	
	Time ()
	{
		tenMinutes = new InteractiveElement();
		oneMinutes = new InteractiveElement();
		timeSeparator = new InteractiveElement();
		tenSeconds = new InteractiveElement();
		oneSeconds = new InteractiveElement();
		assetTime = new TextAssets();
		
	}

	
	public void count(float Timer)
	{
		timer+= Timer;
		if (timer >= 1f) {
			   time++;
			   timer-=1f;
			}
	}
	
	public int getTime()
	{		
		return time;
	}
	

	
	public void draw(SpriteBatch batch)
	{
		int hours;
		int minutes;
		int seconds;
		int elapsedSeconds;
		elapsedSeconds = getTime();
		hours = elapsedSeconds/3600;
		elapsedSeconds = elapsedSeconds - hours * 3600;
		minutes = elapsedSeconds/60;
		elapsedSeconds = elapsedSeconds - minutes * 60;
		seconds = elapsedSeconds;
//		System.out.println(Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
		
		drawMinutes(batch, minutes);
		drawTimeSeparator(batch);
		drawSeconds(batch, seconds);
	}
	
	private void drawMinutes(SpriteBatch batch, int minutes)
	{
		
		tenMinutes.setProperties(ElementSizes.TIME_FONT_WIDTH, ElementSizes.TIME_FONT_HEIGHT, ScreenMap.X_VALUE_TEN_MINUTES, ScreenMap.Y_VALUE_TIME);
		oneMinutes.setProperties(ElementSizes.TIME_FONT_WIDTH, ElementSizes.TIME_FONT_HEIGHT, ScreenMap.X_VALUE_ONE_MINUTES, ScreenMap.Y_VALUE_TIME);
		tenSelector (tenMinutes, minutes);
		oneSelector (oneMinutes, minutes);
		tenMinutes.draw(batch);
		oneMinutes.draw(batch);
		
	}
	
	private void drawTimeSeparator(SpriteBatch batch)
	{
		timeSeparator.setProperties(ElementSizes.TIME_FONT_WIDTH, ElementSizes.TIME_FONT_HEIGHT, ScreenMap.X_VALUE_TIME_SEPARATOR, ScreenMap.Y_VALUE_TIME);
		timeSeparator.setTexture(assetTime.Colon);
		timeSeparator.draw(batch);
		
	}
	
	private void drawSeconds(SpriteBatch batch, int seconds)
	{
		
		tenSeconds.setProperties(ElementSizes.TIME_FONT_WIDTH, ElementSizes.TIME_FONT_HEIGHT, ScreenMap.X_VALUE_TEN_SECONDS, ScreenMap.Y_VALUE_TIME);
		oneSeconds.setProperties(ElementSizes.TIME_FONT_WIDTH, ElementSizes.TIME_FONT_HEIGHT, ScreenMap.X_VALUE_ONE_SECONDS, ScreenMap.Y_VALUE_TIME);
		tenSelector (tenSeconds, seconds);
		oneSelector (oneSeconds, seconds);
		tenSeconds.draw(batch);
		oneSeconds.draw(batch);
		
	}
	
	
	private void tenSelector(InteractiveElement element, int time )
	{

		time = time / 10;
		switch (time)
		{
		case 0:
			element.setTexture(assetTime.Zero);
			break;
		case 1:
			element.setTexture(assetTime.One);
			break;
		case 2:
			element.setTexture(assetTime.Two);
			break;
		case 3:
			element.setTexture(assetTime.Three);
			break;
		case 4:
			element.setTexture(assetTime.Four);
			break;
		case 5:
			element.setTexture(assetTime.Five);
			break;
		default:
			element.setTexture(assetTime.Zero);
			break;
				
		
		}	

		
	}
	
	
	private void oneSelector(InteractiveElement element, int time )
	{
		int tenTime;
		tenTime = time / 10;
		time = time - tenTime*10;
		switch (time)
		{
		case 0:
			element.setTexture(assetTime.Zero);
			break;
		case 1:
			element.setTexture(assetTime.One);
			break;
		case 2:
			element.setTexture(assetTime.Two);
			break;
		case 3:
			element.setTexture(assetTime.Three);
			break;
		case 4:
			element.setTexture(assetTime.Four);
			break;
		case 5:
			element.setTexture(assetTime.Five);
			break;
		case 6:
			element.setTexture(assetTime.Six);
			break;
		case 7:
			element.setTexture(assetTime.Seven);
			break;
		case 8:
			element.setTexture(assetTime.Eight);
			break;
		case 9:
			element.setTexture(assetTime.Nine);
			break;
		default:
			element.setTexture(assetTime.Zero);
			break;
		
		}	

		
	}
	
}
