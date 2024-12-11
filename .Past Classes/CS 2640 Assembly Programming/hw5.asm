
	# Darrel Chang 11/24/22
.data
	seed: 	. word 2514
	welcome: .asciiz " \nWelcome to Chuck-a-Luck\nEnter a seed number: "
	betPrompt: .asciiz "\nEnter wage amount: "
	errLow: .asciiz "Try again"
	tooLow: .asciiz "Wager must not be negative, try again"
	tooHigh: .asciiz "Insufficient funds, lower wager amount to be equal to or less than current funds"
	holdMsg: .asciiz "\nYou currently have $"
	numbPrompt: .asciiz "Enter a number to bet on (1-6): "
	guessLow: .asciiz "The number entered was less than 1"
	guessHigh: .asciiz "The number entered was greater than 6"
	funds: .asciiz "You currently have $"
	Irolled: .asciiz "I rolled"
	space: .asciiz " "
	gameOver: .asciiz "Game Over!\nNo funds left to wager"
	newLine: .asciiz "\n"
	three:	.asciiz "You matched three times! Congratulations!"
	two:	.asciiz "You matched two times"
	one:	.asciiz "You matched only once and got your bet back"
	none:	.asciiz "Better luck next time! You did not match any dice"
	.align 2
.text
	main:		li $v0, 4
			la $a0, welcome
			syscall
			li $v0, 5		# getting input from user to store as the seed
			syscall
			sw $v0, seed		# store user input 
			li $t1, 500		# initialize t1 to $500 for starting funds
		start:	li $v0, 4
			la $a0, funds		# Display amount of funds left
			syscall
			li $v0, 1
			move $a0, $t1
			syscall
			jal getWager		# call get wager and store it in $t2
			move $t2, $v0
			sub $t1, $t1, $t2
			jal getGuess		# call get guess and store in $t3
			move $t3, $v0
			li $t4, 3		# initialize $t4 to 3 to use as loop counter for rolling rice
			li $v0, 4
			la $a0, Irolled		# Display 
			syscall
			li $t5, 0		# Reset number of matches counter to 0
		dice:	jal rand
			move $t6, $v0		# moving the number rolled to $t6, so we can free up $v0 to do a syscall
			li $v0, 4		# print a space
			la $a0, space
			syscall
			move $a0, $t6		# move the number rolled to the $a0 to be displayed to user
			li $v0, 1
			syscall
			addi $t4, $t4, -1
			bne $t3, $t6, noMatch
			addi $t5, $t5, 1	# if there is a match to the guess, we increment counter that tracks number of matches
		noMatch:bgtz $t4, dice		# if loop counter is still positive we loop back to roll another dice
			li $v0, 4
			la $a0, newLine
			syscall
			bne $t5, 3, skip1	# if we did not match 3 times, we skip to the next check
			jal thrice		# This instruction is executed if we matched 3 times, so we jal to thrice
		skip1:	bne $t5, 2, skip2	# if we did not match 2 times, we skip to the next check
			jal twice		# This instruction is executed if , we matched 2 times, so we jal to twice
		skip2:	bne $t5, 1, skip3	# if we did not match once, skip to next check
			jal once		# This insruction is executed if we matched once, so we jal to once
		skip3:	bne $t5, 0, skip4	# if we dd not match at all, skip next instruction
			jal nonce		# This instruction is executed if we did not match, jal to nonce
		skip4:	bnez $t1, start		# If we still have funds, we jump back to the beginning of the program again, if not we continue to end section
		end: 	li $v0, 4		
			la $a0, gameOver	# Printing prompt saying user ran out of funds
			syscall
			li $v0, 10		# ending program gracefully
			syscall
 	# One of these set of routines is executed depending on how many of the 3 dices their bet matched
	thrice:		li $v0, 4
			la $a0, three		# Display message saying they matched 3 times
			syscall
			add $t1, $t1, $t2	# add 3x their wager to funds
			add $t1, $t1, $t2
			add $t1, $t1, $t2
			li $v0, 4
			la $a0, newLine		# print new line
			syscall
			jr $ra
	twice:		li $v0, 4		# Display message saying they matched 2 times
			la $a0, two
			syscall
			add $t1, $t1, $t2	# add 2x their wager to funds
			add $t1, $t1, $t2
			li $v0, 4		# print new line
			la $a0, newLine
			syscall
			jr $ra
	once:		li $v0, 4		# Display message saying they matched 1 time
			la $a0, one	
			syscall
			add $t1, $t1, $t2	# add 1x their wager to funds
			li $v0, 4		# print new line
			la $a0, newLine
			syscall
			jr $ra
	nonce:		li $v0, 4		# Display message saying they matched 0 times
			la $a0, none
			syscall
			li $v0, 4		# print new line
			la $a0, newLine
			syscall
			jr $ra
	# this helper routine gets a wager from the user that is positive and within their amount of funds
	# before calling put funds into $t1
	getWager:	li $v0, 4 		# Displaying prompt to enter wager amount
			la $a0, betPrompt
			syscall
			li $v0, 5		# Receving user input
			syscall
			move $t0, $v0
			beqz $t0, exit		# If user unput is zero, it is accepted
			bltz $t0, wagerLow	# If user unput is negtive, reprompt for wager
			bgt $t0, $t1, wagerHigh	# If user input is higher than amount of funds, repromt for wager
		exit:	move $v0, $t0		# User input is accepted, exit routine
			jr $ra
		wagerLow: li $v0, 4		
			la $a0, tooLow		# Display wager to low error
			syscall
			j getWager		# Jump back to getWager to prompt for wager again
		wagerHigh:li $v0, 4	
			la $a0, tooHigh		# Display wager too high error
			syscall
			j getWager		# Jump back to getWager to prompt for wager again
	# This helper routine gets the number the user wants to bet on between 1-6
	getGuess:	li $v0, 4
			la $a0, numbPrompt	# Displaying prompt to enter number to bet on
			syscall
			li $v0, 5		# Receiving user input
			syscall
			blez $v0, invalidLow	# IF input is less than 1, display error message and reprompt for bet
			bgt $v0, 6, invalidHigh	# IF input is greater than 6, display error messge and repormpt for bet
			jr $ra
		invalidLow:li $v0, 4		
			la $a0, guessLow	# Display bet too low
			syscall
			j getGuess		# Jump back to getGuess to prompt for number to bet on again
		invalidHigh: li $v0, 4
			la $a0, guessHigh	# Display bet too high
			syscall
			j getGuess		# Jump back to getGuess to prompt for number to bet on again
	# This helper routine mimics a dice roll by outputing a random number between 1-6
	rand:		lw $v0, seed		# getting the seed and putting it in $v0
			sll $t0, $v0, 13	# a bunch of operations to get a random number
			xor $v0, $v0, $t0
			srl $t0, $v0, 17
			xor $v0, $v0, $t0
			sll $t0, $v0, 5
			xor $v0, $v0, $t0
			sw $v0, seed		# setting our random number to be the new seed, inorder to get psudo random numbers
			andi $v0, $v0, 0xFFFF	
			li $t0, 6
			div $v0, $t0		# dividing the random number we get by 6
			mfhi $v0		# getting the remainder which should be between 0-5 to $v0
			addi $v0, $v0, 1	# adding 1 to the number to get a random number between 1 and 6
			jr $ra			
		
