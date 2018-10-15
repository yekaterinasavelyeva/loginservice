SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `login_project` DEFAULT CHARACTER SET utf8 ;
USE `login_project` ;

-- -----------------------------------------------------
-- Table `login_project`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` CHAR(32) NOT NULL,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  `Status` CHAR(32) NOT NULL,
  PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `login_project`.`passwords`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `passwords`;

CREATE TABLE IF NOT EXISTS `passwords` (
    `UserID` INT(11) NOT NULL,
    `Password` CHAR(32) NOT NULL,
		`Password2` CHAR(32),
		`Password3` CHAR(32),
		PRIMARY KEY (`UserID`),
		FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)

   ENGINE = InnoDB
   AUTO_INCREMENT = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'jekaterinaj', 'Yekaterina', 'Savelyeva', 'ADMIN');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'viktorv', 'Viktor', 'Barbashin', 'ADMIN');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'annaka', 'Anna', 'Kalinina', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'oleglap', 'Oleg', 'Lapin', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'janisoz', 'Janis', 'Ozolins', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'andisli', 'Andis', 'Liepa', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'rutasruta', 'Ruta', 'Kalnina', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'julijastar', 'Julija', 'Starodubova', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'jekaterinagala', 'Jekaterina', 'Galinina', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'antonanton', 'Anton', 'Grib', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'jevgenijza', 'Jevgenij', 'Zajcev', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'aleksejfed', 'Aleksej', 'Fedotov', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'jelizaveta', 'Jelizaveta', 'Saveljeva', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'laurlaura', 'Laura', 'Jansone', 'VISITOR');

INSERT INTO `users` (UserID, Login, FirstName, LastName, Status)
VALUES (default, 'artursku', 'Arturs', 'Kurms', 'VISITOR');


INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (1, 'saveljeva12', 'fjtyfdk45', 'dlfjrkrl76');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (2, 'barbashin11', 'S56hghk45', 'Lx5jdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (3, 'kalinina45', 'ph9yfghk45', 'fR6jdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (4, 'la98pin', 'U7Yfghk45', 'dkdkdjdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (5, 'o23zo98l', 'fWe4hk45', 'dkdkF2ej98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (6, 'lie90Pa', 'fjtCvdk45', 'dk7Tydj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (7, 'kalns56Ka', 'fjD4eGhk45', 'dC7Gjdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (8, 'star67star', 'fjt3Kjghk45', 'dk5Iudj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (9, 'Galinina25', 'fDffghk45', 'dkdVfdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (10, 'gri84iB', 'Yughtfghk45', 'dkdkOhgj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (11, 'za76iCev', 'fLkqfghk45', 'dkdKjHdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (12, 'fedotov76', 'RtRyfghk45', 'dkdkdNbj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (13, 'saveljeva56', 'fjtyfPok45', 'dkdGfjdj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (14, 'jansoNe56', 'fjUifghk45', 'dkdkdioj98');

INSERT INTO `passwords` (UserID, Password, Password2, Password3)
VALUES (15, 'urm87s6', 'jhytjrk98', 'podkdjdj98');