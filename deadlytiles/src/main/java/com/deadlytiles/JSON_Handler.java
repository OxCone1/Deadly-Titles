package com.deadlytiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSON_Handler {

    private String path = "test.json";
    private String json;

    public void readJSON() {
        try {
            JSONParser parser = new JSONParser();
            //Use JSONObject for simple JSON and JSONArray for array of JSON.
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            String json = data.toJSONString();
            this.json = json;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    //create Json file
    public void createOrAddToJSON(String nickname, Integer gamesPlayed, Integer gamesWon, boolean activeGame, Integer currentGamePosition, Integer currentMaxTiles, String gameID) {
        JSONObject obj = new JSONObject();
        JSONArray data = new JSONArray();
        
        obj.put("nickname", nickname);
        obj.put("gamesPlayed", gamesPlayed);
        obj.put("gamesWon", gamesWon);
        obj.put("activeGame", activeGame);
        obj.put("currentGamePosition", currentGamePosition);
        obj.put("currentMaxTiles", currentMaxTiles);
        obj.put("gameID", gameID);

        data.add(obj);
        try {
            //check if file exists in file system
            File file = new File(path);
            if (file.exists()) {
                //if file exists, add to file
                addToJSON(obj);
            } else {
                //if file does not exist, create file
                FileWriter fileWriter = new FileWriter(path);
                fileWriter.write(data.toJSONString());
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToJSON(JSONObject obj) {
        //add information to already existing json file
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            data.add(obj);

            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //serach for specific user
    public boolean searchForUser(String nickname) {
        try {
            File file = new File(path);
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                JSONArray data = (JSONArray) parser.parse(new FileReader(path));
                for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    return true;
                }
            }
            }
            else {
                return false;
            }
            
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    //update all users information
    public void updateAllUsers(String nickname, Integer gamesPlayed, Integer gamesWon, boolean activeGame, Integer currentGamePosition, Integer currentMaxTiles, String gameID) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("gamesPlayed", gamesPlayed);
                    obj.put("gamesWon", gamesWon);
                    obj.put("activeGame", activeGame);
                    obj.put("currentGamePosition", currentGamePosition);
                    obj.put("currentMaxTiles", currentMaxTiles);
                    obj.put("gameID", gameID);
                    break;
                }
            }

            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void updateGamesPlayed(String nickname, Integer gamesPlayed) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("gamesPlayed", gamesPlayed);
                }
            }
            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //update user games won
    public void updateGamesWon(String nickname, Integer gamesWon) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("gamesWon", gamesWon);
                }
            }
            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //update user active game
    public void updateActiveGame(String nickname, boolean activeGame) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("activeGame", activeGame);
                }
            }
            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //update user current game position
    public void updateCurrentGamePosition(String nickname, Integer currentGamePosition) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("currentGamePosition", currentGamePosition);
                }
            }
            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //update user current max tiles
    public void updateCurrentMaxTiles(String nickname, Integer currentMaxTiles) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("currentMaxTiles", currentMaxTiles);
                }
            }
            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //update user game id
    public void updateGameID(String nickname, String gameID) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    obj.put("gameID", gameID);
                }
            }
            FileWriter file = new FileWriter(path);
            file.write(data.toJSONString());
            file.flush();
            file.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //get user information
    public Object getUserInfo(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    return obj;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get user games played
    public Integer getUserGamesPlayed(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    Integer gamesPlayed = obj.get("gamesPlayed") != null ? ((Long) obj.get("gamesPlayed")).intValue() : null;
                    return  gamesPlayed;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get user games won
    public Integer getUserGamesWon(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    Integer gamesWon = obj.get("gamesWon") != null ? ((Long) obj.get("gamesWon")).intValue() : null;
                    return gamesWon;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get user active game
    public boolean getUserActiveGame(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    boolean activeGame = (boolean) obj.get("activeGame");
                    return activeGame;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    //get user current game position
    public Integer getUserCurrentGamePosition(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    Integer currentGamePosition = obj.get("currentGamePosition") != null ? ((Long) obj.get("currentGamePosition")).intValue() : null;
                    return currentGamePosition;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get user current max tiles
    public Integer getUserCurrentMaxTiles(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    Integer currentMaxTiles = obj.get("currentMaxTiles") != null ? ((Long) obj.get("currentMaxTiles")).intValue() : null;
                    return currentMaxTiles;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get user game id
    public String getUserGameID(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    String gameID = (String) obj.get("gameID");
                    return gameID;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get user nickname
    public String getUserNickname(String nickname) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : data) {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nickname");
                if (name.equals(nickname)) {
                    String userNickname = (String) obj.get("nickname");
                    return userNickname;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getJson() {
        return json;
    }
}



//Project by Vadims "OxCone" Lapins