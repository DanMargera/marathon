#include <stdio.h>
#include <math.h>

int vec[524288];
int casos, d, bola, elementos;
int resp;

int main(int argc, char const *argv[]) {
  scanf("%d", &casos);

  for (int k=0;k<casos;k++) {
    scanf("%d %d", &d, &bola);
    elementos = 1;

    vec[0] = 0;
    for (int i=pow(2,d-2);i>=1;i/=2) {
      for (int j=0;j<elementos;j++) {
        vec[j+elementos] = vec[j] + i;
      }
      elementos *= 2;
    }

    resp = (vec[bola-1]+pow(2,d-1));

    printf("%d\n", resp);
  }
  scanf("%d", &casos);
  return 0;
}
