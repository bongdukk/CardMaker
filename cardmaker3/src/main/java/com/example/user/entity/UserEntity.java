package com.example.user.entity;


import com.example.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user_table")
public class UserEntity {
    @Id //pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(unique = true) //unique 제약조건 추가
    private String userEmail;

    @Column
    private String password;

    @Column
    private String userId;

    public static UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(userDto.getUserEmail());
        userEntity.setUserId(userDto.getUserId());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;


    }
}
