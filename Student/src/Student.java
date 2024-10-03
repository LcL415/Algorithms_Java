public class Student {
    private String sid;
    private String age;

    private String name;
    private String address;

    public Student() {
    }

    public Student(String sid, String age, String name, String address) {
        this.sid = sid;
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    /* public void learn() {
        System.out.println("good good study, day day up");
    }*/

    /*public String reverse(String s) {
        String ss="[ ";

        for (int i=s.length()-1;i>=0;i--){
            ss+=s.charAt(i);
        }
        ss=ss+" ]";
        return ss;*/
}


