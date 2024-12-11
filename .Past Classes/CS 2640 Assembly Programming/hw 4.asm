# Darrel Chang
.data
promptr: .asciiz "Enter an integer r (r>=0): "
promptn: .asciiz "Enter an integer n (n>=r): "
r:  .word 0
n:   .word 0
.align 2
.text
.globl main
main:
# get number r from user
getr:
# prompt the user
li $v0, 4
la $a0, promptr
syscall
#get integer r from user
li $v0, 5
syscall
# if r is less than 0, reprompt
bltz $v0, getr
# with a valid input, we store it into variable r
sw   $v0, r
# storing r in temp register to compare to input for n later
lw   $t0, r
getn:
# prompt the user
li $v0, 4
la $a0, promptn
syscall
# get integer n from user
li $v0, 5
syscall
# if n is less than r, reprompt user for n
blt $v0, $t0, getn
sw $v0, n
# Calling the comb function
# load n into $a0 for first parameter
lw $a0, n
# load r into $a1 for second paramete
lw $a1, r
#calling comb
jal comb
# Display results of comb
move $a0, $v0
li $v0, 1
syscall
# end program
li $v0, 10
syscall
#### comb function ####
# arguments: 
#    $a0: int n 
#    $a1: int r
# return value:
#    $v0: comb(n-1, r) + comb(n-1, r-1)
.globl comb
comb:
# allocating 4 spots on the stack ($ra, argument1, argument2, temp
addi $sp, $sp, -16
# storing return address at the stack pointer
sw   $ra, ($sp)
# storing arg1 in 1 word offset from stack pointer
sw   $a0, 4($sp)
# storing arg2 in 2 word offset from stack pointer
sw   $a1, 8($sp)
# Base Cases
# if n == r then jump to done
li $v0, 1
beq $a0, $a1, done
# if r == 0 then jump to done
beqz $a1, done
# computer comb(n-1, r) store in temp
lw   $a0, 4($sp)     #loading argument 1 (n) from arg value saved on stack
addi $a0, $a0, -1    # decrementing n to get n-1
jal comb             # calling comb function with aruments (n-1, r)
sw   $v0, 12($sp)    # return value saved on stack spaced allocated for temp 
# recursibly calling comb (n-1, r-1)
lw   $a0, 4($sp)       # loading argument 1 from arg value saved on stack
addi $a0, $a0, -1      # decrementing to get n-1
lw   $a1, 8($sp)       # loading argument 2 from arg value saved on stack
addi $a1, $a1, -1 # decrementing to get r-1
jal comb               # calling comb function with args (n-1, r-1)
lw   $a0, 12($sp)      # moving temp value from comb(n-1, r) to $a0
add  $v0, $a0, $v0     # adding comb(n-1,r) with comb(n-1, r-1)
# Restoring The Stack
# loading return address from stack into $ra
done:   lw $ra, ($sp)
# moving stack values back to input registers
lw $a0, 4($sp)
lw $a1, 8($sp)
# moving stack pointer
addiu $sp, $sp, 16
# jump to return
jr $ra