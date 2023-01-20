package com.deadlytiles;

import java.util.ArrayList;

public class GameSequenceCreator {
    
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    

    public String generateSequence() {
        if (sequence.size() > 0) {
            sequence.clear();
        }
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 2);
            sequence.add(random);  
        }
        Encrypter encrypter = new Encrypter();
        return encrypter.EncryptGameID(sequence.toString());
    }
    public Integer getSequenceSize() {
        //return lenght of sequence
        return sequence.size();
    }
}




//Project by Vadims "OxCone" Lapins