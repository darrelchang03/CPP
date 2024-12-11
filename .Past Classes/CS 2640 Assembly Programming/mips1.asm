.data
	val: .word 86
.text
	main:
		lw $a0, val
		srl $a1, $a0, 1
		andi $a0, $a0, 85
		andi $a1, $a1, 85
		add $a0, $a0, $a1
		srl $a1, $a0, 2
		andi $a0, $a0, 51
		andi $a1, $a1, 51
		add $a0, $a0, $a1
		srl $a1, $a0, 4
		andi $a0, $a0, 15
		andi $a1, $a1, 15
		add $a0, $a0, $a1
		li $v0, 1
		syscall
		li $v0, 10
		syscall
		
		
		