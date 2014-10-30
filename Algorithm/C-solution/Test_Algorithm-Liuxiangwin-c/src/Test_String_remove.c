#include<stdio.h>
#include<string.h>
#include<memory.h>
void delete_ch(char *src, char *del_chs) {
	int hash[256];
	int i;
	char *p_slow, *p_fast;
	int del_len = strlen(del_chs);
	p_slow = src;
	p_fast = src;
	memset(hash, 0, sizeof(int) * 256);
	for (i = 0; i < del_len; i++)
		hash[del_chs[i]] = 1;
	while (*p_fast) {
		if (hash[*p_fast] == 1) {
			p_fast++;
		}
		*p_slow++ = *p_fast++;
	}
	*p_slow = '\0';
}
void main() {
	char src[] = "They are students";
	char del_chs[] = "aeiou";
	delete_ch(src, del_chs);
	printf("%s\n", src);
}
