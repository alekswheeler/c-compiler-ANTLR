#include <stdio.h>

void soma(int* n1, int* n2){
    *n1 += *n2;
}

int main(){
    int a, b;
    int *x = &a;
    int y* = &b;//ERROR
    *x = 10;
    *y = 1;
}
