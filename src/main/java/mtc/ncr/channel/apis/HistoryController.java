package mtc.ncr.channel.apis;

import mtc.ncr.channel.Repository.SdtGojeongSlvRepository;
import mtc.ncr.channel.dto.GojeongDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping ("/wallet")
public class HistoryController implements HistoryApi {
    // org.slf4j
    private final static Logger log = LoggerFactory.getLogger(HistoryController.class);
    private SdtGojeongSlvRepository repository = new SdtGojeongSlvRepository();

    @Override
    public ResponseEntity<?> trxHistory(String acno) throws Exception {
        log.info("acno : {} ", acno);
        List<GojeongDto> result = repository.trxHistory(acno);
        if(result.size() > 0) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}