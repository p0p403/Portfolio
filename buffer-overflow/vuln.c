#include <stdio.h>
main() {
	char buf[123];
	extern char *gets(char *);
	puts(gets(buf));
}
