package mtc.ncr.channel.Repository;

import lombok.extern.slf4j.Slf4j;
import mtc.ncr.channel.dto.AccountDto;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {
    SdaMainMasRepository repository = new SdaMainMasRepository();
    @Test
    void find() throws SQLException {

        //AccountDto test = new AccountDto("498967108", "KRW", 900000000);

        AccountDto account = repository.find("498967108");
        log.info("account: {}", account);
        //assertThat(account).isEqualTo(test);
    }

    @Test
    void insert() throws SQLException {
        repository.insert("495475490", "KRW", 1500000);
        AccountDto find = repository.find("495475490");
        log.info("account: {}", find);
    }
}