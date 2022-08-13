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
import shopping.Catagory;
import shopping.Item;
import shopping.Product;
import utils.DBUtils;

/**
 *
 * @author Minh Hoàng
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleID "
                        + " FROM tblUsers "
                        + " WHERE userID =? AND password=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, fullName, roleID "
                        + " FROM tblUsers "
                        + " WHERE fullName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    list.add(new UserDTO(userID, fullName, roleID, password));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean deleteUser(String userID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " DELETE tblUsers "
                        + " WHERE userId=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                int value = stm.executeUpdate();
                result = value > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean updateUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " UPDATE tblUsers "
                        + " SET fullName=?, roleID=? "
                        + " WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getRoleID());
                stm.setString(3, user.getUserID());
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

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID "
                        + " FROM tblUsers "
                        + " WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
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
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public boolean insertUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUsers(userID, fullName, roleID, password) "
                        + " VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRoleID());
                stm.setString(4, user.getPassword());
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

    public List<Product> getAllProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblProduct";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getDate(7),
                            rs.getDate(8),
                            rs.getString(9)));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public Product getProduct(String txt) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select productID, productName, image, price from tblProduct where productID=?";
        List<Product> list = new ArrayList<>();
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        1);
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
        return null;
    }

    public List<Catagory> getAllCatagory() throws SQLException {
        List<Catagory> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblCatagory";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Catagory(rs.getString(1),
                            rs.getString(2)));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Product> searchProduct(String catagoryID) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select * from tblProduct\n"
                        + "where catagoryID =?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, catagoryID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getDate(7),
                            rs.getDate(8),
                            rs.getString(9)));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public Product searchProductByID(String productID) throws SQLException {
        Product p = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select * from tblProduct\n"
                        + "where productID =?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    p = new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getDate(7),
                            rs.getDate(8),
                            rs.getString(9));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return p;
    }

    public List<Product> searchProductByName(String txtSearch) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblProduct"
                        + " WHERE [productName] like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getDate(7),
                            rs.getDate(8),
                            rs.getString(9)));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public void deleteProduct(String productID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " DELETE tblProduct "
                        + " WHERE productID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void addProduct(String id, String name, String img, double price, String cataID, String des) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblProduct "
                        + " (productID, productName, image, price, catagoryID, description)"
                        + " VALUES(?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                stm.setString(2, name);
                stm.setString(3, img);
                stm.setDouble(4, price);
                stm.setString(5, cataID);
                stm.setString(6, des);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void updateProduct(String id, String name, String img, double price, String cataID, String des) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " UPDATE tblProduct "
                        + " Set productName=?,"
                        + " image=?,"
                        + " price=?,"
                        + " catagoryID=?,"
                        + " description=? "
                        + " WHERE productID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, img);
                stm.setDouble(3, price);
                stm.setString(4, cataID);
                stm.setString(5, des);
                stm.setString(6, id);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void updateQuantityProduct(String proID, int newQuan) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProduct "
                        +   " SET quantity =?"
                        +   " WHERE productID =?";
                stm = conn.prepareStatement(sql);
                stm.setString(2, proID);
                stm.setInt(1, newQuan);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
//        public static void main(String[] args) throws SQLException {
//            Scanner sc = new Scanner(System.in);
//        UserDAO dao = new UserDAO();
//        System.out.println("id:");
//            String id = sc.nextLine();
//            System.out.println("newQUan:");
//            int newQ = sc.nextInt();
//            
//            dao.updateQuantityProduct(id, newQ);
////            System.out.println("ID:");
////            String id = sc.nextLine();
////            System.out.println("name:");
////            String name = sc.nextLine();
////            System.out.println("img:");
////            String img = sc.nextLine();
////            
////            System.out.println("cataid:");
////            String cataID = sc.nextLine();
////            System.out.println("des:");
////            String des = sc.nextLine();
////            System.out.println("price:");
////            double price = sc.nextDouble();
////            System.out.println(dao.searchProductByID(cataID));
////        List<Product> list = dao.searchProductByName(cataID);
////        for (Product o : list) {
////            System.out.println(o);
////        }
////            dao.updateProduct(id, name, img, price, cataID, des);
//    }
}
