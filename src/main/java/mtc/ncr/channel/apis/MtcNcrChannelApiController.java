//package mtc.ncr.channel.apis;
//
//import mtc.ncr.channel.dto.MtcNcrChannelRequest;
//import mtc.ncr.channel.dto.MtcNcrChannelResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@RestController
//@RequestMapping ("/v1")
//public class MtcNcrChannelApiController implements MtcNcrChannelApi {
//    // org.slf4j
//    private final static Logger log = LoggerFactory.getLogger(MtcNcrChannelApiController.class);
//
//    //   -->  v1/hello
//    @Override
//    public ResponseEntity<?> hello(MtcNcrChannelRequest mtcncrchannelrequest) {
//        MtcNcbrChannelResponse mtcncrchannelResponse = new MtcNcrChannelResponse();
//        mtcncrchannelResponse.setId(mtcncrchannelrequest.getId());
//        mtcncrchannelResponse.setName(mtcncrchannelrequest.getName());
//        mtcncrchannelResponse.setTeam(mtcncrchannelrequest.getTeam());
//        String msg = String.format("Hello, %s", mtcncrchannelrequest.getName());
//        mtcncrchannelResponse.setMessage(msg);
//        mtcncrchannelResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//        log.info(" response ==> {}", mtcncrchannelResponse);
//
//        return ResponseEntity.ok(mtcncrchannelResponse);
//    }
//}
