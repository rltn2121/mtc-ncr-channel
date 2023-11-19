package mtc.ncr.channel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GojeongDto {
    private int sno;
    private String acno;
    private String trxdt;
    private String cur_c;
    private String err_code;
    private int upmu_g;
    private String aprv_sno;
    private int trx_amt;
    private int nujk_jan;
}
