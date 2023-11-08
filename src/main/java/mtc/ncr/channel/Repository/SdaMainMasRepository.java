package mtc.ncr.channel.Repository;

import lombok.extern.slf4j.Slf4j;
import mtc.ncr.channel.db.DBConnectionUtil;
import mtc.ncr.channel.dto.AccountDto;

import java.sql.*;

@Slf4j
public class SdaMainMasRepository {
    public AccountDto find(String acno, String cur_c) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AccountDto account = null;
        String sql = "";
        if(cur_c.isEmpty()){
            sql = "select * from sda_main_mas where acno = ?";
        }else{
            sql = "select * from sda_main_mas where acno = ? and cur_c = ?";
        }

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acno);
            if (!cur_c.isEmpty()){
                pstmt.setString(2, cur_c);
            }

            rs = pstmt.executeQuery();
            while(rs.next()){
                String acno_out = rs.getString("acno");
                String cur_c_out = rs.getString("cur_c");
                int ac_jan = rs.getInt("ac_jan");
                account = new AccountDto(acno_out, cur_c_out, ac_jan);
                System.out.println(account.toString());
            }
            return account;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }
    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }
    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}