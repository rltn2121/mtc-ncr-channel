package mtc.ncr.channel.apis;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CheckApi {
    @Operation(summary = "#0. 충전/결제 결과 확인")
    @GetMapping("/{AccountDto}")
    ResponseEntity<?> trxResultCheck(@PathVariable("aprv_sno") String aprv_sno) throws Exception;

}
