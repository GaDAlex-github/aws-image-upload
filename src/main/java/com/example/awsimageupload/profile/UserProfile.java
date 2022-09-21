package com.example.awsimageupload.profile;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Document
public class UserProfile {


    private UUID id;
    private final String username;
    private  String imageLink; //S3 key

    public UserProfile(UUID userProfileId, String username, String userProfileImageLink) {
        this.id = userProfileId;
        this.username = username;
        this.imageLink = String.valueOf(userProfileImageLink);
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public Optional<String> getImageLink() {
        return Optional.ofNullable(imageLink);
    }

    public void setImageLink(String userProfileImageLink) {
        this.imageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(username, that.username) &&
               Objects.equals(imageLink, that.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, imageLink);
    }
}
