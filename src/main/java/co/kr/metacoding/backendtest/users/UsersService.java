package co.kr.metacoding.backendtest.users;

import co.kr.metacoding.backendtest.core.error.ex.ExceptionApi400;
import co.kr.metacoding.backendtest.core.error.ex.ExceptionApi404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public UsersResponse.SaveDTO save(UsersRequest.SaveDTO reqDTO) {
        Optional<Users> usersOP = usersRepository.findByName(reqDTO.getName());
        if (usersOP.isPresent()) throw new ExceptionApi400("중복된 이름이 존재합니다");

        Users usersPS = usersRepository.save(reqDTO.toEntity());
        return new UsersResponse.SaveDTO(usersPS);
    }

    public UsersResponse.GetDTO get(Integer id) {
        Users usersOP = usersRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("user가 존재하지 않습니다"));

        return new UsersResponse.GetDTO(usersOP);
    }

    @Transactional
    public UsersResponse.UpdateDTO update(UsersRequest.UpdateDTO reqDTO, Integer id) {
        Users usersOP = usersRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("user가 존재하지 않습니다"));

        usersOP.update(reqDTO.getName());
        return new UsersResponse.UpdateDTO(usersOP);
    }
}
