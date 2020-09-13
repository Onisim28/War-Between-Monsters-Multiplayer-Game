package Invatare_continua;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//ArrayUtils.indexOf(v,77);

public class Uptaded_Monsters_Game {

    public String monsterName;
    private int health = 0;
    private int attack;
    private int movement;
    private int monsterX;
    private int monsterY;
    final char asterix = '*';
    public static char[][] Map = new char[10][10];   //10 linii si 30 de coloane sa aiba
    public boolean isTeamMate = false;
    public boolean game_over = false;

    public Uptaded_Monsters_Game() {
        health = 300;
        attack = 50;
        movement = 2;
        char first_letter;

        do {
            monsterX = (int) (Math.random() * 10);
            monsterY = (int) (Math.random() * 10);
            first_letter = monsterName.charAt(0);
        }
        while (Map[monsterX][monsterY] != '*');
        Map[monsterX][monsterY] = first_letter;

    }

    public Uptaded_Monsters_Game(int health, int attack, int movement) {
        this.health = health;
        this.attack = attack;
        this.movement = movement;

        char first_letter;

        do {
            monsterX = (int) (Math.random() * 5);
            monsterY = (int) (Math.random() * 5);
            first_letter = monsterName.charAt(0);
        }
        while (Map[monsterX][monsterY] != '*');
        Map[monsterX][monsterY] = first_letter;
    }

    public Uptaded_Monsters_Game(String monsterName) {
        this.monsterName = monsterName;
        health = 0;
        attack = 50;
        movement = 2;

        char first_letter;

        do {
            monsterX = (int) (Math.random() * 5);
            monsterY = (int) (Math.random() * 5);
            first_letter = monsterName.charAt(0);
        }
        while (Map[monsterX][monsterY] != '*');
        Map[monsterX][monsterY] = first_letter;
    }

    public int getAttack() {
        return attack;
    }

    public int getLife() {
        return health;
    }

    public int getMovement() {
        return movement;
    }

    public int getMonsterX() {
        return monsterX;
    }

    public int getMonsterY() {
        return monsterY;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setLife(int health) {
        this.health = health;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public void setMonsterX(int monsterX) {
        this.monsterX = monsterX;
    }

    public void setMonsterY(int monsterY) {
        this.monsterY = monsterY;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public static void fill_the_map() {
        for (char[] fill : Map)
            Arrays.fill(fill, '*');
        //initializaeaza toate valoriile initiale ale matricei cu '*'
    }

    public static void display_Map() {

        for (int i = 0; i < Map.length; i++) {
            System.out.println();
            for (int j = 0; j < Map[i].length; j++) {
                System.out.print("|" + Map[i][j] + "|");
            }//second for end
        }//first for end

    }

    public void move_monsters(Uptaded_Monsters_Game[] move, int index) {
        String direction;
        Scanner citire = new Scanner(System.in);
        System.out.println("\n" + move[index].monsterName.charAt(0) + " Alege directia:");
        direction = citire.nextLine();
        switch (direction) {
            case "w":
                Map[monsterX][monsterY] = asterix; //Inlocuim cu * in locul unde a fost ocupat de monstru
                move[index].monsterX--;

                if (hit_teamMate(move)) {
                    move[index].monsterX++;
                } else
                    hit_Enemy(move, index);

                Map[monsterX][monsterY] = asterix;
                move[index].monsterX--;
                if (hit_teamMate(move)) {
                    move[index].monsterX++;
                } else
                    hit_Enemy(move, index);

                Map[move[index].monsterX][move[index].monsterY] = move[index].monsterName.charAt(0);

                break;

            case "a":
                Map[monsterX][monsterY] = asterix;
                move[index].monsterY--;

                if (hit_teamMate(move))
                    move[index].monsterY++;
                else
                    hit_Enemy(move, index);

                Map[monsterX][monsterY] = asterix;
                move[index].monsterY--;

                if (hit_teamMate(move))
                    move[index].monsterY++;
                else
                    hit_Enemy(move, index);

                Map[move[index].monsterX][move[index].monsterY] = move[index].monsterName.charAt(0);
                break;

            case "d":
                Map[monsterX][monsterY] = asterix;
                move[index].monsterY++;

                if (hit_teamMate(move))
                    move[index].monsterY--;
                else
                    hit_Enemy(move, index);

                Map[monsterX][monsterY] = asterix;
                move[index].monsterY++;

                if (hit_teamMate(move))
                    move[index].monsterY--;
                else
                    hit_Enemy(move, index);

                Map[move[index].monsterX][move[index].monsterY] = move[index].monsterName.charAt(0);
                break;

            case "s":
                Map[monsterX][monsterY] = asterix;
                move[index].monsterX++;

                if (hit_teamMate(move))
                    move[index].monsterX--;
                else
                    hit_Enemy(move, index);

                Map[monsterX][monsterY] = asterix;
                move[index].monsterX++;

                if (hit_teamMate(move))
                    move[index].monsterX--;
                else
                    hit_Enemy(move, index);

                Map[move[index].monsterX][move[index].monsterY] = move[index].monsterName.charAt(0);
                break;
        }
    }


    public void hit_Enemy(Uptaded_Monsters_Game[] monster, int index) {
        if (Map[monster[index].monsterX][monster[index].monsterY] != '*')
            for (int i = 0; i < monster.length; i++) {
                if (index == i)
                    continue;
                else {

                    if ((monster[i].monsterX == monster[index].monsterX) && (monster[i].monsterY == monster[index].monsterY)) {
                        monster[i].monsterX = 0;
                        monster[i].monsterY = 0;
                        monster[index].health++;
                        Map[monster[i].monsterX][monster[i].monsterY] = monster[i].monsterName.charAt(0);
                        break;
                    }
                }
            }
    }

    public boolean hit_teamMate(Uptaded_Monsters_Game[] monster) {
        if (((monster[0].monsterX == monster[1].monsterX) && (monster[0].monsterY == monster[1].monsterY)) ||
                ((monster[2].monsterX == monster[3].monsterX) && (monster[2].monsterY == monster[3].monsterY))) {
            isTeamMate = true;
            return true;
        } else {
            isTeamMate = false;
            return false;
        }
    }

    public void print_monsters_points(Uptaded_Monsters_Game[] monster) {
        char m0 = monster[0].monsterName.charAt(0), m1 = monster[1].monsterName.charAt(0), m2 = monster[2].monsterName.charAt(0),
                m3 = monster[3].monsterName.charAt(0);
        System.out.println("\t\t\t" + m0 + " Ponits=" + monster[0].getLife());
        System.out.println("\t\t\t\t\t\t\t\t\t\t" + m1 + " Ponits=" + monster[1].getLife());
        System.out.println("\t\t\t\t\t\t\t\t\t\t" + m2 + " Ponits=" + monster[2].getLife());
        System.out.println("\t\t\t\t\t\t\t\t\t\t" + m3 + " Ponits=" + monster[3].getLife());
    }

}
