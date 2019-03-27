INSERT INTO Member(MemberId, FirstName, LastName, Email)
VALUES(
        (1, 'Sam', 'Jones', 'samjones@inlook.com'),
        (2, 'Jenny', 'Jams', 'jennyjams@inlook.com'),
        (3, 'Joey', 'Bishop', 'joeybishop@inlook.com'),
        (4, 'Deloris','Walters','dWalters@gmail.com'),
        (5, 'Sandra','Madela','sandraM@yahoo.mail')
      );

INSERT INTO FoodPrep(PrepId, PrepName, PrepDesc, PrepBody)
VALUES(
        (6, 'Burritos for Breakfast', 'Prepare breakfast burritos and freeze', 'blah, blah, foodprep etc'),
        (7, 'Rise and Dine', 'Prepare breakfast burritos and freeze', 'blah, blah, foodprep etc'),
        (8, 'Dinner Delight', 'Vegetable Noodle Spaghetti', 'blah, blah, foodprep for spaghetti, etc'),
        (9, 'Tuesday Taters', 'Prepare taters ', 'blah, blah, great taters'),
        (10, 'Pizza Friday', 'Prepare Pizza etc', 'blah, blah, foodprep pizza, etc')
      );

INSERT INTO Picture(PictureId, PrepId, PictureName, Picture)
VALUES(
        (11, 6, 'Breakfast Burrittos', 'img of picture'),
        (12, 7, 'Breakfast Burrittos2', 'img of picture'),
        (13, 8, 'Vegetable Noodle Spaghetti', 'img of picture'),
        (14, 9, 'Taters', 'img of picture'),
        (15, 10, 'Gluten Free Pizza', 'img of picture')
      );

INSERT INTO Blog(BlogId, BlogName, BlogDesc, BlogBody)
VALUES(
        (16, 'Vegetables', 'Colors of vegetables', 'img of picture'),
        (17, 'Fruits', 'Who needs fruits?', 'img of picture'),
        (18, 'Spaghetti', 'Spaghetti noodles from squash','img of picture'),
        (19, 'Taters','Taters and Chili','img of picture'),
        (20, 'Pizza', 'Gluten Free Pizza','img of picture')
      );

INSERT INTO Video(VideoId, VideoName, VideoDesc, VideoFile)
VALUES(
         (21, 'Vegetables Video','Vegetable colors and their nutritional benefit','Vegetables Video File'),
         (22, 'Fruits Video','Describes the sugar in fruits vs processed foods','Fruits Video File'),
         (23, 'Spaghetti Video','Describes benefits of using vegetable noodles for spaghetti','Spaghetti Video File'),
         (24, 'Taters Video','Explains taters and benefits of their carbohydrates','Taters Video File'),
         (25, 'Pizza Video','Explains benefits of gluten free pizza for certain allergies or conditions','Pizza Video File')
       );

INSERT INTO PodCast(PodCastId, PodName, PodDesc, PodFile)
VALUES(
         (26, 'Vegetables Audio','Vegetable colors and their nutritional benefit','Vegetables Audio File'),
         (27, 'Fruits Audio','Describes the sugar in fruits vs processed foods','Fruits Audio File'),
         (28, 'Spaghetti Audio','Describes benefits of using vegetable noodles for spaghetti','Spaghetti Audio File'),
         (29, 'Taters Audio','Explains taters and benefits of their carbohydrates','Taters Audio File'),
         (30, 'Pizza Audio','Explains benefits of gluten free pizza for certain allergies or conditions','Pizza Audio File')
       );