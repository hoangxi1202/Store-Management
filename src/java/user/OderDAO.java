/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import shopping.Oder;
import shopping.OderDetail;
import shopping.Product;
import utils.DBUtils;

/**
 *
 * @author Minh Hoàng
 */
public class OderDAO {

    public boolean insertOder(Oder oder) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOder(oderID, userID, total,phone , address, status, fullName) "
                        + " VALUES(?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, oder.getOderID());
                stm.setString(2, oder.getUserID());
                stm.setLong(3, oder.getTotal());
                stm.setString(4, oder.getPhone());
                stm.setString(5, oder.getAddress());
                stm.setInt(6, oder.getStatus());
                stm.setString(7, oder.getFullName());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return check;
    }

    public boolean insertOderDetail(OderDetail oderDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblOderDetail "
                        + " values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, oderDetail.getDetailID());
                stm.setString(2, oderDetail.getProductID());
                stm.setLong(3, oderDetail.getPrice());
                stm.setInt(4, oderDetail.getQuantity());
                stm.setInt(5, oderDetail.getOderID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return check;
    }
    public List<OderDetail> getOderDetail(String txt) throws SQLException {
        List<OderDetail> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from tblOderDetail where oderID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        OderDAO dao = new OderDAO();
//        System.out.println("pid:");
//        String pid = sc.nextLine();
//        System.out.println("detailid:");
//        int did = sc.nextInt();
//        
//        System.out.println("price:");
//        long price = sc.nextLong();
//        System.out.println("quantity:");
//        int quantity = sc.nextInt();
//        System.out.println("oderid:");
//        int oid = sc.nextInt();
//        OderDetail o = new OderDetail(did, pid, price, quantity, oid);
//        dao.insertOderDetail(o);
                System.out.println("oderdetailid:");
        String id = "1906941805";
        List<OderDetail> newOderDetail =  dao.getOderDetail(id);
        for (OderDetail o : newOderDetail) {
            System.out.println(o.toString());
        }
        
    }
}
