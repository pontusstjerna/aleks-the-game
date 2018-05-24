package soldater.johannas.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import soldater.johannas.AleskTheUnicorn;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1000;
		config.height = 600;
		//config.fullscreen = true;
		config.title = "Alesk The Unicorn";;
		config.resizable = false;

		new LwjglApplication(new AleskTheUnicorn(), config);
	}
}
