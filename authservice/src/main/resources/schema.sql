CREATE TABLE IF NOT EXISTS `app_user` (
    `email` VARCHAR(255) NOT NULL PRIMARY KEY,
    `password` VARCHAR(255),
    `firstName` VARCHAR(255),
    `lastName` VARCHAR(255)
);