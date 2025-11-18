.text
.globl main

main:
li $s0 9

sll $s1 $s0 1

mul $t0 $s0 $s0


li $t1 10000343
li $t2 300253
mult $t1 $t2

li $t1 9
li $t2 4
div $t1 $t2


# li $v0 1


mflo $a0
#syscall

move $a0 $t0
#syscall

li $s3 9 # i
li $s4 9 # j
li $s0 1 
li $s2 2
li $s3 3

li $v0 1
 bne $s3 $s4 else # if i == j
 add $s0 $s1 $s2 # f = g + h
 move $a0 $s0
 syscall

 else:
    sub $s0 $s1 $s2 # f = g-h
    move $a0 $s0
    syscall