#include <stdio.h>

#define MIN_IRR -1
#define MAX_IRR 10000

int T;
double cf[11];

double npv(double irr) {
  double sum = cf[0];
  double den = 1+irr;
  double f = den;

  for (size_t i = 0; i < T; i++) {
    sum += cf[i+1]/den;
    den = den*f;
  }

  return sum;
}

int main(int argc, char const *argv[]) {
  double max, min, med;
  scanf("%d\n", &T);
  while(T != 0) {
    scanf("%lf", &cf[0]);
    for (size_t i = 0; i < T; i++) {
      scanf(" %lf", &cf[i+1]);
    }
    max = MAX_IRR;
    min = MIN_IRR;
    while (max-min>0.0001) {
      med = (max+min)/2;
      if (npv(med) > 0) {
        min = med;
      }
      else {
        max = med;
      }
    }
    max -= 0.000099;
    printf("%1.2lf\n", max);
    scanf("%d\n", &T);
  }
  return 0;
}
