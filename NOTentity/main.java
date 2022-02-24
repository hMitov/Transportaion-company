package NOTentity;

import NOTentity.Menu;

import java.util.Scanner;

public class main {
    public static void main(String[] argv) {

        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        menu.Menu(input);
        input.close();

    }
}
