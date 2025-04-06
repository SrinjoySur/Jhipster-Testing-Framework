package com.epam.api.pojos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class User {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private boolean activated;
    private String langKey;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private ArrayList<String> authorities;
    private String resetDate;
    static class UserBuilder{
        private Integer id;
        private String login;
        private String firstName;
        private String lastName;
        private String email;
        private String imageUrl;
        private boolean activated;
        private String langKey;
        private String createdBy;
        private String createdDate;
        private String lastModifiedBy;
        private String lastModifiedDate;
        private ArrayList<String> authorities;
        private String resetDate;
    }
}
