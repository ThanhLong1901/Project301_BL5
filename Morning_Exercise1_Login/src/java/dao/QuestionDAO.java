/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;

/**
 *
 * @author Long
 */
public class QuestionDAO extends DBContext {

    PreparedStatement st;
    ResultSet rs;

    public List<Question> getListQuestion() {
        List<Question> list = new ArrayList<>();
        String sql = "select * from Question";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("qid"));
                q.setContent(rs.getString("content"));
                list.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    public ArrayList<Question> getQuestions() {
//        ArrayList<Question> questions = new ArrayList<>();
//
//        try {
//            String sql = "SELECT qid, content FROM Question";
//            st = connection.prepareStatement(sql);
//            rs = st.executeQuery();
//            while (rs.next()) {
//                Question q = new Question();
//                q.setId(rs.getInt("qid"));
//                q.setContent(rs.getString("content"));
//                questions.add(q);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return questions;
//    }

    public static void main(String[] args) {
        QuestionDAO pd = new QuestionDAO();
//        ArrayList<Question> list = pd.getQuestions();
        List<Question> list1 = pd.getListQuestion();
//        System.out.print("getQuestions: ");
//        System.out.println(list.size());
        System.out.print("getListQuestion: ");
        System.out.println(list1.size());
        System.out.println(list1.get(1).getContent());
    }
}
