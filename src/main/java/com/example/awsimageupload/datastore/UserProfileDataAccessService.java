package com.example.awsimageupload.datastore;

import com.example.awsimageupload.profile.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;


@Repository("userProfiles")
public class UserProfileDataAccessService implements UserProfileRepository {

    private final JdbcTemplate  jdbcTemplate;

    @Autowired
    public UserProfileDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<UserProfile> selectAllUserProfiles() {
        final String sql= "SELECT id, username FROM userProfiles";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID userProfileId = UUID.fromString(resultSet.getString("id"));
            String username = resultSet.getString("username");
            String userProfileImageLink = resultSet.getString("imageLink");
            return new UserProfile(userProfileId , username, userProfileImageLink);
        });
    }

    @Override
    public Optional<UserProfile> selectUserProfileById(UUID id) {
        final String sql = "SELECT id, username,imageLink FROM userProfiles WHERE id = ?";
        UserProfile userProfile = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID userProfileId = UUID.fromString(resultSet.getString("id"));
                    String username = resultSet.getString("username");
                    String userProfileImageLink = resultSet.getString("imageLink");
                    return new UserProfile(userProfileId , username, userProfileImageLink);
                });

        return Optional.ofNullable(userProfile);
    }

    @Override
    public int deleteUserProfileById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserProfileById(UUID id, UserProfile userProfile) {
        // TODO Auto-generated method stub
        return 0;
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


