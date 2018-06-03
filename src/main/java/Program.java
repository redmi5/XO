public class Program {
    public static void main(String[] args) {
        Logic.initMap();
        Logic.printMap();

        while(true) {
            Logic.humanTurn();//ход первого игрока
            Logic.printMap();//печать поля
            if (Logic.checkWin('X')) {//проверка победы человека
                System.out.println("Победил игрок  Алиса");
                break;
            }
            if (Logic.isMapFull()) break;// если поле заполнилось,завершаем игру
            Logic.aiTurn();  // ход второго игрока
            Logic.printMap();//печать поля
            if (Logic.checkWin('O')) {
                System.out.println("Победил  игрок Боб");
                break;

            }
            if (Logic.isMapFull()) break;
        }
        System.out.println("Game over");


        }

    }

