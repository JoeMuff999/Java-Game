package com.javagame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.javagame.Main;

public class DesktopLauncher {
	public static LwjglApplicationConfiguration config;
	public static void main (String[] arg) {
		config = new LwjglApplicationConfiguration();
		config.title = "Java Game!!";
		config.width = Main.ScreenWidth;
		config.height = Main.ScreenHeight;
		new LwjglApplication(new Main(), config);
	}
}
