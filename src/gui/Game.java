package gui;

public class Game {
    private String name;
    private int daysSinceLastPlay;
    private int size;

    public Game(String name, int daysSinceLastPlay, int size) {
        this.name = name;
        this.daysSinceLastPlay = daysSinceLastPlay;
        this.size = size;
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
