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
    `FirstName` CHAR(32) NOT NULL,
    `LastName` CHAR(32) NOT NULL,
    `Status` CHAR(32) NOT NULL,
PRIMARY KEY (`UserID`)
)
ENGINE=InnoDB
AUTO_INCREMENT=1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'jekaterinaj', 'saveljeva12', 'Yekaterina', 'Savelyeva', 'ADMIN');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'viktorv', 'barbashin11', 'Viktor', 'Barbashin', 'ADMIN');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'annaka', 'kalinina45', 'Anna', 'Kalinina', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'oleglap', 'la98pin', 'Oleg', 'Lapin', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'janisoz', 'o23zo98l', 'Janis', 'Ozolins', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'andisli', 'lie90Pa', 'Andis', 'Liepa', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'rutasruta', 'kalns56Ka', 'Ruta', 'Kalnina', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'julijastar', 'star67star', 'Julija', 'Starodubova', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'jekaterinagala', 'Galinina25', 'Jekaterina', 'Galinina', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'antonanton', 'gri84iB', 'Anton', 'Grib', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'jevgenijza', 'za76iCev', 'Jevgenij', 'Zajcev', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'aleksejfed', 'fedotov76', 'Aleksej', 'Fedotov', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'jelizaveta', 'saveljeva56', 'Jelizaveta', 'Saveljeva', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'laurlaura', 'jansoNe56', 'Laura', 'Jansone', 'VISITOR');

INSERT INTO `users` (UserID, Login, Password, FirstName, LastName, Status)
VALUES (default, 'artursku', 'urm87s6', 'Arturs', 'Kurms', 'VISITOR');
