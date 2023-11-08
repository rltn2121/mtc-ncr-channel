package mtc.ncr.channel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    public String acno;
    public String cur_c;
    public int ac_jan;
}
