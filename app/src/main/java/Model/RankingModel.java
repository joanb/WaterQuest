package Model;

public class RankingModel {

    private String name;
    private int drops;

    public RankingModel(String name, int drops) {
        this.name = name;
        this.drops = drops;
    }

    public String getName() {
        return name;
    }

    public int getDrops() {
        return drops;
    }
}