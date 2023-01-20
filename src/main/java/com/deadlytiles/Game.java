package com.deadlytiles;

import java.util.ArrayList;

public class Game {
    public String hashedGameID;
    public Player playerObject;
    public String username;
    public ArrayList<Integer> sequence;
    JSON_Handler json_handler = new JSON_Handler();

    public Game(String hashedGameID, Player playerObject, String username, ArrayList<Integer> sequence) {
        this.hashedGameID = hashedGameID;
        this.playerObject = playerObject;
        this.username = username;
        this.sequence = sequence;
    }
    public Game() {
        this.hashedGameID = null;
        this.playerObject = null;
        this.username = null;
        this.sequence = null;
    }
    public void addToGame(String hashedGameID, Player playerObject, String username, ArrayList<Integer> sequence){
        this.hashedGameID = hashedGameID;
        this.playerObject = playerObject;
        this.username = username;
        this.sequence = sequence;
    }

    public void setSequence() {
        Encrypter encrypter = new Encrypter();
        String decryptedSequence = encrypter.DecryptGameID(hashedGameID);
        String sequenceArray = decryptedSequence.substring(1, decryptedSequence.length() - 1);
        String[] sequenceArraySplit = sequenceArray.split(", ");
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        for (int i = 0; i < sequenceArraySplit.length; i++) {
            sequence.add(Integer.parseInt(sequenceArraySplit[i]));
        }
        this.sequence = sequence;
    }

    public String moveTiles(String direction){
        Integer currentMaxTiles = playerObject.getCurrentMaxTiles();
        Integer nextTile = sequence.get(playerObject.getCurrentGamePosition());
        if (direction.equals("left")) {
            if (direction.equals("left") && nextTile == 0) {
                playerObject.setCurrentGamePosition(playerObject.getCurrentGamePosition() + 1);
                json_handler.updateCurrentGamePosition(playerObject.getNickname(), playerObject.getCurrentGamePosition());
                if (playerObject.getCurrentGamePosition() >= currentMaxTiles) {
                    playerObject.setGamesPlayed(playerObject.getGamesPlayed() + 1);
                    json_handler.updateGamesPlayed(playerObject.getNickname(), playerObject.getGamesPlayed());
                    playerObject.setGamesWon(playerObject.getGamesWon() + 1);
                    json_handler.updateGamesWon(playerObject.getNickname(), playerObject.getGamesWon());
                    json_handler.updateGameID(playerObject.getNickname(), null);
                    return "You won!";
                }
            }
            if (direction.equals("left") && nextTile == 1) {
                playerObject.setGamesPlayed(playerObject.getGamesPlayed() + 1);
                json_handler.updateGamesPlayed(playerObject.getNickname(), playerObject.getGamesPlayed());
                playerObject.setActiveGame(false);
                json_handler.updateActiveGame(playerObject.getNickname(), false);
                playerObject.setCurrentGamePosition(0);
                json_handler.updateCurrentGamePosition(playerObject.getNickname(), 0);
                json_handler.updateGameID(playerObject.getNickname(), null);
                return "You have fallen down a left hole!\nYou have lost the game!";
            }
            return "You stepped on the left tile!\nYou are now on tile " + playerObject.getCurrentGamePosition() + " of " + currentMaxTiles + "!";
        }
        if (direction.equals("right")) {
            if (direction.equals("right") && nextTile == 1) {
                playerObject.setCurrentGamePosition(playerObject.getCurrentGamePosition() + 1);
                json_handler.updateCurrentGamePosition(playerObject.getNickname(), playerObject.getCurrentGamePosition());
                if (playerObject.getCurrentGamePosition() >= currentMaxTiles) {
                    playerObject.setGamesPlayed(playerObject.getGamesPlayed() + 1);
                    json_handler.updateGamesPlayed(playerObject.getNickname(), playerObject.getGamesPlayed());
                    playerObject.setGamesWon(playerObject.getGamesWon() + 1);
                    json_handler.updateGamesWon(playerObject.getNickname(), playerObject.getGamesWon());
                    json_handler.updateGameID(playerObject.getNickname(), null);
                    return "You won!";
                }
            }
            if (direction.equals("right") && nextTile == 0) {
                playerObject.setGamesPlayed(playerObject.getGamesPlayed() + 1);
                json_handler.updateGamesPlayed(playerObject.getNickname(), playerObject.getGamesPlayed());
                playerObject.setActiveGame(false);
                json_handler.updateActiveGame(playerObject.getNickname(), false);
                playerObject.setCurrentGamePosition(0);
                json_handler.updateCurrentGamePosition(playerObject.getNickname(), 0);
                json_handler.updateGameID(playerObject.getNickname(), null);
                return "You have fallen down a right hole!\nYou have lost the game!";
            }
            return "You stepped on the right tile!\nYou are now on tile " + playerObject.getCurrentGamePosition() + " of " + currentMaxTiles + "!";
        }
        return null;
    }
}




//Project by Vadims "OxCone" Lapins