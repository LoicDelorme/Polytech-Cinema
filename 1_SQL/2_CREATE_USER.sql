/*
    DROP USER 'SpringAppUser'@'localhost';
*/

CREATE USER 'SpringAppUser'@'%' IDENTIFIED BY 'SpringAppUser';
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'SpringAppUser'@'%' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;

GRANT SELECT, INSERT, UPDATE, DELETE ON TP_CinemaRESTful.* TO 'SpringAppUser'@'%' IDENTIFIED BY 'SpringAppUser';