section .data

section .text
  global _start

;strace of good execve /bin/sh syscall to see syscall parameters
;execve("/bin//sh", NULL, NULL)

;Syscall Table Entry for execve 64 Bit Linux
;System Call            sys_execve
;%rax                   59
;%rdi                   const char *filename
;%rsi                   const char *const argv[]
;%rdx                   const char *const envp[]
;%r10
;%r8
;%r9

;int execve(const char *pathname, char *const argv[], char *const envp[]);

    _start:
      xor rbx, rbx        ;clear rbx register
      push rbx            ;push null to stack
      mov rbx,'/bin//sh'  ;const char *filename
      push rbx            ;push value of rbx register to top of stack

      push rsp            ;rsp register points to top of stack
                          ;rsp is a pointer to an array of pointers (string)
                          ;pushing adds this pointer of a pointer to top of stack

      pop rdi             ;pointer of pointer from top of stack gets put in rdi
                          ;const char *filename

      xor rsi, rsi        ;const char *const argv[] - set to NULL
      xor rdx, rdx        ;const char *const envp[] - set to NULL
      mov al, 59          ;rax 59
      syscall
