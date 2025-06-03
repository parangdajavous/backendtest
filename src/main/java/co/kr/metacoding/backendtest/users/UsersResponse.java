package co.kr.metacoding.backendtest.users;


import lombok.Data;

public class UsersResponse {

    @Data
    public static class SaveDTO {
        private Integer id;
        private String name;

        public SaveDTO(Users users) {
            this.id = users.getId();
            this.name = users.getName();
        }
    }
}
