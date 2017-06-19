#include <stdio.h>

unsigned long getReverse(unsigned long n) {
  unsigned long p = 0;
  do {
    p *= 10;
    p += n%10;
    n /= 10;
  } while (n!=0);
  return p;
}

int main(int argc, char const *argv[]) {
  int tc, k;
  unsigned long num, rev;
  scanf("%d", &tc);
  for (size_t i = 0; i < tc; i++) {
    scanf("%d", &num);
    rev = getReverse(num);
    num += rev;
    rev = getReverse(num);
    k=1;
    while (num != rev) {
      num += rev;
      rev = getReverse(num);
      k++;
    }
    printf("%d %lu\n", k, num);
  }
  return 0;
}
