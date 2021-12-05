CREATE TABLE `Address` (
  `house` varchar(20) NOT NULL,
  `postcode` varchar(15) NOT NULL,
  `streetName` varchar(20) NOT NULL,
  `placeName` varchar(20) NOT NULL,
  PRIMARY KEY (`house`,`postcode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Bathing Facility` (
  `bathingFacilityID` int(11) NOT NULL AUTO_INCREMENT,
  `propertyID` int(11) NOT NULL,
  `hairDryer` tinyint(1) NOT NULL,
  `shampoo` tinyint(1) NOT NULL,
  `toiletPaper` tinyint(1) NOT NULL,
  PRIMARY KEY (`bathingFacilityID`),
  KEY `bathingFacilityProperty_idx` (`propertyID`),
  CONSTRAINT `bathingFacilityProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

CREATE TABLE `Bathroom` (
  `bathingFacilityID` int(11) NOT NULL,
  `toilet` tinyint(1) NOT NULL,
  `bath` tinyint(1) NOT NULL,
  `shower` tinyint(1) NOT NULL,
  `shared` tinyint(1) NOT NULL,
  KEY `bathroomBathingFacility_idx` (`bathingFacilityID`),
  CONSTRAINT `bathroomBathingFacility` FOREIGN KEY (`bathingFacilityID`) REFERENCES `Bathing Facility` (`bathingFacilityID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Bedroom` (
  `sleepingFacilityID` int(11) NOT NULL,
  `bed1` varchar(15) NOT NULL,
  `bed2` varchar(15) DEFAULT NULL,
  KEY `bedroomSleepingFacility_idx` (`sleepingFacilityID`),
  CONSTRAINT `bedroomSleepingFacility` FOREIGN KEY (`sleepingFacilityID`) REFERENCES `Sleeping Facility` (`sleepingFacilityID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Charge Band` (
  `propertyID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `pricePerNight` decimal(5,2) NOT NULL,
  `serviceCharge` decimal(5,2) NOT NULL,
  `cleaningCharge` decimal(5,2) NOT NULL,
  KEY `chargeBandProperty_idx` (`propertyID`),
  CONSTRAINT `chargeBandProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Guest` (
  `userID` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`,`password`),
  KEY `guest_info_idx` (`userID`,`password`),
  CONSTRAINT `guest_info` FOREIGN KEY (`userID`, `password`) REFERENCES `Person` (`userID`, `password`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Host` (
  `userID` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `superhost` tinyint(1) NOT NULL,
  PRIMARY KEY (`userID`,`password`),
  KEY `host_info_idx` (`userID`,`password`),
  CONSTRAINT `host_info` FOREIGN KEY (`userID`, `password`) REFERENCES `Person` (`userID`, `password`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Kitchen Facility` (
  `propertyID` int(11) NOT NULL,
  `oven` tinyint(1) NOT NULL,
  `refrigerator` tinyint(1) NOT NULL,
  `microwave` tinyint(1) NOT NULL,
  `stove` tinyint(1) NOT NULL,
  `dishwasher` tinyint(1) NOT NULL,
  `tableware` tinyint(1) NOT NULL,
  `cookware` tinyint(1) NOT NULL,
  `basicProvisions` tinyint(1) NOT NULL,
  PRIMARY KEY (`propertyID`),
  KEY `kitchenFacilityProperty_idx` (`propertyID`),
  CONSTRAINT `kitchenFacilityProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Living Facility` (
  `propertyID` int(11) NOT NULL,
  `wifi` tinyint(1) NOT NULL,
  `television` tinyint(1) NOT NULL,
  `satelite` tinyint(1) NOT NULL,
  `streaming` tinyint(1) NOT NULL,
  `dvdplayer` tinyint(1) NOT NULL,
  `boardGames` tinyint(1) NOT NULL,
  PRIMARY KEY (`propertyID`),
  KEY `livingFacilityProperty_idx` (`propertyID`),
  CONSTRAINT `livingFacilityProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Outdoor Facility` (
  `propertyID` int(11) NOT NULL,
  `freeOnSideParking` tinyint(1) NOT NULL,
  `onRoadParking` tinyint(1) NOT NULL,
  `paidCarPark` tinyint(1) NOT NULL,
  `patio` tinyint(1) NOT NULL,
  `barbeque` tinyint(1) NOT NULL,
  PRIMARY KEY (`propertyID`),
  KEY `outdoorFacilityID_idx` (`propertyID`),
  CONSTRAINT `outdoorFacilityID` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Person` (
  `userID` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `title` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `contactDetails` varchar(15) NOT NULL,
  `host` tinyint(1) NOT NULL,
  `guest` tinyint(1) NOT NULL,
  `house` varchar(20) NOT NULL,
  `postcode` varchar(6) NOT NULL,
  PRIMARY KEY (`userID`,`password`),
  KEY `person_house_idx` (`house`,`postcode`),
  CONSTRAINT `person_address` FOREIGN KEY (`house`, `postcode`) REFERENCES `Address` (`house`, `postcode`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Property` (
  `propertyID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` varchar(45) NOT NULL,
  `shortName` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `generalLocation` varchar(45) NOT NULL,
  `breakfast` tinyint(1) NOT NULL,
  `maximumGuests` int(11) NOT NULL,
  `house` varchar(20) NOT NULL,
  `postcode` varchar(15) NOT NULL,
  PRIMARY KEY (`propertyID`),
  KEY `property_host_idx` (`userID`),
  KEY `propertyAddress_idx` (`house`,`postcode`),
  CONSTRAINT `propertyAddress` FOREIGN KEY (`house`, `postcode`) REFERENCES `Address` (`house`, `postcode`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `property_host` FOREIGN KEY (`userID`) REFERENCES `Host` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

CREATE TABLE `Reservation` (
  `userID` varchar(45) NOT NULL,
  `propertyID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `accepted` tinyint(1) NOT NULL,
  KEY `reservationGuest_idx` (`userID`),
  KEY `reservationProperty_idx` (`propertyID`),
  CONSTRAINT `reservationGuest` FOREIGN KEY (`userID`) REFERENCES `Guest` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reservationProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Review` (
  `userID` varchar(45) NOT NULL,
  `propertyID` int(11) NOT NULL,
  `cleanliness` int(11) NOT NULL,
  `communication` int(11) NOT NULL,
  `checkIn` int(11) NOT NULL,
  `accuracy` int(11) NOT NULL,
  `location` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `textDescription` varchar(200) NOT NULL,
  PRIMARY KEY (`propertyID`,`userID`),
  KEY `reviewGuest_idx` (`userID`),
  KEY `reviewProperty_idx` (`propertyID`),
  CONSTRAINT `reviewGuest` FOREIGN KEY (`userID`) REFERENCES `Guest` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reviewProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `Sleeping Facility` (
  `sleepingFacilityID` int(11) NOT NULL AUTO_INCREMENT,
  `propertyID` int(11) NOT NULL,
  `bedLiner` tinyint(1) NOT NULL,
  `towels` tinyint(1) NOT NULL,
  PRIMARY KEY (`sleepingFacilityID`),
  KEY `sleepingFacilityProperty_idx` (`propertyID`),
  CONSTRAINT `sleepingFacilityProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

CREATE TABLE `Utility Facility` (
  `propertyID` int(11) NOT NULL,
  `heating` tinyint(1) NOT NULL,
  `washingMashine` tinyint(1) NOT NULL,
  `dryingMashine` tinyint(1) NOT NULL,
  `fireExtinguisher` tinyint(1) NOT NULL,
  `smokeAlarm` tinyint(1) NOT NULL,
  `firstAidKit` tinyint(1) NOT NULL,
  PRIMARY KEY (`propertyID`),
  KEY `utilityFacilityProperty_idx` (`propertyID`),
  CONSTRAINT `utilityFacilityProperty` FOREIGN KEY (`propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1