package DAO;

import database.JDBCUntil;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements DAOInterface<Student> {

    @Override
    public void insert(Student student) {
        try {
            //B1: Tạo connection
            Connection c = JDBCUntil.getConnection();

            //B2: tạo câu Query
            String sql = "Insert into student(id, name, email, phone, gender, address) values(?, ? , ?, ? , ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getPhone());
            pst.setInt(5, student.getGender());
            pst.setString(6, student.getAddress());

            //B3: Thực hiện query
            int result = pst.executeUpdate();

            //B4: Xử lý kết quả
            if (result != 0) {
                System.out.println(result + " record have been inserted");
            } else {
                System.out.println("Insert failed");
            }

            //B5: Close
            pst.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(String id) {
        try {
            //B1: Tạo connection
            Connection c = JDBCUntil.getConnection();

            //B2: tạo câu Query
            String sql = "Delete from student" +
                    " where id = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, id);
            //B3: Thực hiện query
            int result = pst.executeUpdate();

            //B4: Xử lý kết quả
            if (result != 0) {
                System.out.println(result + " record have been delete");
            } else {
                System.out.println("Delete failed");
            }

            //B5: Close
            pst.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        try {
            //B1: Tạo connection
            Connection c = JDBCUntil.getConnection();

            //B2: tạo câu Query
            String sql = "Update student" +
                    " set name = ?, email = ?, phone = ?, gender = ?, address = ?" +
                    " where id = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getPhone());
            pst.setInt(4, student.getGender());
            pst.setString(5, student.getAddress());
            pst.setString(6, student.getId());
            //B3: Thực hiện query
            int result = pst.executeUpdate();

            //b4
            if (result > 0) {
                System.out.println(result + " record has been inserted");
            } else {
                System.out.println("failed");
            }
            //b5
            c.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            //B1: Tạo connection
            Connection c = JDBCUntil.getConnection();

            //B2: tạo câu Query
            String sql = "Select * from student";
            PreparedStatement pst = c.prepareStatement(sql);

            //B3: Thực hiện query
            ResultSet rs = pst.executeQuery();

            //B4: Xử lý kết quả
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int gender = rs.getInt("gender");
                String address = rs.getString("address");

                list.add(new Student(id, name, email, phone, address, gender));
            }

            //B5: Close
            pst.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Student selectByID(String selectedID) {
        Student st = null;
        try {
            //B1: Tạo connection
            Connection c = JDBCUntil.getConnection();

            //B2: tạo câu Query
            String sql = "Select * from student"+
                    " where id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, selectedID);

            //B3: Thực hiện query
            ResultSet rs = pst.executeQuery();

            //B4: Xử lý kết quả
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int gender = rs.getInt("gender");
                String address = rs.getString("address");

                st = new Student(id, name, email, phone, address, gender);
            }

            //B5: Close
            pst.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return st;

    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        System.out.println(dao.selectByID("1").toString());
    }
}
