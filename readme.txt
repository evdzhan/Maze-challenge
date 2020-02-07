Assumptions made:

1. No visual GUI. After reading the two user stories, for MVP for the project, I've settled with a command line program.
The user input dictates what happens, and the responses at all time show what is going on at
the moment. The program assumes that no visual representation of the program has to be shown, but rather textual
representation of the states is sufficient. Technically showing the grid using a Swing based application is within my
coding capabilities, doing so would be far more time consuming.

2. Maze is not automated. This is not AI-inspired path finding algorithm. Rather this is an simple exploration program with
the maze loaded dynamically at run time.

3. 2D Maze. Another assumption the program makes is that the maze is always two dimensional. While coding for
higher dimensions is also possible, I've settled for 2D only.



*** Program Explained ***

There are two modes of the program. Each covering each user story.

Story 1

The first mode is when the program is initially started. The program loads the default maze provided in the requirements.
It is possible to open another maze, but that must be found in the resources folder as well. When the maze is loaded,
validation is performed to validate User Story 1 - Acceptance Criteria (1) (AC1 for short). The first mode is also
able to show statistics and query specific locations, those correspond to AC2 and AC3, respectively.

Story 2

The second mode is more complicated and allows multiple actions to be taken at any point. When the second mode is
initiated, by pressing E,  a fictional, nameless explorer is dropped onto the starting position of the Maze.
She/he is facing north by default. This covers AC1. All other Acceptance Criteria for Story 2 are covered
by single action that can be taken by sending the corresponding command to the console.
Each shows output to allow the player to see what is happening. For example AC2 is covered by sending M letter,
 while left and right turns are performed by sending L and R, respectively.




Below, are the AC's as extracted from the MazeTest.txt file.

Story 1 - Acceptance Criteria

(1) A Maze (as defined in Maze1.txt consists of walls 'X', Empty spaces ' ', one and only one Start point 'S' and one and only one exit 'F'
(2) After a maze has been created the number of walls and empty spaces should be available to me
(3) After a maze has been created I should be able to put in a co ordinate and know what exists at that point

Story 2 - Acceptance Criteria

(1) Given a maze the explorer should be able to drop in to the Start point (facing north)
(2) An explorer on a maze must be able to move forward
(3) An explorer on a maze must be able to turn left and right (changing direction the explorer is facing)
(4) An explorer on a maze must be able to declare what is in front of them
(5) An explorer on a maze must be able to declare all movement options from their given location
(6) An explorer on a maze must be able to report a record of where they have been in an understandable fashion
