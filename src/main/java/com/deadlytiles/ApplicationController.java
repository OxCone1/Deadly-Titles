package com.deadlytiles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApplicationController {
    private GameSequenceCreator gameSequence = new GameSequenceCreator();
    private JSON_Handler jsonHandler = new JSON_Handler();
    private Player player = new Player();

    @GetMapping("/player")
    public Object getNickname(@RequestParam String nickname) {
        if (jsonHandler.searchForUser(nickname)) {
            player.updatePlayer(player.getNickname());
            // return jsonHandler.getUserInfo(nickname);
            return jsonHandler.getUserInfo(nickname);
        }
        else{
            return "User does not exist";
        }
        
    }
    @PostMapping("/game")
    public String getSequence(@RequestParam String nickname) {
        if (jsonHandler.searchForUser(nickname)) {
            jsonHandler.updateGameID(nickname, gameSequence.generateSequence());
            jsonHandler.updateActiveGame(nickname, true);
            jsonHandler.updateCurrentGamePosition(nickname, 0);
            jsonHandler.updateCurrentMaxTiles(nickname, gameSequence.getSequenceSize());
            player.updatePlayer(player.getNickname());
            return "Game successfully created";
        }
        else{
            return "User does not exist, create user first";
        }
        
    }

    @PutMapping("/game")
    //get sequence of 5 numbers from 0 to 1
    public String makeGameMove(@RequestParam String nickname, @RequestParam String moveDirection) {
        player.updatePlayer(player.getNickname());
        if (player.getActiveGame()) {
            Game game = new Game(player.getGameID(), player, player.getNickname(), null);
            // game.addToGame(player.getGameID(), player, player.getNickname(), null);
            game.setSequence();
            return game.moveTiles(moveDirection);
        }
        else{
            return "No active game, please create a game first";
        }
    }

    @PostMapping("/switchPlayer")
    public String chanePlayer(@RequestParam String changeTo) {
        if (jsonHandler.searchForUser(changeTo)) {
            player.updateOnLogin(changeTo);
            return "Player successfully changed";
        }
        else{
            return "User does not exist!\nPlease check nickname spelling or use \"POST /createPlayer\" to create player";
        }
        
    }
    @PostMapping("/createPlayer")
        public String setPlayerNickname(@RequestParam String nickname){
            if (jsonHandler.searchForUser(nickname)) {
                return "User already exists!\nPlease use another nickname or use \"POST /switchPlayer\" to change player";
            }
            else{
                player.setNickname(nickname);
                jsonHandler.createOrAddToJSON(player.getNickname(), player.getGamesPlayed(), player.getGamesWon(), player.getActiveGame(), player.getCurrentGamePosition(), player.getCurrentMaxTiles(), player.getGameID());
                return "User "+ nickname +" created!";
            }
        }

}


//Project by Vadims "OxCone" Lapins