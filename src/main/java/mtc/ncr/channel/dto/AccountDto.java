package mtc.ncr.channel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    public String acno;
    public String cur_c;
    public int ac_jan;
}
