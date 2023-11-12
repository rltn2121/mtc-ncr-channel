package mtc.ncr.channel.apis;

import mtc.ncr.channel.Repository.SdaMainMasRepository;
import mtc.ncr.channel.dto.AccountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("/wallet")
public class MtcNcrChannelApiController implements MtcNcrChannelApi {
    // org.slf4j
    private final static Logger log = LoggerFactory.getLogger(MtcNcrChannelApiController.class);
    SdaMainMasRepository repository = new SdaMainMasRepository();

    @Override
    public ResponseEntity<?> JohoiAll(String acno) throws Exception {
        log.info("acno : {}", acno);
        List<AccountDto> result = repository.johoiAll(acno);

        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<?> JohoiByCurC(String acno, String cur_c) throws Exception {
        log.info("acno : {} , cur_c : {}", acno, cur_c);
        AccountDto account = repository.johoiByCurC(acno, cur_c);

        if(account != null){
            return ResponseEntity.ok(account);
        }else{
            return ResponseEntity.noContent().build();
        }

    }
}