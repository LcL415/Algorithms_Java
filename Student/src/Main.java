import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deletStudent(array);
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    findAllStudent(array);

                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //break;
                    System.exit(0);
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String sid = sc.nextLine();
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
        Student s = new Student();
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        s.setSid(sid);
        array.add(s);
        System.out.println("添加学生成功");

    }

    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加再查询");
            return;
        }

        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t\t" + s.getAddress());
            {


            }
        }

    }

    public static void deletStudent(ArrayList<Student> array){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号：");
        String sid = sc.nextLine();
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid))
            {
                array.remove(i);
                break;
            }


        }
        System.out.println("学生删除成功");

    }

    public static void updateStudent(ArrayList<Student> array){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要修改人的学号：");
        String sid = sc.nextLine();
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                Scanner id=new Scanner(System.in);
                System.out.println("请输入新的学号：");
                String newId = sc.nextLine();
                s.setSid(newId);
                System.out.println("请输入学生姓名：");
                String name = sc.nextLine();
                s.setName(name);
                System.out.println("请输入学生年龄：");
                String age = sc.nextLine();
                s.setAge(age);
                System.out.println("请输入学生居住地：");
                String address = sc.nextLine();
                s.setAddress(address);

                System.out.println("修改成功");
                break;
            }
            else{
                System.out.println("信息不存在请重新输入");
                return;
            }

        }
    }
}