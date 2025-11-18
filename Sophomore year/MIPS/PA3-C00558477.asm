.data
oArr: .word
nArr: .word

.text
.globl main

main:
#i = 0
li $t0,0
#start value
li $t4,100
#increment
li $s0,50
#array adress
li $t5,0

li $s1, 0


oArrloop_start:
slti $t1,$t0,10

beq $t1,$zero,oArrloop_end

#loading oArr into $t3
la $t3,oArr


#incrementing array adress
sll $t5,$t0, 2
add $t6,$t3,$t5
#inserting incremented start value into the array adress
sw $t4,($t6)

#printing current start value
li $v0, 1
move $a0, $t4
syscall

#printing space
li $v0, 11
li $a0, 32
syscall

#incrementing starting value
add $t4,$t4,$s0

#incremetnig i
addi $t0,$t0,1

#loop
j oArrloop_start

oArrloop_end:
li $t0, 0
li $v0, 10

#printing new line 
li $v0, 11
li $a0, 10
syscall

nArrloop_start:
slti $t1,$t0,10
beq $t1,$zero,nArrloop_end


#loading nArr into $t3
la $t3,nArr

#getting array adress of middle value
sll $t5,$t0, 2
add $t6,$t3,$t5

#getting left index of middle value
subi $t7, $t6, 4
#getting right index of middle value
addi $t8, $t6, 4

lw $t9, ($t6)
lw $t7, ($t7)
lw $t8, ($t8)

add $t9, $t9, $t7
add $t8, $t8, $t9

li $t2, 3


div $t8, $t2
mflo $t8


#inserting average value into the array adress
sw $t8,($t6)

li $v0, 1
move $a0, $t8
syscall

#printing space
li $v0, 11
li $a0, 32
syscall

#incremetnig i
addi $t0,$t0,1
#loop
j nArrloop_start

nArrloop_end:
li $v0, 10
