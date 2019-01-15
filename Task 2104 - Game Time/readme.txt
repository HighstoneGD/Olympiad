Vasya bought a new computer game. With the passage of the game you need to complete several missions. What exactly will be the next mission, is fully determined by the result of the previous one. For each mission, there is a single sequence of missions that must be passed from the start of the game to get into a given mission.

Since Vasya is a real "gamer", he decided not just to go through the game from the beginning to one of the possible endings, but to go through all the missions of the game. To do this, he has to start the game again after reaching the end of the game and, starting with a certain mission, follow the branches of the plot that he did not go before.

In total, there are N missions in the game, numbered from 1 to N. The game begins with mission number 1. Each mission will take minutes from Vasya Ti, even if he passed it in one of the previous game launches. Help Vasya calculate the minimum number of minutes he will spend on completing all the missions in the game.

Input data:

The first line of the input contains an integer N (1 ? N ? 100). The second line contains space-separated information about the time it takes for each mission to complete (1 ? Ti ? 100) in order (1 ? i ? N). The third line contains an integer M = (N - 1) - the number of transitions between missions. The transition time between missions and the restart time of the game should be considered equal to zero. Each of the following M lines contains two numbers — F and T, meaning that mission T can be reached only by completing mission F. All T values ??are different.

Output:

Print the minimum amount of time it takes Vasya to complete all the missions of the game.