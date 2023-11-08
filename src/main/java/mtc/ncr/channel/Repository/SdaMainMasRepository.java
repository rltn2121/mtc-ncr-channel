package mtc.ncr.channel.Repository;

import lombok.extern.slf4j.Slf4j;
import mtc.ncr.channel.db.DBConnectionUtil;
import mtc.ncr.channel.dto.AccountDto;

import java.sql.*;

import static mtc.ncr.channel.db.SdaMainMasDbio.SDA_MAIN_MAS_I000;

@Slf4j
public class SdaMainMasRepository {
    public AccountDto find(String acno) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AccountDto account = null;
        String sql = "select * from sda_main_mas where acno = ?";


        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String acno_out = rs.getString("acno");
                String cur_c = rs.getString("cur_c");
                int ac_jan = rs.getInt("ac_jan");
                account = new AccountDto(acno_out, cur_c, ac_jan);
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

    public AccountDto insert(String acno, String curC, int ac_jan) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(SDA_MAIN_MAS_I000);
            pstmt.setString(1, acno);
            pstmt.setString(2, curC);
            pstmt.setInt(3, ac_jan);
            pstmt.executeUpdate();
            return new AccountDto(acno, curC, ac_jan);
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