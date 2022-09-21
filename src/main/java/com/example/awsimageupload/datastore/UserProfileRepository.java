package com.example.awsimageupload.datastore;

import com.example.awsimageupload.profile.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserProfileRepository extends MongoRepository<UserProfile, String> {


    List<UserProfile> selectAllUserProfiles();

    Optional<UserProfile> selectUserProfileById(UUID id);

    int deleteUserProfileById(UUID id);
    int updateUserProfileById(UUID id, UserProfile userProfile);

}

