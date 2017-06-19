#include <stdio.h>
#include <math.h>
#include <iostream>

int main(int argc, char const *argv[]) {
  unsigned long long int M;
  double p, j;
  int c;

  scanf("%llu %lf %lf %d", &M, &p, &j, &c);

  double Mmin = (double)c*100.0/j;
  std::cout << Mmin << '\n';
  double k = Mmin/M;
  std::cout << k << '\n';
  double base = (100.0-p)/100.0;
  std::cout << base << '\n';

  double result = log(k)/log(base);

  printf("%lf\n", result);

  return 0;
}
