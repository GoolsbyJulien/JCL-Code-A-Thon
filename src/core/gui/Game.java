package core.gui;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    private int daysSinceLastPlay;
    private int size;


    public Game(String name, int daysSinceLastPlay, int size) {
        this.name = name;
        this.daysSinceLastPlay = daysSinceLastPlay;
        this.size = size;
    }

    public static List<Game> getDummyList() {
        List<Game> list = new ArrayList<>();
        list.add((new Game("GTA", 234, 124)));
        list.add((new Game("Minecraft", 0, 10)));
        list.add((new Game("CK2", 442, 4)));
        list.add((new Game("Red Dead Redemption 2", 4, 3)));
        list.add((new Game(" Tales of Monkey Island Complete Pack: Chapter 4 – The Trial and Execution of Guybrush Threepwood", 4, 3)));
        return list;
    }

    public String getName() {
        return name;
    }

    public String getNameAbbreviated() {

        return getNameAbbreviated(30);
    }

    public String getNameAbbreviated(int max) {
        if(name.length() > max) {
            return name.substring(0,max) + "...";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysSinceLastPlay() {
        return daysSinceLastPlay;
    }

    public void setDaysSinceLastPlay(int daysSinceLastPlay) {
        this.daysSinceLastPlay = daysSinceLastPlay;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
