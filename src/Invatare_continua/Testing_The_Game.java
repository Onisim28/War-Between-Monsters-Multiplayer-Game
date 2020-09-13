package Invatare_continua;


import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Testing_The_Game {
    public static void main(String[] args) {
        Uptaded_Monsters_Game.fill_the_map();

        Uptaded_Monsters_Game[] monsters = new Uptaded_Monsters_Game[4];

        monsters[0] = new Uptaded_Monsters_Game("A");
        monsters[1] = new Uptaded_Monsters_Game("B");
        monsters[2] = new Uptaded_Monsters_Game("C");
        monsters[3] = new Uptaded_Monsters_Game("D");
        Uptaded_Monsters_Game.display_Map();


        while (true) {
            for (int i = 0; i < monsters.length; i++) {
                monsters[0].print_monsters_points(monsters);//afiseaza viata fiecarui monstru
                int arrayIndex = i;

                monsters[i].move_monsters(monsters, arrayIndex);
                if (monsters[i].isTeamMate) {
                    i--;
                    Uptaded_Monsters_Game.display_Map();
                    continue;
                }
                Uptaded_Monsters_Game.display_Map();
            }
        }
    }

}
