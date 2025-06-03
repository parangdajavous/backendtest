package co.kr.metacoding.backendtest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UsersRequest.SaveDTO reqDTO) {
        UsersResponse.SaveDTO respDTO = usersService.save(reqDTO);
        return ResponseEntity.ok(respDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        UsersResponse.GetDTO respDTO = usersService.get(id);
        return ResponseEntity.ok(respDTO);
    }
}
