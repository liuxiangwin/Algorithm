/*
 ============================================================================
 Name        : Test_Algorithm-Liuxiangwin-c.c
 Author      : liuxiangwin
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
//http://stackoverflow.com/questions/22952651/explain-using-xor-to-find-two-non-duplicate-integers-in-an-array
/* This finction sets the values of *x and *y to nonr-epeating
 elements in an array arr[] of size n*/
void get2NonRepeatingNos(int arr[], int n, int *x, int *y) {
	int xor = arr[0]; /* Will hold xor of all elements */
	int set_bit_no; /* Will have only single set bit of xor */
	int i;
	*x = 0;
	*y = 0;

	/* Get the xor of all elements */
	for (i = 1; i < n; i++)
		xor ^= arr[i];

	/* Get the rightmost set bit in set_bit_no */
	set_bit_no = xor & ~(xor - 1);

	/* Now divide elements in two sets by comparing rightmost set
	 bit of xor with bit at same position in each element. */
	for (i = 0; i < n; i++) {
		if (arr[i] & set_bit_no)
			*x = *x ^ arr[i]; /*XOR of first set */
		else
			*y = *y ^ arr[i]; /*XOR of second set*/
	}
}




	int singleNumber(int A[], int n) {
        int bitnum[32]={0};
        int res=0;
        int i;
        int j;
        for(i=0; i<32; i++){

            for(j=0; j<n; j++){
                bitnum[i]+=(A[j]>>i)&1;
            }


            res|=(bitnum[i]%3)<<i;
        }
        return res;
    }




/* Driver program to test above function */
int main1() {
	int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11 };
	int *x = (int *) malloc(sizeof(int));
	int *y = (int *) malloc(sizeof(int));
	get2NonRepeatingNos(arr, 8, x, y);

	int arr2[] = { 2, 2, 2, 3, 4, 4, 4};
	singleNumber(arr2,7);
	printf("The non-repeating elements are %d and %d", *x, *y);




}
