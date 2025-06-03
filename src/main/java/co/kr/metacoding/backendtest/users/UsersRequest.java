package co.kr.metacoding.backendtest.users;

import lombok.Data;

public class UsersRequest {

    @Data
    public static class SaveDTO {
        private String name;

        public Users toEntity() {
            return Users.builder()
                    .name(name)
                    .build();
        }

    }
}
