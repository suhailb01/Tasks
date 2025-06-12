import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Task {
    public static void main(String[] args) throws Exception{
        Connection con=null;
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","#codeP01");
            PreparedStatement st1=con.prepareStatement("create table emp(empcode INT,empname VARCHAR(10),empage INT,esalary INT)");
            st1.executeUpdate();
            PreparedStatement st2=con.prepareStatement("insert into emp values(?,?,?,?)");
            Object[][] arr={{101,"Jenny",25,10000},{102,"Jacky",30,20000},{103,"Joe",20,40000},{104,"John",40,80000},{105,"Shameer",25,90000}};
            for (Object[] i:arr){
                st2.setInt(1,(Integer)i[0]);
                st2.setString(2,(String)i[1]);
                st2.setInt(3,(Integer)i[2]);
                st2.setInt(4,(Integer)i[3]);
                int status=st2.executeUpdate();
                System.out.println(status);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }
    }
}
