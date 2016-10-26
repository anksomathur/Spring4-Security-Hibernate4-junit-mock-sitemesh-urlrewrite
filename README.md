# SpringUtility
This project contains apring 4 +hibernate 4+mysql+sitemesh+url rewriting+Junit/Mock Test.


Createa Data Base:

CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1


CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `fk_userid` (`userid`),
  KEY `fk_roleid` (`roleId`),
  CONSTRAINT `fk_roleid` FOREIGN KEY (`roleId`) REFERENCES `roles` (`RoleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1


CREATE TABLE `roles` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(100) NOT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1


======Insert Values========
insert  into `roles`(`RoleId`,`RoleName`) values (1,'ROLE_USER'),(2,'ROLE_ADMIN'),(3,'ROLE_DBA');

insert  into `user_roles`(`user_role_id`,`userid`,`roleId`) values (1,1,1),(2,2,2),(3,3,3),(6,2,1);

insert  into `users`(`userid`,`username`,`email`,`password`,`enabled`) values (1,'priya','abc@abc.com','priya',1),(2,'naveen','def@def.com','naveen',1),(3,'ankit','a@a.xom','ankit',1);
