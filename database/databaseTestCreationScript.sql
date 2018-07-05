SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `login_project_test` DEFAULT CHARACTER SET utf8 ;
USE `login_project_test` ;

-- -----------------------------------------
-- Table `login_project_test`.`users`
-- -----------------------------------------

DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
    `UserID` INT(11) NOT NULL AUTO_INCREMENT,
    `Login` CHAR(32) NOT NULL,
    `Password` CHAR(32) NOT NULL,
PRIMARY KEY (`UserID`)
)
ENGINE=InnoDB
AUTO_INCREMENT=1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

mysql> INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'jekaterinaj', 'saveljeva12');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'viktorv', 'barbashin11');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'annaka', 'kalinina45');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'oleglap', 'la98pin');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'janisoz', 'o23zo98l');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'andisli', 'lie90Pa');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'rutasruta', 'kalns56Ka');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'julijastar', 'star67star');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'jekaterinagala', 'Galinina25');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'antonanton', 'gri84iB');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'jevgenijza', 'za76iCev');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'aleksejfed', 'fedotov76');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'jelizaveta', 'saveljeva56');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'laurlaura', 'jansoNe56');

INSERT INTO `users` (UserID, Login, Password)
VALUES (default, 'artursku', 'urm87s6');
