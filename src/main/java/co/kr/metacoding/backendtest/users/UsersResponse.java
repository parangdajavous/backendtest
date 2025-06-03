package co.kr.metacoding.backendtest.users;


import lombok.Data;

public class UsersResponse {

    @Data
    public static class SaveDTO {
        private Integer id;

        public SaveDTO(Users users) {
            this.id = users.getId();
        }
    }

    @Data
    public static class GetDTO {
        private Integer id;
        private String name;

        public GetDTO(Users users) {
            this.id = users.getId();
            this.name = users.getName();
        }
    }
}
