CREATE TABLE IF NOT EXISTS `APP_USER`
(
    `user_id`
    VARCHAR
(
    45
) NOT NULL,
    `password` VARCHAR
(
    100
) NOT NULL,
    `email` VARCHAR
(
    255
) NOT NULL,
    `name` VARCHAR
(
    255
) NOT NULL,
    `role` VARCHAR
(
    45
) NOT NULL,
    `last_time_logged_in` VARCHAR
(
    255
) NOT NULL,
    `creation_date` VARCHAR
(
    255
) NOT NULL,
    `modification_date` VARCHAR
(
    255
) NOT NULL,
    PRIMARY KEY
(
    `user_id`
));
