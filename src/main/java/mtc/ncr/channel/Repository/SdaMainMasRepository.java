package mtc.ncr.channel.Repository;

import lombok.extern.slf4j.Slf4j;
import mtc.ncr.channel.db.DBConnectionUtil;
import mtc.ncr.channel.dto.AccountDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static mtc.ncr.channel.db.SdaMainMasDbio.SDA_MAIN_MAS_I000;

@Slf4j
@Repository
public class SdaMainMasRepository {
    public List<AccountDto> johoiAll(String acno) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AccountDto> result = new ArrayList<>();

        String sql = "select * from chl_sda_main_mas where acno = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acno);

            rs = pstmt.executeQuery();
            while(rs.next()){
                String acno_out = rs.getString("acno");
                String cur_c_out = rs.getString("cur_c");
                int ac_jan = rs.getInt("ac_jan");
                result.add(new AccountDto(acno_out, cur_c_out, ac_jan));
            }
            return result;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public AccountDto johoiByCurC(String acno, String cur_c) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AccountDto result = null;

        String sql = "select * from chl_sda_main_mas where acno = ? and cur_c = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acno);
            pstmt.setString(2, cur_c);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String acno_out = rs.getString("acno");
                String cur_c_out = rs.getString("cur_c");
                int ac_jan = rs.getInt("ac_jan");
                result = new AccountDto(acno_out, cur_c_out, ac_jan);
            }
            return result;
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