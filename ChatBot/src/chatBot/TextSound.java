package chatBot;
import java.io.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextSound { //class for text to voice
    private Voice voice;
    public TextSound(String voiceName) //constructor 
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory"); //voice api

        VoiceManager voiceManager = VoiceManager.getInstance(); 
        voice = voiceManager.getVoice(voiceName);
    }
    public void speak(String msg) { //class to get the text from the user that has been converted from voice
        voice.allocate();
        voice.speak(msg);
        voice.deallocate();
    }
}
