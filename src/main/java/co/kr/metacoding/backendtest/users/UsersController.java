package co.kr.metacoding.backendtest.users;

import co.kr.metacoding.backendtest.core.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<?> join(@RequestBody UsersRequest.SaveDTO reqDTO) {
        UsersResponse.SaveDTO respDTO = usersService.save(reqDTO);
        return Resp.ok(respDTO);
    }
}
