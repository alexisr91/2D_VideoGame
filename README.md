
# Description

This is one of the most complete project I have ever done until this day. It's a 2D video game based on Pokemon and the French game Slayersonline. There's another version I will push in the near future on another repo

## Tech Stack

**Server Side:** Vanilla Java

**Builder:** Maven


## FAQ

#### Is this a finished project ?

Yes, I will push a project with the same basis but a different version in the near future.


#### Which framework and libraries did you use ? 

I didn't use any framework however I used Java AWT, Java Image I/O to handle my images and generate them.


#### What is the purpose of this project ? 

The purpose of this game is to control a character on a map and to find the treasure in a record time

#### How did you implement the map, the sprites, the animation etc ? 

I used the InputStream and BufferedReader for the map and put my code in a try catch instruction.
For the sprites and animations I used Image I/O and BufferedImage and I put all the images I needed in an array in their respective class and I put them in a switch block to move the character from up to down and from left to right




## Features


- Control the main character and move in 2D
- Center the camera in the middle of the tiles so the character is always centered whenever he moves
- Creation of a map with different elements
- Collision implementation depending on the map elements with redimensioned tiles
- Implementation of keys to open the door put on the map
- Implementation of boot so the character can walk more quickly
- Time checked when the treasure is found
- Notice on any objects found
- Key assignation to control any actions on keyboard
- FPS implementation
- Thread implementation to run the game
- Music importation on loop
- Sound effects on action character




## Color Reference

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
Main Color |![](https://placehold.co/15x15/418930/418930)|
Color's character |![](https://placehold.co/15x15/1859E1/1859E1)|
| Tile first element |![](https://placehold.co/15x15/B0DEED/B0DEED)
Tile second element |![](https://placehold.co/15x15/CC9E4C/CC9E4C)|
Tile third element|![](https://placehold.co/15x15/68A45A/68A45A)|


## Screenshots



![Capture d’écran 2024-07-15 à 15 31 36](https://github.com/user-attachments/assets/7f89ef95-114e-4a27-b27a-50cc7dc9dbdc)

![Capture d’écran 2024-07-15 à 15 30 55](https://github.com/user-attachments/assets/94995841-b92d-4c60-b773-2b91529357f5)

![Capture d’écran 2024-07-15 à 15 31 11](https://github.com/user-attachments/assets/cb8d025b-88b4-4486-b9d8-9a71f1bf9881)
## Roadmap

- Tile -> Thread -> Camera -> Buffer -> Animation -> FPS -> Collision -> Object importation -> Further features



## License

[MIT](https://choosealicense.com/licenses/mit/)

