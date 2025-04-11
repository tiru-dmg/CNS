/*Write a C program that contains a string (char pointer) with a value \Hello
World’. The program should AND or and XOR each character in this string with
127 and display the result.*/

#include <stdio.h>
int main() {
    char str[] = "Hello World";
    int i;
    printf("AND: ");
    for (i = 0; str[i]; i++) printf("%c", (str[i] & 127) >= 32 && (str[i] & 127) <= 126 ? str[i] & 127 : '?');
    printf("\nOR: ");
    for (i = 0; str[i]; i++) printf("%c", (str[i] | 127) >= 32 && (str[i] | 127) <= 126 ? str[i] | 127 : '^');
    printf("\nXOR: ");
    for (i = 0; str[i]; i++) printf("%c", (str[i] ^ 127) >= 32 && (str[i] ^ 127) <= 126 ? str[i] ^ 127 : '&');
    printf("\n");
    return 0;
}
