# lotto-for-mortals
A java program that tests whether it's statistically a good idea for mortals
to play the lottery, by Ville Salin

This program was created as part of an introduction to programming course at the Tampere University of Applied Sciences. It is divided into multiple classes that contain methods written as part of the assignment.

The program first checks if the user has provided their lottery numbers as arguments.
If not, the program asks for them individually, ensuring all fall within the specified parameters.
Next it uses Math.random to create an array of winning numbers, which it compares to the one provided by the user.
It announces how many years it takes for the player to first hit x correct numbers.
It finally terminates when the player has hit the jackpot within 120 years. 
Spoiler Alert: It will take a long, long time.