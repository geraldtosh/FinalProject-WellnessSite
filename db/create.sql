
CREATE TABLE PodCast (
                PodCastId INT NOT NULL,
                PodName VARCHAR(40) NOT NULL,
                PodDesc VARCHAR(80) NOT NULL,
                PodFile LONGBLOB NOT NULL,
                PRIMARY KEY (PodCastId)
);


CREATE TABLE Video (
                VideoId INT NOT NULL,
                VideoName VARCHAR(20) NOT NULL,
                VideoDesc VARCHAR(80) NOT NULL,
                VideoFile LONGBLOB NOT NULL,
                PRIMARY KEY (VideoId)
);


CREATE TABLE Blog (
                BlogId INT AUTO_INCREMENT NOT NULL,
                BlogName VARCHAR(40) NOT NULL,
                BlogDesc VARCHAR(80) NOT NULL,
                BlogBody VARCHAR(300) NOT NULL,
                PRIMARY KEY (BlogId)
);


CREATE TABLE FoodPrep (
                PrepId INT AUTO_INCREMENT NOT NULL,
                PrepName VARCHAR(40) NOT NULL,
                PrepDesc VARCHAR(80) NOT NULL,
                PrepBody VARCHAR(5000) NOT NULL,
                PRIMARY KEY (PrepId)
);


CREATE TABLE Picture (
                PictureId INT NOT NULL,
                PrepId INT NOT NULL,
                PictureName VARCHAR(50) NOT NULL,
                Picture LONGBLOB,
                PRIMARY KEY (PictureId)
);


CREATE TABLE Member (
                MemberId INT NOT NULL,
                FirstName VARCHAR(20) NOT NULL,
                LastName VARCHAR(20) NOT NULL,
                Email VARCHAR(40) NOT NULL,
                PRIMARY KEY (MemberId)
);


ALTER TABLE Picture ADD CONSTRAINT foodprep_picture_fk
FOREIGN KEY (PrepId)
REFERENCES FoodPrep (PrepId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
