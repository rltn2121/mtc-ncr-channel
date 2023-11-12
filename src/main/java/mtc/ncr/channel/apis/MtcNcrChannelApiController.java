package mtc.ncr.channel.apis;

import mtc.ncr.channel.Repository.SdaMainMasRepository;
import mtc.ncr.channel.dto.AccountDto;
import mtc.ncr.channel.dto.MtcNcrChannelRequest;
import mtc.ncr.channel.dto.MtcNcrChannelResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;


@CrossOrigin
@RestController
@RequestMapping ("/wallet")
public class MtcNcrChannelApiController implements MtcNcrChannelApi {
    // org.slf4j
    private final static Logger log = LoggerFactory.getLogger(MtcNcrChannelApiController.class);
    SdaMainMasRepository repository = new SdaMainMasRepository();

    @Override
    public ResponseEntity<?> walletJohoi(String acno, String cur_c) {
        log.info("acno : {} , cur_c : {}", acno, cur_c);
        AccountDto account = null;
        try {
            if(cur_c == null){
                account = repository.find(acno, "");
            }else {
                account = repository.find(acno, cur_c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        log.info("account: {}", account);
        if(account != null){
            return ResponseEntity.ok(account);
        }else{
            return ResponseEntity.noContent().build();
        }

    }
}