package com.NA76.CodeBreak;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {
	public AtlasRegion background;
	public AtlasRegion btnCheck;
	public AtlasRegion Blue;
	public AtlasRegion Red;
	public AtlasRegion Green;
	public AtlasRegion Yellow;
	public AtlasRegion Purple;
	public AtlasRegion White;
	public AtlasRegion btnCheckDown;
	public AtlasRegion winnerMessage;
	public AtlasRegion loserMessage;
	public AtlasRegion tryAgain;
	public AtlasRegion fullHit;
	public AtlasRegion halfHit;
	public AtlasRegion help;
	public AtlasRegion helpMessage;
	public AtlasRegion fullHitZero;
	public AtlasRegion fullHitOne;
	public AtlasRegion fullHitTwo;
	public AtlasRegion fullHitThree;
	public AtlasRegion fullHitFour;
	public AtlasRegion halfHitZero;
	public AtlasRegion halfHitOne;
	public AtlasRegion halfHitTwo;
	public AtlasRegion halfHitThree;
	public AtlasRegion halfHitFour;
	
	
	private TextureAtlas atlas; 
	
	Assets(){
		atlas = new TextureAtlas(Gdx.files.internal("data/gamePack.atlas"));
		background = atlas.findRegion("Code_Background");
		btnCheck = atlas.findRegion("Code_BtnCheck");
		Blue = atlas.findRegion("Code_Blue");
		Red = atlas.findRegion("Code_Red");
		Green = atlas.findRegion("Code_Green");
		Yellow = atlas.findRegion("Code_Yellow");
		Purple = atlas.findRegion("Code_Purple");
		White = atlas.findRegion("Code_White");
		btnCheckDown = atlas.findRegion("Code_BtnCheckDown");
		winnerMessage = atlas.findRegion("Code_WinnerMessage");
		loserMessage = atlas.findRegion("Code_LoserMessage");
		tryAgain = atlas.findRegion("Code_TryAgain");
		fullHit = atlas.findRegion("Code_FullHit");
		halfHit = atlas.findRegion("Code_HalfHit");
		help = atlas.findRegion("Code_Help");
		helpMessage = atlas.findRegion("Code_HelpMessage");
		fullHitZero = atlas.findRegion("Code_FullHit_Zero");
		fullHitOne = atlas.findRegion("Code_FullHit_One");
		fullHitTwo = atlas.findRegion("Code_FullHit_Two");
		fullHitThree = atlas.findRegion("Code_FullHit_Three");
		fullHitFour = atlas.findRegion("Code_FullHit_Four");
		halfHitZero = atlas.findRegion("Code_HalfHit_Zero");
		halfHitOne = atlas.findRegion("Code_HalfHit_One");
		halfHitTwo = atlas.findRegion("Code_HalfHit_Two");
		halfHitThree = atlas.findRegion("Code_HalfHit_Three");
		halfHitFour = atlas.findRegion("Code_HalfHit_Four");
		
	}
	
	public void dispose(){
		atlas.dispose();
	}
}
