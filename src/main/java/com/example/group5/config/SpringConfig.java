package com.example.group5.config;

import com.example.group5.repository.DBConnection;
import com.example.group5.service.CoursePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringConfig {
    private static SpringConfig springConfig = null;
    private DBConnection dbConnection = null;

    private CoursePageService coursePageService = null;

    private Logger logger = null;

    public SpringConfig() {
        this.dbConnection = new DBConnection(
                (0 < System.getenv("DATABASE_URL").length()) ? System.getenv("DATABASE_URL") : "db-5308.cs.dal.ca",
                (0 < System.getenv("DATABASE_USER").length()) ? System.getenv("DATABASE_USER") : "CSCI5308_5_TEST_USER",
                (0 < System.getenv("DATABASE_PASSWORD").length()) ? System.getenv("DATABASE_PASSWORD") : "CSCI5308_5_TEST_5570"
        );
        this.coursePageService = new CoursePageService();
        this.logger = LoggerFactory.getLogger(String.valueOf(this));
    }

    public CoursePageService getCoursePageService() {
        return coursePageService;
    }

    public void setCoursePageService(CoursePageService coursePageService) {
        this.coursePageService = coursePageService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public static SpringConfig getObject(){
        if (springConfig == null){
            springConfig = new SpringConfig();
        }
        return SpringConfig.springConfig;
    }
}