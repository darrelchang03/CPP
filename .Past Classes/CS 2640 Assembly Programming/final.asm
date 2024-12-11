# Darrel Chang
.data
	wid:     .word 10    # Length of one row, must be 4n - 1
	hgt:     .word 10    # Number of rows
	cx:     .word 1
	cy:     .word 1
	numLeft:      .word 0
	board:     .space 1600    # Max 40 x 40 maze
	seed:    .word 31415     # An initial value, in case seedrand wasn't called
	
	widthPrompt: .asciiz "Enter the width of the board: "
	heightPrompt: .asciiz "Enter the height of the board: "
	seedPrompt: .asciiz "Enter a seed: "
	
.text
	main:
		li $v0, 4
		la $a0, seedPrompt
		syscall
		li $v0, 5
		syscall
		move $a0, $v0
		jal seedrand
		jal getSize
		jal initBoard
		jal pickEntrance
		
		li $v0, 10
		syscall
		
	
	########################################################################
	# Function Name: getSize
	########################################################################
	# Functional Description:
	#    Ask the user for the size of the maze.  If they ask for a dimension
	#    less than 5, we will just use 5.  If they ask for a dimension greater
	#    than 40, we will just use 40.  This routine will store the size into
	#    the globals wid and hgt.
	#
	########################################################################
	# Register Usage in the Function:
	#    $t0 -- Pointer into the board
	#    $t1, $t2 -- wid - 1 and hgt - 1, the values for the right edge and
	#     bottom row.
	#    $t3, $t4 -- loop counters
	#    $t6 -- the value to store
	#
	########################################################################
	# Algorithmic Description in Pseudocode:
	#    1. Prompt for the two values
	#    2. Fetch each of the two values
	#    3. Limit the values to the range 5 <= n <= 40
	#    4. Store into wid and hgt
	#
	########################################################################
	
	getSize:
		width:	li $v0, 4
			la $a0, widthPrompt	# Prompt message to enter desired width
			syscall
			li $v0, 5		# Retrieves integer input
			syscall
			blt $v0, 5, width	# If input < 5 reprompt and retreive input
			bgt $v0, 40, width	# If input > 40 reprompt and retreive input
			sw $v0, wid		# 5 <= input <= 40, store input in wid
		height:	li $v0, 4
			la $a0, heightPrompt	# prompt message to enter desire height
			syscall
			li $v0, 5		# Retreives interger input
			syscall
			blt $v0, 5, height	# If input < 5 reprompt and retreive input
			bgt $v0, 40, height	# If input > 40 reprompt and retreive input
			sw $v0, hgt		# 5 <= input <= 40, store input in wid
			jr $ra
		
	########################################################################
	# Function Name: initBoard
	########################################################################
	# Functional Description:
	#    Initialize the board array.  All of the cells in the middle of the
	#    board will be set to 0 (empty), and all the cells on the edges of
	#    the board will be set to 5 (border).
	#
	########################################################################
	# Register Usage in the Function:
	#    $t0 -- Pointer into the board
	#    $t1, $t2 -- wid - 1 and hgt - 1, the values for the right edge and
	#     bottom row.
	#    $t3, $t4 -- loop counters
	#    $t6 -- the value to store
	#
		########################################################################
	# Algorithmic Description in Pseudocode:
	#    1. Set $t0 to point to the board
	#    2. Build nested loops for each row and column
	#     2a. If we are in the first or last iteration of either loop,
	#     place a 5 in the board.
	#     2b. Otherwise, place a 0 in the board
	#     2c. Increment $t0 after each placement, to go to the next cell.
	#
	########################################################################
	
	initBoard:
			la $t0, board		# Set $t0 to point to begining of board's memory address
			lw $t1, wid		# Set $t1 to width size
			lw $t2, hgt		# Set $t2 to height size
			li $t3, 0		# Initiallize loop counter for wid
			li $t4, 0		# Initiallize loop counter for hgt
			li $t5, 5
			
		for1:   	beq $t4, $t2, exit
				bne $t4, 0, skip5
				bne $t2, $t4, skip5
				bnez $t3 skip
				bne $t4, $t2, skip
				sw  $t5, board
			skip5:	sw $zero, board
				la $t0, 4($t0)
				addi $t4, $t4, 1
				li $t3, 0
				j for2
		for2:		beq $t3, $t1, for1
				bnez $t3 skip
				bne $t4, $t2, skip
				bne $t4, 0, skip
				bne $t2, $t4, skip
				sw $t5, board
			skip:	sw $zero, board
				la $t0, 4($t0)
				addi $t3, $t3, 1
				j for2
			exit: 	jr $ra
			
			
				
				
				
	
	########################################################################
	# Function Name: placeInSquare
	########################################################################
	# Functional Description:
	#    A value is passed in $a0, the number to be placed in one square of
	#    the board.  The global variables cx and cy indicate which square.
	#
	########################################################################
	# Register Usage in the Function:
	#    $a0 -- The value to be placed
	#    $t0, $t1 -- general computations
	#
	########################################################################
	# Algorithmic Description in Pseudocode:
	#    1. compute the effective address, board + cy * wid + cx
	#    2. Store the byte in $a0 at this address.
	#
	########################################################################
	
		placeInSquare:
					la $t0, board
					lw $t1, cx
					lw $t2, cy
					lw $t3, wid
					mult $t2, $t3
					mflo $t2
					add $t1, $t2, $t1
					sll $t1, $t1, 2
					add $t0, $t0, $t1
					sw $a0, ($t0)
					jr $ra
					
	########################################################################
	# Function Name: pickEntrance
	########################################################################
	# Functional Description:
	#    This picks the entrance for the maze.  It goes to one of the
	#    cells on the north edge of the map (inside the border), then changes
	#   it's value from 0 (empty) to 1 (came from north).
	#    This routine will exit with cx, cy set to the cell, so we are ready
	#    to find a path here through the maze.
	#
	########################################################################
	# Register Usage in the Function:
	#    $a0, $v0 -- used for syscall linkage, and calculations
	#    We save $ra on stack, because we call the rand and placeInSquare
	#   functions
	#
	########################################################################
	# Algorithmic Description in Pseudocode:
	#    1. Save $ra on the stack
	#    2. Pick a random column, from 1 to wid - 1
	#    3. Place '1' in the chosen border cell
	#    4. Restore the $ra value
	#
	########################################################################
	pickEntrance:
		addi $sp, $sp, -4	#allocate space on the stack for return address, since this routine will be calling other routines
		sw   $ra, 0($sp)	# store current ra on the stack
		lw $a0, wid		# set $a0 to be wid, for when we call rand(int n)
		jal rand	
		bnez $v0, skip0		# if the collumn number from rand is 0, add 1 to it
		addi $v0, $v0, 1	
	skip0:	sw $v0, cy		# store collumn number (1 to wid-1) in cy
		li $a0, 1		# load $a0 with 1 for placeInSquad(int n)
		jal placeInSquare
		lw $ra, 0($sp)		# set return address to address saved on stack
		jr $ra			# return to $ra
	########################################################################
	# Function Name: int rand()
	########################################################################
	# Functional Description:
	#    This routine generates a pseudorandom number using the xorsum
	#    algorithm.  It depends on a non-zero value being in the 'seed'
	#    location, which can be set by a prior call to seedrand.  For this
	#    version, pass in a number N in $a0.  The return value will be a
	#    number between 0 and N-1.
	#
	########################################################################
	# Register Usage in the Function:
	#    $t0 -- a temporary register used in the calculations
	#    $v0 -- the register used to hold the return value
	#    $a0 -- the input value, N
	#
	########################################################################
	# Algorithmic Description in Pseudocode:
	#    1. Fetch the current seed value into $v0
	#    2. Perform these calculations:
	#     $v0 ^= $v0 << 13
	#     $v0 ^= $v0 >> 17
	#     $v0 ^= $v0 << 5
	#    3. Save the resulting value back into the seed.
	#    4. Mask the number, then get the modulus (remainder) dividing by $a0.
	#
	########################################################################	
		
	rand:
    		lw     $v0, seed     # Fetch the seed value
    		sll     $t0, $v0, 13    # Compute $v0 ^= $v0 << 13
    		xor     $v0, $v0, $t0
    		srl     $t0, $v0, 17    # Compute $v0 ^= $v0 >> 17
    		xor     $v0, $v0, $t0
    		sll     $t0, $v0, 5     # Compute $v0 ^= $v0 << 5
    		xor     $v0, $v0, $t0
    		sw     $v0, seed     # Save result as next seed
    		andi    $v0, $v0, 0xFFFF    # Mask the number (so we know its positive)
    		div     $v0, $a0     # divide by N.  The reminder will be
    		mfhi    $v0     # in the special register, HI.  Move to $v0.
    		jr     $ra     # Return the number in $v0
    	########################################################################
	# Function Name: seedrand(int)
	########################################################################
	# Functional Description:
	#    This routine sets the seed for the random number generator.  The
	#    seed is the number passed into the routine.
	#
	########################################################################
	# Register Usage in the Function:
	#    $a0 -- the seed value being passed to the routine
	#
	########################################################################
    	seedrand:
    		sw $a0, seed	# set seed to the input in register $a0
    		jr $ra
    		

	########################################################################
	# Function Name: printBoard
	########################################################################
	# Functional Description:
	#    This prints the final maze to the console
	#
	########################################################################
	# Register Usage in the Function:
	#    $a0, $v0 -- used for syscall linkage
	#    $t8 -- pointer to first cell in current row
	#    $t9 -- loop counter for rows
	#    $t7, $t6 -- pointers to neighboring cells as we scan rows
	#    $t5 -- loop counter for columns
	#    $t0, $t1 -- general computations
	#
	########################################################################
	# Algorithmic Description in Pseudocode:
	#    1. Loop for each row on the board.  $t8 will point to the first cell
	#     in the row, and $t9 is the loop counter.
	#     1a.    Loop for each column, printing the north wall/door.  $t7 will
	#     point to the north cell, $t6 to the south cell, and $t5 is
	#     loop counter.
	#     1a1. If board[$t7] came from south or board[$t6] came from
	#     north, print open door.  Otherwise print wall.
	#     1b. At end of row, print closing char and newline.
	#     1c. If we are in the last row of the board, don't print the 'cells'
	#     at the bottom edge, they are the border of the map.  Skip
	#     steps 1d and 1e.
	#     1d.    Loop for each column, printing the west wall/door.  $t7 will
	#     point to the west cell, $t6 to the east cell, and $t5 is
	#     loop counter.
	#     1d1. If board[$t7] came from east or board[$t6] came from
	#     west, print open door.  Otherwise print wall.
	#     1e. At end of row, print closing char and newline.
	#
	########################################################################
	    		
	    	
	printBoard:
				    		
    	
			