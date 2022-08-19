package DB;
import java.sql.*;
import java.util.Scanner;



public class MemberService {
    public void DBSelect() {
        String url = "jdbc:mariadb://127.0.0.1:3306/testdb1";
        String dbuserId = "testuser1";
        String dbPassword = "zerobase";
        // 1. 드라이버로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparestatement = null;
        ResultSet rs = null;
        String memberTypeValue = "email";
        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbuserId, dbPassword);

            String sql = " select member_type, user_id, password, name "
                    + " from member "
                    + " where member_type = ? ";
            preparestatement = connection.prepareStatement(sql);
            preparestatement.setString(1,memberTypeValue);
            // 3. 쿼리 실행
            rs = preparestatement.executeQuery();
            while(rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                System.out.println(memberType+", "+ userId+", "+ password+ ", " + name);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(preparestatement != null &&!preparestatement.isClosed()) {
                    preparestatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    // 회원가입
    public void register() {
        String url = "jdbc:mariadb://127.0.0.1:3306/testdb1";
        String dbuserId = "testuser1";
        String dbPassword = "zerobase";
        // 1. 드라이버로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparestatement = null;
        ResultSet rs = null;
        Scanner scanner = new Scanner(System.in);
        String memberType = "email";
        System.out.println("아이디 입력:>>>");
        String userId = scanner.next();
        System.out.println("비밀번 입력:>>>");
        String password = scanner.next();
        System.out.println("이름 입력:>>>");
        String name = scanner.next();
        Member member = new Member();
        member.setMemberType(memberType);
        member.setName(name);
        member.setUserId(userId);
        member.setPassword(password);
        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbuserId, dbPassword);

            String sql = " insert into member(member_type, user_id, password, name) "
                    + " values(?, ?, ?, ?) ";
            preparestatement = connection.prepareStatement(sql);
            preparestatement.setString(1,member.getMemberType());
            preparestatement.setString(2,member.getUserId());
            preparestatement.setString(3,member.getPassword());
            preparestatement.setString(4,member.getName());
            // 3. 쿼리 실행
            int affected_row = preparestatement.executeUpdate();
            if( affected_row >0) {
                System.out.println("저장 성공");
            }else {
                System.out.println("저장 실패 ");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(preparestatement != null &&!preparestatement.isClosed()) {
                    preparestatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    public void DBUpdate() {
        String url = "jdbc:mariadb://127.0.0.1:3306/testdb1";
        String dbuserId = "testuser1";
        String dbPassword = "zerobase";
        // 1. 드라이버로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparestatement = null;
        ResultSet rs = null;
        //추가 객체 정보
        Member member = new Member();
        Scanner scanner = new Scanner(System.in);
        member.setMemberType("email");
        System.out.println("아이디 입력:>>>");
        member.setUserId(scanner.next());
        System.out.println("비밀번 입력:>>>");
        member.setPassword(scanner.next());
        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbuserId, dbPassword);

            String sql = " update member "
                    + "set "
                    + "    password  =? "
                    + "where member_type = ? "
                    + "    and user_id = ? ";
            preparestatement = connection.prepareStatement(sql);
            preparestatement.setString(1,member.getPassword());
            preparestatement.setString(2,member.getMemberType());
            preparestatement.setString(3,member.getUserId());

            // 3. 쿼리 실행
            int affected_row = preparestatement.executeUpdate();
            if( affected_row >0) {
                System.out.println("업데이트 성공");
            }else {
                System.out.println("업데이트 실패 ");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(preparestatement != null &&!preparestatement.isClosed()) {
                    preparestatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //회원탈퇴
    public void withdraw() {
        String url = "jdbc:mariadb://127.0.0.1:3306/testdb1";
        String dbuserId = "testuser1";
        String dbPassword = "zerobase";
        // 1. 드라이버로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparestatement = null;
        ResultSet rs = null;
        //추가 객체 정보
        Member member = new Member();
        Scanner scanner = new Scanner(System.in);
        member.setMemberType("email");
        System.out.println("아이디 입력:>>>");
        member.setUserId(scanner.next());
        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbuserId, dbPassword);

            String sql = " delete from member "
                    + " where member_type = ? and user_id = ? ";
            preparestatement = connection.prepareStatement(sql);
            preparestatement.setString(1,member.getMemberType());
            preparestatement.setString(2,member.getUserId());

            // 3. 쿼리 실행
            int affected_row = preparestatement.executeUpdate();
            if( affected_row >0) {
                System.out.println("탈퇴 성공");
            }else {
                System.out.println("탈퇴 실패 ");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(preparestatement != null &&!preparestatement.isClosed()) {
                    preparestatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
