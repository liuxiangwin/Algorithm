#include<stdio.h>
#include<string.h>
#include<memory.h>

int findContinuousCharacter(char *pStr)
{
//     int nLength = strlen(pStr);
//     if(nLength == 1) return 1;

     if(*pStr == '\0') return 0;
     if(*(pStr + 1) == '\0') return 1;

     if(*pStr == *(pStr + 1))
    	 return 1 + findContinuousCharacter(pStr + 1);

     return find(pStr + 1);
}
int main()
{
     char str[] = "daac";
     cout<<find(str)<<endl;
}
