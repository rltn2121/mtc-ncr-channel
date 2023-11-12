package mtc.ncr.channel.apis;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface HistoryApi {

    @Operation(summary = "#3. 거래내역  조회")
    @GetMapping("/history/{acno}")
    ResponseEntity<?> trxHistory(@PathVariable("acno") String acno,
                                  @RequestParam(value = "cur_c") String cur_c,
                                 @RequestParam(value = "upmu_g") int upmu_g) throws Exception;

}
