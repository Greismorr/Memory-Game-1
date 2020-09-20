package jogo;

import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	String musicJogo = null;

	public void cartaVirando() {

		try {

			String resource = "/audios/turn.wav";
			
			InputStream input = getClass().getResourceAsStream(resource);

			Clip oClip = AudioSystem.getClip();
			AudioInputStream audio = AudioSystem.getAudioInputStream(input);
			oClip.open(audio);
			oClip.loop(0); 

		} catch (Exception e) { 
			e.printStackTrace();
		}

	}

	public void selecionado() {

		try {

			String resource = "/audios/botao.wav";
			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
		
			Clip oClip = AudioSystem.getClip();
			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void erro() {

		try {

			String resource = "/audios/erro2.wav";

			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void acerto() {

		try {

			String resource = "/audios/acerto.wav";

			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void vitoria() {

		try {

			String resource = "/audios/vitoria.wav";

			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void titulo() {

		try {

			String resource = "/audios/titulo.wav";

			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void turn() {

		try {

			String resource = "/audios/acerto.wav";

			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stop() {

	}

	public void music(int x) {

		try {

			String rep = "/audios/";
			String res = ".wav";
			res = x + res;

			musicJogo = rep + res;

			InputStream input = (InputStream) getClass().getResourceAsStream(musicJogo);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void vaia() {

		try {

			String resource = "/audios/vaia.wav";

			InputStream input = (InputStream) getClass().getResourceAsStream(resource);
			Clip oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
