package com.result.Student.Result.Management.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultRepository {

    @Autowired
    private DataSource dataSource;

    public List<Result> findAll() {
        List<Result> results = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM results");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Result r = new Result();
                r.setId(rs.getInt("id"));
                r.setStudentName(rs.getString("student_name"));
                r.setCourse(rs.getString("course"));
                r.setMarks(rs.getInt("marks"));
                results.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void save(Result result) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO results(student_name, course, marks) VALUES (?, ?, ?)")) {
            stmt.setString(1, result.getStudentName());
            stmt.setString(2, result.getCourse());
            stmt.setInt(3, result.getMarks());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
