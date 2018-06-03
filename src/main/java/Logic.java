import com.sun.glass.ui.Size;

import java.util.Scanner;

public class Logic {
    public  static int  SIZE=10;
    public static Scanner in=new Scanner(System.in);
    public  static char[][] map=new char[SIZE][SIZE];
    public static void  initMap(){
        for(int i=0; i<SIZE; i++){
            for(int j=0;j<SIZE;j++){
                map[i][j]='.';
            }
        }
        return ;

    }
    public static void printMap(){

        for(int k=0;k<11; k++){
            System.out.print(k+"\t");
        }
        System.out.println("");
        for(int i=0; i<SIZE; i++){
            System.out.print((i+1)+"\t");
            for(int j=0; j<SIZE;j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println("\t");
        }
        System.out.println("");
    }
    public static void humanTurn(){
        int x,y;
        do{
            System.out.println("Введите координаты в формате X  и Y, Alisa");
            x=in.nextInt()-1;
            y=in.nextInt()-1;
        }while(!isCellEmty(x,y));//
        map[y][x]='X';

    }

    public static void aiTurn(){
        int x,y;
        do{
            System.out.println("Введите координаты в формате X  и Y, Bob");
            x=in.nextInt()-1;
            y=in.nextInt()-1;
        }while(!isCellEmty(x,y));//
        map[y][x]='O';
    }

    public static boolean isCellEmty(int x, int y){
        if( x < 0 || x > SIZE-1 || y < 0 || y > SIZE-1)return false;
        if(map[y][x]!='.') return false;
        return true;
    }

    public static boolean isMapFull(){
        for(int i=0;i<SIZE; i++){
            for(int j=0;j<3;j++){
                if(map[i][j]=='.')
                    return false;
            }
        }
        return true;
    }
   /* public static boolean checkWin(char ox){
        //Ищем заполненные горизонтальные линии
        if(map[0][0]==ox && map[0][1]==ox && map[0][2]==ox)return true;
        if(map[1][0]==ox && map[1][1]==ox && map[1][2]==ox)return true;
        if(map[2][0]==ox && map[2][1]==ox && map[2][2]==ox)return true;
        // Ищем заполненные вертикальные линии
        if(map[0][0]==ox && map[1][0]==ox && map[2][0]==ox) return true;
        if(map[0][1]==ox && map[1][1]==ox && map[2][1]==ox)return true;
        //Ищем заполненные диагональные линии
        if(map[0][0]==ox && map[1][1]==ox && map[2][2]==ox)return true;
        if(map[2][0]==ox && map[1][1]==ox && map[0][2]==ox) return true;
        return false;
    }*/

    public static boolean checkWin(char ox) {

        for (int i = 0; i < SIZE; i++) {
            int countRow = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == ox) countRow++;
                else {
                    if (j + 1 < SIZE && map[i][j + 1] != ox && countRow != 5)
                    {  countRow = 0;}
                }
            }
            if (countRow >= 5) return true;
        }

        for(int i=0;  i<SIZE; i++){
            int countColumn=0;
            for(int j=0; j<SIZE; j++){
                if(map[j][i]==ox) countColumn++;
                if(j+1<SIZE &&  map[j+1][i]!=ox && countColumn!=5){
                    countColumn=0;
                }
            }
            if(countColumn>=5) return true;
        }

        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                int countDown=0, countUp=0;
                for(int k=i,  l=j; k<SIZE && l<SIZE; k++, l++){
                  if(map[k][l]==ox){
                      countDown++;
                  }
                  if(k+1<SIZE && l+1<SIZE &&  map[k+1][l+1]!=ox && countDown!=5){
                      countDown=0;
                  }

                }
                for(int k=i, l=j; l<SIZE && k>=0; k--,l++){
                    if(map[k][l]==ox){
                        countUp++;
                    }
                    if(k-1>=0 && l+1<SIZE && map[k-1][l+1]!=ox && countUp!=5){
                        countUp=0;
                    }
                }
                if(countDown>=5||countUp>=5){
                    return true;
                }
            }
        }

               return false;
    }
}
