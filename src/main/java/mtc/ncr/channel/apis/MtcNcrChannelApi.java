package mtc.ncr.channel.apis;

import io.swagger.v3.oas.annotations.Operation;
import mtc.ncr.channel.dto.MtcNcrChannelRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MtcNcrChannelApi {
//    @Operation(summary = "#1. Hello API")
//    @PostMapping("/hello")
//    ResponseEntity<?> hello(@RequestBody MtcNcrChannelRequest mtcncrchannelrequest);
//
//    @Operation(summary = "#2. Hell Get API")
//    @GetMapping("/hell")
//    ResponseEntity<?> hell(@ModelAttribute MtcNcrChannelRequest mtcncrchannelrequest);

    @Operation(summary = "#1. 계좌번호 조회")
    @GetMapping("/wallet/{acno}")
    ResponseEntity<?> walletJohoi(@PathVariable("acno") String acno,
                                  @RequestParam(value = "cur_c", required = false) String cur_c);


}
