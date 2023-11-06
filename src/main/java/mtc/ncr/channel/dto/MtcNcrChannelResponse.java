package mtc.ncr.channel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MtcNcrChannelResponse {
    private Long id;
    private String name;
    private String team;
    private String message;
    private String timestamp;
}
