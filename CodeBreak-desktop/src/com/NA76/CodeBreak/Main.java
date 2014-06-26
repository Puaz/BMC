package com.NA76.CodeBreak;


import com.NA76.CodeBreak.CodeBreak;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CodeBreak";
		cfg.width = 480;
		cfg.height = 800;
		
		 Settings settings = new Settings();
	        settings.paddingX=2;
	        settings.paddingY=2;
	        settings.maxHeight=2048;
	        settings.maxWidth=2048;

	        TexturePacker.process(settings, "../CodeBreak/images", "../CodeBreak-android/assets/data", "gamePack");
		
		
		new LwjglApplication(new CodeBreak(), cfg);
	}
}
