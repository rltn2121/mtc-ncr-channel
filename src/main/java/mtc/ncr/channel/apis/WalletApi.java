package mtc.ncr.channel.apis;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface WalletApi {

public interface MtcNcrChannelApi {

    @Operation(summary = "#1. 전 계좌 조회")
    @GetMapping("/{acno}/all")
    ResponseEntity<?> JohoiAll(@PathVariable("acno") String acno) throws Exception;

    @Operation(summary = "#2. 통화코드별  조회")
    @GetMapping("/{acno}")
    ResponseEntity<?> JohoiByCurC(@PathVariable("acno") String acno,
                                  @RequestParam(value = "cur_c") String cur_c) throws Exception;
}
