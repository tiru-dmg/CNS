/*Write a C program that contains a string (char pointer) with a value \Hello
World’. The program should XOR each character in this string with 0 and
display the result.*/

#include <stdio.h>

int main() {
    char *str = "Hello\nWorld";
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] != '\n')
            putchar(str[i] ^ 0);
    }
    return 0;
}
