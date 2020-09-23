package domain;

/**
 * @auther limusk
 * @create 2020-09-23-14:14
 * @project project3
 */

public class PC implements Equipment {
    private String model; //设备名称
    private String display; //显示器名称

    //没有构造器?


    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
