package domain;

/**
 * @auther limusk
 * @create 2020-09-23-14:38
 * @project project3
 */

public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getstock() {
        return stock;
    }

    public void setstock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + " \t" + stock  + "\t" + getEquipment().getDescription();
    }

    public String getTeamBaseDatails(){
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" +getAge() + "\t" + getSalary() + "\t" +
                "架构师\t" + getBonus() + "\t" + getstock();
    }

    public String getDetailsForTeam(){
        return getTeamBaseDatails();
    }
}
