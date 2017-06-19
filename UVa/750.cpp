#include <stdio.h>

void copia(bool* src, bool* dest, int size) {
  for (size_t i = 0; i < size; i++) {
    dest[i] = src[i];
  }
}

class Point {
public:
  int x, y;
};

class Tabuleiro {
public:
  bool* col;
  bool* lin;
  bool* dP;
  bool* dS;
  Tabuleiro() {
    col = new bool[8];
    lin = new bool[8];
    dP = new bool[15];
    dS = new bool[15];
  }
  Tabuleiro(Tabuleiro *t) {
    col = new bool[8];
    lin = new bool[8];
    dP = new bool[15];
    dS = new bool[15];
    copia(t->col, col, 8);
    copia(t->lin, lin, 8);
    copia(t->dP, dP, 15);
    copia(t->dS, dS, 15);
  }
  void clear() {
    for (size_t i = 0; i < 8; i++) {
      col[i] = false;
      lin[i] = false;
    }
    for (size_t i = 0; i < 15; i++) {
      dP[i] = false;
      dS[i] = false;
    }
  }
};

Tabuleiro* tabuleiro;
int queens = 0, cont=0, c = 0;
Point qpoints[8];

void printSolution() {
  printf("%2d      ", ++cont);
  for (size_t i = 0; i < c; i++) {
    if (i!=0)
      printf(" ");
    printf("%d", qpoints[i+1].x);
  }
  if (c !=0)
    printf(" ");
  printf("%d", qpoints[0].x);
  for (size_t i = c+1; i < 8; i++) {
    printf(" %d", qpoints[i].x);
  }
  printf("\n");
}

void setQueen(int x, int y, Tabuleiro* tab) {
  tab->lin[x] = true;
  tab->col[y] = true;
  tab->dP[y-x+7] = true;
  tab->dS[x+y] = true;
}

void putQueen(int x, int y, Tabuleiro* tab) {
  queens++;
  Tabuleiro* newTab = new Tabuleiro(tab);
  setQueen(x,y,newTab);
  qpoints[queens-1].x = x+1;
  qpoints[queens-1].y = y+1;
  if (queens<8) {
    int col = -1;
    for (size_t i = 0; i < 8; i++) {
      if (!(newTab->col[i])) {
        col = i;
        i = 999;
      }
    }
    for (size_t i = 0; i < 8; i++) {
      if (!newTab->lin[i] && !newTab->dP[col-i+7] && !newTab->dS[col+i]) {
        putQueen(i, col, newTab);
      }
    }
  }
  else {
    printSolution();
  }
  queens--;
}

int main(int argc, char const *argv[]) {
  int x, y, tc;

  scanf("%d", &tc);
  for (size_t i = 0; i < tc; i++) {
    scanf("%d %d", &x, &y);

    tabuleiro = new Tabuleiro();
    queens = 0;
    cont = 0;
    tabuleiro->clear();

    x--;
    y--;

    if (i!=0)
      printf("\n");
    printf("SOLN       COLUMN\n");
    printf(" #      1 2 3 4 5 6 7 8\n\n");
    c = y;
    putQueen(x, y, tabuleiro);
  }

  return 0;
}
