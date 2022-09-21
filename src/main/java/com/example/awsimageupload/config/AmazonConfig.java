package com.example.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class AmazonConfig {
    @Value("${spring.data.mongodb.username}")
    private String dbUsername;

    @Value("${spring.data.mongodb.password}")
    private String dbPassword;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.port}")
    private String dbPort;

    @Value("${spring.data.mongodb.host}")
    private String dbHost;

    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIATCB2M5A466S3IK26",
                "rVeSuvgyoWuncMarN6v2yDrH5/OX7T8ugWb2c/cL"
        );
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.EU_WEST_2)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

        String dbUrl = dbHost + ":" + dbPort + "/" + dbName;
        DataSource dataSource = new DriverManagerDataSource(dbUrl, dbUsername, dbPassword);
        return new JdbcTemplate(dataSource);
    }

}
