# Buffer overflow on vuln.c
## Compile vuln.c with: gcc -fno-stack-protector -z execstack -no-pie vuln.c -o vuln
## Make sure aslr is disabled with: sudo sysctl -w kernel.randomize_va_space=0
## ./pgen.sh will exploit vuln and do the rest.
## The shellcode which uses an execve system call was written by me.
