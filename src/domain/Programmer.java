package domain;

import service.Status;

/**
 * @auther limusk
 * @create 2020-09-23-14:28
 * @project project3
 */

public class Programmer extends Employee {

    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t\t" +equipment.getDescription();
    }

    public String getTeamBaseDatails(){
        return memberId + "/" + getId() + "\t" + getName() + "\t" +getAge() + "\t" + getSalary() + "\t" + "程序员";
    }

    public String getDetailsForTeam() {
        return getTeamBaseDatails();
    }
}
