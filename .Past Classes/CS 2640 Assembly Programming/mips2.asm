
.text

main:
	li $t0 180
	li $t1, 225
	xor $t0, $t0, $t1
	xor $t1, $t1, $t0
	xor $t0, $t0, $t1
	 
	move $a0, $t0
	li $v0, 1
	syscall
	
	move $a0 $t1
	syscall