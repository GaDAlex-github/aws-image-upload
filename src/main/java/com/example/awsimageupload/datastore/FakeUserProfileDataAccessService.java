package com.example.awsimageupload.datastore;


import com.example.awsimageupload.profile.UserProfile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;


@Repository("fakeDao")
public class FakeUserProfileDataAccessService implements UserProfileRepository {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("2aeb885d-8630-4880-b4a3-e83aaa8f6a80"), "janetjones", Optional.of("janetjones.jpg-2448ace4-3500-43df-8aea-d1f4b47c11eb")));
        USER_PROFILES.add(new UserProfile(UUID.fromString("9e54dfd9-2901-41c1-9c6d-799d21df0a84"), "antoniojunior", Optional.of("antoniojunior.jpg-08a3d5f9-567d-44e2-8864-72a090a305d6")));
    }

    @Override
    public List<UserProfile> selectAllUserProfiles(){
        return USER_PROFILES;
    }

    @Override
    public Optional<UserProfile> selectUserProfileById(UUID id) {
        return USER_PROFILES.stream().filter(userProfile -> userProfile.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserProfileById(UUID id) {
        Optional<UserProfile> personMaybe = selectUserProfileById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        USER_PROFILES.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updateUserProfileById(UUID id, UserProfile update) {
        return selectUserProfileById(id)
                .map(userProfile -> {
                    int indexOfPersonToUpdate = USER_PROFILES.indexOf(userProfile);
                    if (indexOfPersonToUpdate >=0) {
                        USER_PROFILES.set(indexOfPersonToUpdate, new UserProfile(id, update.getUsername(),update.getImageLink()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public <S extends UserProfile> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UserProfile> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UserProfile> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<UserProfile> findAll() {
        return null;
    }

    @Override
    public Iterable<UserProfile> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(UserProfile entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserProfile> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserProfile> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserProfile> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserProfile> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends UserProfile> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends UserProfile> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserProfile> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserProfile> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserProfile> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserProfile> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserProfile> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UserProfile, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}


