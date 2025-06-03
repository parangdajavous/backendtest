package co.kr.metacoding.backendtest.users;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "users_tb")
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Builder
    public Users(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }


}
