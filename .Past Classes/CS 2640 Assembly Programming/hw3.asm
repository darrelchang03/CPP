.data
	prompt: .asciiz "Enter a number: "
		.align 2
	prompt2: .asciiz "\nEnter an integer n (0-20): "
		.align 2
	prompt3: .asciiz "\nBonus feature since I read the instructions wrong\nEnter an integer n again (0-20): "
	nline:	.asciiz "\n"
		.align 2
	space: .asciiz " "
		.align 2
	myArray: .space 80
.text
	# clearing offset $t0
	move $t0, $zero
	# clearing $t1 
	move $t1, $zero
	# clearing $t2
	move $t2, $zero
	
	# prompt the user to enter 20 numbers
input:	li $v0, 4
	la $a0, prompt
	syscall
	# get the users number
	li $v0, 5
	syscall
	# store user's number into $s0
	move $s0, $v0
	# store word into array
	sw $s0, myArray($t0)
	# incrementing our pointer to go to the next byte in our array
	addi $t0, $t0, 4
	# if we have gotten user input less than 20 times, we reprompt user for the next number to store in the array
	blt $t0, 80, input
	
	# reset $t0 to 0(array pointer)
	move $t0, $zero
	# moving integer at array pointer into $a0 and print
print1:	li $v0, 1
	lw $a0, myArray($t0)
	syscall
	# increment pointer to next integer in array
	addi $t0, $t0, 4
	# print new line
	li $v0, 4
	la $a0, nline
	syscall
	# loop until we have looped 20 times
	blt $t0, 80, print1

	# reset $t0 to 0(array pointer)
	move $t0, $zero
	# moving integer at array pointer into $a0 and print
print2:	li $v0, 1
	lw $a0, myArray($t0)
	syscall
	# increment pointer
	addi $t0, $t0, 4
	# print space
	li $v0, 4
	la $a0, space
	syscall
	# loop until we have looped 20 times
	blt $t0, 80, print2
	#reset $t0 and $t1 to 0 (array pointer and loop counter)
	move $t0, $zero
	move $t1, $zero
	
	# prompt user for number n (1-20)
input2:	li $v0, 4
	la $a0, prompt2
	syscall
	# take user input
	li $v0, 5
	syscall
	# if user input is not 0 < n <= 20 then reprompt by branching back to input2
	blez  $v0, input2
	bgt $v0, 20 input2
	# store input*4 into $t1
	mul $t1, $v0, 4
	# print value at pointer of myArray
print3:	li $v0, 1
	lw $a0, myArray($t0)
	syscall
	# increment pointer
	addi $t0, $t0, 4
	# print space
	li $v0, 4
	la $a0, space
	syscall
	#increment counter
	addi $t2, $t2, 4
	#escape loop if n >= 80 (when we have interated through all integers in array)
	bge $t0, 80, endprint3
	# loop if counter < n number of loops
	blt $t2, $t1, print3
	# print new line
	li $v0, 4
	la $a0, nline
	syscall
	# reset counter to 0
	move $t2, $zero
	# go back to print3 if n is less than 80
	blt $t0, 80, print3
endprint3:

	#reset $t0 pointer
	move $t0, $zero
input3:	li $v0, 4
	la $a0, prompt3
	syscall
	# take user input
	li $v0, 5
	syscall
	# if user input is not 0 < n <= 20 then reprompt by branching back to input2
	blez  $v0, input3
	bgt $v0, 20 input3
	# store input*4 into $t1
	mul $t1, $v0, 4
	# print value at pointer of myArray
print4:	li $v0, 1
	lw $a0, myArray($t0)
	syscall
	# increment pointer
	addi $t0, $t0, 4
	# print space
	li $v0, 4
	la $a0, space
	syscall
	# loop until we have looped n times
	blt $t0, $t1, print4
	# print new line
	li $v0, 4
	la $a0, nline
	syscall
	#decrement n
	addi $t1, $t1, -4
	#reset $t0 to 0
	move $t0, $zero
	# go back to print4 if n is still positive
	bgtz $t1, print4
	
exit: 	li $v0, 10
	syscall

	
	
