package mtc.ncr.channel.apis;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface SuccessApi {

    @Operation(summary = "성공여부 조회")
    @GetMapping("/isSuccess/{aprv_sno}")
    ResponseEntity<?> trxHistory(@PathVariable("aprv_sno") String aprv_sno) throws Exception;

}
