/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javagooglespeech;

import java.io.IOException;
import com.darkprograms.speech.synthesiser.SynthesiserV2;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class TextToSpeech {
    
    SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");

    public TextToSpeech() {
        speak("Text to speech");
    }
    
    public void speak(final String text) {
	
		Thread t = new Thread(new Runnable() {                
                  @Override
                  public void run() {
                  try {			
			AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text));
			player.play();
			} catch (IOException  e) {
			System.out.println(e.getMessage());	
			} catch (JavaLayerException ex) {
                        System.out.println(ex.getMessage());
                    }
    }
                });		
		t.start();		
	}
}
