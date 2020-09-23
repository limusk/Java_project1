package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

import javax.management.StandardEmitterMBean;
import javax.swing.*;

/**
 * @auther limusk
 * @create 2020-09-23-16:38
 * @project project3
 */

public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];

    private int total = 0;

    public TeamService() {
    }

    /**
     * 获取开发团队中的所有成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++){
//            team[i] = new Programmer();
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将制定的员工添加进开发团队中
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total > MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        //该员工已在开发团队中
        if( isExists(e)){
            throw new TeamException("该员工已在开发团队中");

        }
        //该员工已是某团队成员
        //该员工正在休假，无法添加
        //使用status判断
        Programmer p = (Programmer)e; //一定不会出现ClassCastException
        //if (p.getStatus().getNAME().equals("BUSY"))
        if ("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("正在休假，无法添加");
        }


        //团队中至多有一名架构师
        //团队中至多有两名架构师
        //团队中至多只能有三名程序员
        //获取team已有成员中的架构师、设计师、程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                numOfPro++;
            }
        }

        if (p instanceof Architect){
            if (numOfArch >= 1){
                throw new TeamException("团队中至多有一名架构师");
            }else if(p instanceof Designer){
                if (numOfDes >= 2) {
                    throw new TeamException("团队中至多有两名设计师");
                }
            }else if(p instanceof Programmer){
                if (numOfPro >= 3) {
                    throw new TeamException("团队中至多只能有三名程序员");
                }
            }
        }

        team[total++] = p;
        //上下两步操作调换顺序没有影响
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    private boolean isExists(Employee e){
        for ( int i=0; i < total; i++){
            if (team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }
    public void removeMember(int memberId) throws TeamException {
        int i;
        memberId = memberId-1;
        if (memberId >= total) {
            throw new TeamException("找不到指定memberID的员工，删除失败");
        }
        for(i = 0; i < total; i++){
            if (team[i].getMemberId() == team[memberId].getMemberId()){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total){
            throw new TeamException("找不到指定memberID的员工，删除失败");
        }

        //后一个元素覆盖前一个元素，实现删除操作
        for (int j = i + 1; j < total; j++){
            team[j-1] = team[j];
        }
        team[--total] = null;


    }


}
