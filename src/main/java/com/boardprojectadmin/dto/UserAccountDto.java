package com.boardprojectadmin.dto;


import com.boardprojectadmin.domain.UserAccount;
import com.boardprojectadmin.domain.constant.RoleType;

import java.time.LocalDateTime;
import java.util.Set;

public record UserAccountDto(
        String userId,
        String userPassword,
        Set<RoleType> roleType,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserAccountDto of(String userId, String userPassword, Set<RoleType> roleType, String email, String nickname, String memo) {
        return new UserAccountDto(userId, userPassword, roleType, email, nickname, memo, null, null, null, null);
    }

    public static UserAccountDto of(String userId, String userPassword, Set<RoleType> roleType, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId, userPassword, roleType, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getRoleTypes(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPassword,
                roleType,
                email,
                nickname,
                memo
        );
    }

}