#include<stdio.h>
#include<string.h>
#include<memory.h>


#include<iostream>
#include<cstdio>
#include<stack>
#include<string>
using namespace std;
//http://blog.csdn.net/hackbuteer1/article/details/7442724
string reverse(string str)
{
	stack<char> stk;
	int len = str.length();
	string ret = "";

	for (int p = 0, q = 0;p < len;)
	{
		if (str[p] == ' ')
		{
			ret.append(1,' ');
			for (q = p; q < len && str[q] == ' '; q++)
			{}
			p = q;
		}
		else
		{
			for (q = p; q < len && str[q] != ' '; q++)
			{
				stk.push(str[q]);
			}
			while(!stk.empty())
			{
				ret.append(1,stk.top());
				stk.pop();
			}
			p = q;
		}
	}
	return ret;
}
int main(void)
{
	string s = "abc def   ghi";
	cout<<reverse(s).c_str()<<endl;
	return 0;
}
