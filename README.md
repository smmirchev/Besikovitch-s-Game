## Besikovitch's Game

<img src="https://raw.githubusercontent.com/smmirchev/Besikovitch-s-Game/master/Images/Game.png">

### Graphical User Interface

The main frame uses BorderLayout, as this layout will divide the frame in five separate sides (only four are used). Each of these sides is a class that extends a JPanel. All of the panel classes use GridBagLayout, as I find it the best layout for designing and placing the panel elements in the desired way. Also, GridBagLayout by default centers all of its elements, resulting in a pleasing outlook.
The East panel contains an array of JLabels, which is the cards the human player has. The array is looped through and filled with a String array, which contains the cards from Ace to King, when an element(card) is played it is removed by accessing its index. 
The south panel is where the three buttons are. The first button from right to left checks for a valid input and plays the stake card. The second button plays the player’s chosen card for the turn and the third button plays the computer card when it is clicked. 
The center panel shows the current and previous turn of the game. The previous turn is shown by accessing elements from 3 different array lists. These lists are filled with elements which correspond to the stake cards played, human cards played, and computer cards played. 
The north panel shows the number of rounds played and the score for the human player. The score is updated when the "End Turn" button is pressed.

### Game Logic

The choice the computer (AI) makes is always random, except if the stake card is king and the AI has not played king yet. The logic for producing a random number which has a high chance of winning the stake card with minimal cost follows a certain pattern. It checks the value of the stake card, the higher it is, the higher the played card will be. This is implemented by creating a random integer value using Math.random, which then is added to a fixed value in correspondence to the value of the stake card and returned by the method. The number returned is always a new card as the program will access a list of all the numbers played and check if this value is contained in the list. 
