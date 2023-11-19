package mtc.ncr.channel.Repository;

import lombok.extern.slf4j.Slf4j;
import mtc.ncr.channel.db.DBConnectionUtil;
import mtc.ncr.channel.dto.AccountDto;
import mtc.ncr.channel.dto.CheckDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CheckRepository {
    public CheckDto trxResultCheck(String aprv_sno) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CheckDto result = null;

        String sql = "select aprv_sno, upmu_g, err_msg from chl_sdt_gojeong_slv where aprv_sno = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, aprv_sno);

            rs = pstmt.executeQuery();
            while(rs.next()){
                int upmu_g_out = rs.getInt("upmu_g");
                String err_msg_out = rs.getString("err_msg");
                String status = getStatus(upmu_g_out);
                result = new CheckDto(upmu_g_out, status, err_msg_out);
            }
            return result;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private String getStatus(int upmu_g) {
        if(upmu_g == 0) return "진행 중";
        else if(upmu_g == 1) return "결제성공";
        else if(upmu_g == 2) return "충전성공";
        else if(upmu_g == 3) return "결제실패";
        else if(upmu_g == 4) return "충전실패";

        return "알 수 없는 오류 발생";
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
