package mtc.ncr.channel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDto {
    private int upmuG;
    private String status;
    private String err_msg;
}
