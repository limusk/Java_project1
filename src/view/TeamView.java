package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

/**
 * @auther limusk
 * @create 2020-09-23-18:27
 * @project project3
 */

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();
    char menu = 0;

    public void enterMainMenu(){
        boolean loopFlag = true;
        do {
            if (menu != '1') { //注意这里为字符串‘1’，不是数字1
                listAllEmployees();
            }


            System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否确认退出(Y/N)");
                    char isExist = TSUtility.readConfirmSelection();
                    if (isExist == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while(loopFlag);
    }

    /**
     * 显示所有的员工信息
     */
    public void listAllEmployees(){
        System.out.println("显示所有的员工信息");
        System.out.println("-------------------------------开发团队调度软件-------------------------------\n");

        Employee[] employees = listSvc.getAllEmployees();
        if(employees == null || employees.length == 0){
            System.out.println("公司中没有任何员工信息");
        }else{
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");

            for (int i = 0; i < employees.length; i++){
                System.out.println(employees[i]);

            }
        }


    }

    public void getTeam(){
        System.out.println("-------------------------------团队成员列表------------------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0){
            System.out.println("没有团队成员");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < team.length; i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public void addMember(){
//        System.out.println("添加团队成员");
        System.out.println("-------------------------------添加团队成员-------------------------------");
        System.out.println("请输入要添加的成员ID：");
        int id = TSUtility.readInt();

        try {
            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        }catch (TeamException e) {
            System.out.println("添加失败，原因： " + e.getMessage());
        }

        //按回车键继续
        TSUtility.readReturn();
    }

    public void deleteMember(){
        System.out.println("------------------------------删除团队成员----------------------------------");
        System.out.println("请输入要删除员工的TID： ");
        int memberId = TSUtility.readInt();

        System.out.println("是否确认删除(Y/N): ");
        char isDel = TSUtility.readConfirmSelection();
        if (isDel == 'Y'){
            try {
                teamSvc.removeMember(memberId);
                System.out.println("删除成功");
            }catch(TeamException e) {
                System.out.println("删除失败，原因： " + e.getMessage());

            }
        }else{
            return;
        }

        //按回车键继续
        TSUtility.readReturn();

    }

    public static void main(String [] args){
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
