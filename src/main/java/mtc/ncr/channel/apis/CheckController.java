package mtc.ncr.channel.apis;

import lombok.RequiredArgsConstructor;
import mtc.ncr.channel.Repository.CheckRepository;
import mtc.ncr.channel.dto.CheckDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class CheckController implements CheckApi{

    private final CheckRepository repository;
    @Override
    public ResponseEntity<?> trxResultCheck(String aprv_sno) throws Exception {
        CheckDto result = repository.trxResultCheck(aprv_sno);
        if(result == null) {
            result = new CheckDto(99, "원장정보없음", "원장정보없음");
        }
        return ResponseEntity.ok(result);
    }
}
