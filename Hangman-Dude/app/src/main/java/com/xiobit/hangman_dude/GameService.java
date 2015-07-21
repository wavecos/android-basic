package com.xiobit.hangman_dude;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onix on 7/21/15.
 */
public class GameService {

    private List<String> words = new ArrayList<String>() {{
       words.add("TOYOTA");
       words.add("AUDI");
       words.add("SUZUKI");
       words.add("BMW");
       words.add("MITSUBISHI");
       words.add("MERCEDES BENZ");
       words.add("RENAULT");
       words.add("VOLSKWAGEN");
       words.add("FORD");
       words.add("GREAT WALL");
       words.add("MAZDA");
       words.add("ROLLS ROYCE");
       words.add("LAND ROVER");
    }};

    private String currentWord;
    private String secretWord;
    private String guessLetters;
    private String guessFailed;

    GameService() {

    }

    public void startGame() {
        Log.d("", "Start the Hangman Dude Game");

        currentWord = "";
        secretWord = "";
        guessLetters = "";
        guessFailed = "";


    }

    public void generateSecretWord() {


    }

    public void hideWord() {


    }



}
