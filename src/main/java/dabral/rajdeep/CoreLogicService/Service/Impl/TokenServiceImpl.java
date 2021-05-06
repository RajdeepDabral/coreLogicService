package dabral.rajdeep.CoreLogicService.Service.Impl;

import dabral.rajdeep.CoreLogicService.Service.TokenService;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String generateToken() {
        String token = RandomString.make(50);
        return token;
    }
}