package mtc.ncr.channel.apis;

import mtc.ncr.channel.dto.MtcNcrChannelRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MtcNcrChannelApi {
    @PostMapping("/hello")
    ResponseEntity<?> hello(@RequestBody MtcNcrChannelRequest mtcncrchannelrequest);

}
