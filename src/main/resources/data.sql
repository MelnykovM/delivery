INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo1');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo2');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo3');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo4');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo5');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo6');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo7');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo8');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo9');

INSERT INTO `dish_entity` (`id`, `dish_name`) VALUES (NULL, 'bludo10');



INSERT INTO `user_entity` (`id`, `isvip`, `name`,  `phone_number`) VALUES (NULL, 1, 'mihail', '0994991419');

INSERT INTO `user_entity` (`id`, `isvip`, `name`,  `phone_number`) VALUES (NULL, 0, 'vasiliy', '0994777777');

INSERT INTO `user_entity` (`id`, `isvip`, `name`,  `phone_number`) VALUES (NULL, 0, 'sergey', '0994333333');

INSERT INTO `user_entity` (`id`, `isvip`, `name`,  `phone_number`) VALUES (NULL, 0, 'anna', '0994335555');


INSERT INTO `order_entity` (`id`, `address`, `amount`, `date`, `user_id`) VALUES (NULL, 'govorova', '140', '2021-01-17 04:20:00', 1);

INSERT INTO `order_entity` (`id`, `address`, `amount`, `date`, `user_id`) VALUES (NULL, 'uspenskaya', '350', '2021-02-17 04:20:00', 2);

INSERT INTO `order_entity` (`id`, `address`, `amount`, `date`, `user_id`) VALUES (NULL, 'uspenskaya', '450', '2021-03-17 04:20:00', 2);


INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (1, 3);
INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (1, 5);
INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (1, 6);

INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (2, 2);
INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (2, 3);

INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (3, 6);
INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (3, 8);
INSERT INTO `order_dish` (`order_id`, `dish_id`) VALUES (3, 10);







