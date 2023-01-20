# Author: Vadims Lapins
# Deadly Tiles v1.0.0

Idea of the game is taken from the Netflix TV series called "Squid game".
One of the challenges was to jump from tile to tile, only choosing between 2 of them.

My implementation looks something like this:

|[+] [+]
|  [-]
|[+] [+]
|  [-]
|[+] [+]
|  [-]
|[+] [+]
|  [-]
|[+] [+]
|[Start]

Where:
[+] — Tiles that have a 50% chance probability of braking when being jumped on.
[-],[Start] — Safe places where you can stand unlimited amount of time (checkpoints).
From safe places user has to chose whether jump to the right or to the left.

The game itself is really hard to be completed, because probability of making it without ever dropping down is 3,125%.

When you select wrong tile to jump to the game ends.
Game has a functionality to resume stopped game, if it wasn't lost.
Supports multiple user information storage.
User can be changed at any time with specific command.
The game scenario(sequence that tells which tiles are stable and which are not) sequence is encrypted, so user can't access/cheat the order of the tiles.

### Request information

POST http://localhost:8080/createPlayer?nickname=USERNAME - to create user and immideatelly switch to the newly created game profile

POST http://localhost:8080/switchPlayer?changeTo=USERNAME - switch to already created user profile 
**WHEN YOU RESTART THE SERVER YOU HAVE TO LOGIN(SWITCH PLAYERS) TO AN EXISTING USER ACCOUNT OR CREATE A NEW ONE** 

GET http://localhost:8080/player?nickname=USERNAME - to retrive information about player from the local file storage

POST http://localhost:8080/game?nickname=USERNAME - create an encypted game id and add it to the player profile (can be checked with previous commands)
***DO NOT RUN WILE YOU HAVE AN ONGOING GAMES, IT WILL REWRITE THEM*** 

PUT http://localhost:8080/game?nickname=USERNAME&moveDirection=USERCHOISE -
USERCHOICE - either "left" or "right", user plays one round(makes 1 jump) and by end of it either will be able to continue to play the same game or will be kicked out of the game, forced to create a new one to if wants to continue playing.

P.S. JSON_Handler.java has some warnings from Java, but I couldn't figure out how to get rid of them.

# Project by Vadims "OxCone" Lapins