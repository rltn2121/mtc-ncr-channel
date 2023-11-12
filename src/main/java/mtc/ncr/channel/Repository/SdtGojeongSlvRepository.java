package mtc.ncr.channel.Repository;

import lombok.extern.slf4j.Slf4j;
import mtc.ncr.channel.db.DBConnectionUtil;
import mtc.ncr.channel.dto.AccountDto;
import mtc.ncr.channel.dto.GojeongDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static mtc.ncr.channel.db.SdaMainMasDbio.SDA_MAIN_MAS_I000;

@Slf4j
@Repository
public class SdtGojeongSlvRepository {
    public List<GojeongDto> trxHistory(String acno) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<GojeongDto> result = new ArrayList<>();

        String sql = "select * from chl_sdt_gojeong_slv where acno = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, acno);

            rs = pstmt.executeQuery();
            while(rs.next()) {
                int sno_out = rs.getInt("sno");
                String acno_out = rs.getString("acno");
                String trxdt_out = rs.getString("trxdt");
                String cur_c_out = rs.getString("cur_c");
                int upmu_g_out = rs.getInt("upmu_g");
                int aprv_sno_out = rs.getInt("aprv_sno");
                int trx_amt_out = rs.getInt("trx_amt");
                int nujk_jan_out = rs.getInt("nujk_jan");
                result.add(new GojeongDto(sno_out, acno_out, trxdt_out, cur_c_out, upmu_g_out, aprv_sno_out, trx_amt_out, nujk_jan_out));
            }
            return result;
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