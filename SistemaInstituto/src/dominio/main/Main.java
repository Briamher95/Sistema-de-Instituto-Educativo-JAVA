package dominio.main;

import dominio.Menu;


public class Main {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        System.out.println("Programa hecho por: Bryan Hernandez, Fausto Pino, Santino Resch");
        System.out.println("Bienvenido al programa");

        menu.Iniciar();
    }
}