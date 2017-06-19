#include <stdio.h>

int table[15];

int main(int argc, char const *argv[]) {
  int n = 0;
  int power = 1;
  int c = 0;
  int k;
  for (size_t i = 0; i < 15; i++) {
    table[i] = power;
    power *= 2;
  }
  scanf("%d", &n);
  while (n > 0) {
    c++;
    k = 0;
    while (n>table[k]) {
      k++;
    }
    printf("Case %d: %d\n", c, k);
    scanf("%d", &n);
  }

  return 0;
}
