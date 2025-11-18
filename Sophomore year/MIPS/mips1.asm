.text
.globl main


main:
#load vector 1
li $s0, 2
li $s1, 3
li $s2, 2

#load vector 2
li $s3, 1
li $s4, 1
li $s5, 9

li $t0, 4

mul $t1, $s0, $t0
mul $t2, $s1, $t0
mul $t3, $s2, $t0

add $s6, $t1, $s3
add $s7, $t2, $s4
add $t0, $t3, $s5

#print
li $v0, 1
move $a0, $s6
syscall
move $a0, $s7
syscall
move $a0, $t0
syscall