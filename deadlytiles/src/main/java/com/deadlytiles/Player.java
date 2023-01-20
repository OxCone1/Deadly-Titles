package com.deadlytiles;


public class Player {
    private String nickname;
    private Integer gamesPlayed;
    private Integer gamesWon;
    private boolean activeGame;
    private Integer currentGamePosition;
    private Integer currentMaxTiles;
    private String gameID;

    public Player() {
        this.nickname = null;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.activeGame = false;
        this.currentGamePosition = null;
        this.currentMaxTiles = null;
        this.gameID = null;
    }
    public Player(String nickname, Integer gamesPlayed, Integer gamesWon, boolean activeGame, Integer currentGamePosition, Integer currentMaxTiles, String gameID) {
        this.nickname = nickname;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.activeGame = activeGame;
        this.currentGamePosition = currentGamePosition;
        this.currentMaxTiles = currentMaxTiles;
        this.gameID = gameID;
    }
    public String getNickname() {
        return this.nickname;
    }
    public Integer getGamesPlayed() {
        return this.gamesPlayed;
    }
    public Integer getGamesWon() {
        return this.gamesWon;
    }
    public boolean getActiveGame() {
        return this.activeGame;
    }
    public Integer getCurrentGamePosition() {
        return this.currentGamePosition;
    }
    public Integer getCurrentMaxTiles() {
        return this.currentMaxTiles;
    }
    public String getGameID() {
        return this.gameID;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }
    public void setActiveGame(boolean activeGame) {
        this.activeGame = activeGame;
    }
    public void setCurrentGamePosition(Integer currentGamePosition) {
        this.currentGamePosition = currentGamePosition;
    }
    public void setCurrentMaxTiles(Integer currentMaxTiles) {
        this.currentMaxTiles = currentMaxTiles;
    }
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public void updatePlayer(String nickname){
        JSON_Handler json_handler = new JSON_Handler();
        json_handler.updateActiveGame(nickname, json_handler.getUserActiveGame(nickname));
        json_handler.updateCurrentGamePosition(nickname, json_handler.getUserCurrentGamePosition(nickname));
        json_handler.updateCurrentMaxTiles(nickname, json_handler.getUserCurrentMaxTiles(nickname));
        json_handler.updateGamesPlayed(nickname, json_handler.getUserGamesPlayed(nickname));
        json_handler.updateGamesWon(nickname, json_handler.getUserGamesWon(nickname));
        json_handler.updateGameID(nickname, json_handler.getUserGameID(nickname));
        this.activeGame = json_handler.getUserActiveGame(nickname);
        this.currentGamePosition = json_handler.getUserCurrentGamePosition(nickname);
        this.currentMaxTiles = json_handler.getUserCurrentMaxTiles(nickname);
        this.gamesPlayed = json_handler.getUserGamesPlayed(nickname);
        this.gamesWon = json_handler.getUserGamesWon(nickname);
        this.gameID = json_handler.getUserGameID(nickname);
    }
    public void updateOnLogin(String nickname){
        JSON_Handler jsonHandler = new JSON_Handler();
        this.nickname = jsonHandler.getUserNickname(nickname);
        this.gamesPlayed = jsonHandler.getUserGamesPlayed(nickname);
        this.gamesWon = jsonHandler.getUserGamesWon(nickname);
        this.activeGame = jsonHandler.getUserActiveGame(nickname);
        this.currentGamePosition = jsonHandler.getUserCurrentGamePosition(nickname);
        this.currentMaxTiles = jsonHandler.getUserCurrentMaxTiles(nickname);
        this.gameID = jsonHandler.getUserGameID(nickname);
    }

    @Override public String toString() {
        return "{\n" +
            " \"nickname\":\"" + getNickname() + "\"" +
            ",\n \"gamesPlayed\": " + getGamesPlayed() + "" +
            ",\n \"gamesWon\": " + getGamesWon() + "" +
            ",\n \"activeGame\": " + getActiveGame() + "" +
            ",\n \"currentGamePosition\": " + getCurrentGamePosition() + "" +
            ",\n \"currentMaxTiles\": " + getCurrentMaxTiles() + "" +
            ",\n \"gameID\": \"" + getGameID() + "\"" +
            "}";
    }
}



//Project by Vadims "OxCone" Lapins