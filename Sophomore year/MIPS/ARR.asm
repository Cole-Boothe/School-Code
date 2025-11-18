.data
arr: .word 10, 20, 30, 40, 50

.text
.globl main

main:
la $s0, arr

lw $t0, 16($s0)


li $v0, 1
move $a0, $t0
syscall