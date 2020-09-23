package domain;

/**
 * @auther limusk
 * @create 2020-09-23-14:36
 * @project project3
 */

public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + " \t\t\t\t" + getEquipment().getDescription();
    }

    public String getTeamBaseDatails() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" +
                getSalary() + "\t" + "设计师\t" + bonus;
    }


}
