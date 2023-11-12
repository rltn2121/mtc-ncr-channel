package mtc.ncr.channel.apis;

import mtc.ncr.channel.Repository.SdtGojeongSlvRepository;
import mtc.ncr.channel.dto.GojeongDto;
import mtc.ncr.channel.dto.SuccessDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping ("/wallet")
public class SuccessController implements SuccessApi {
    // org.slf4j
    private final static Logger log = LoggerFactory.getLogger(HistoryController.class);
    private SdtGojeongSlvRepository repository = new SdtGojeongSlvRepository();

    @Override
    public ResponseEntity<?> trxHistory(String aprv_sno) throws Exception {
        log.info("aprv_sno : {} ", aprv_sno);
        SuccessDto result = repository.trxSuccess(aprv_sno);
        if(result != null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}