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
		
		
	}
	
	public void dispose(){
		atlas.dispose();
	}
}
