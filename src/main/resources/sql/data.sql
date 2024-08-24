INSERT INTO users (name, email, password, avatar, size) VALUES
('Алиса Смирнова', 'alice.smirnova@example.com', 'password', 'D:\\dataApp\\avatar\\user1.jpg', 'M'),
('Саша Иванов', 'ivanov@example.com', 'password', 'D:\\dataApp\\avatar\\user2.jpg', 'L'),
('Каролина Белая', 'carolina.belaya@example.com', 'password', 'D:\\dataApp\\avatar\\user3.jpg', 'S');


INSERT INTO news_lines (post_date, like_count, dislike_count) VALUES
('2024-01-01 12:00:00', 10, 2),
('2024-01-02 14:30:00', 15, 3),
('2024-01-03 16:45:00', 20, 1);

INSERT INTO comments (user_id, text, date_post, news_line_id) VALUES
(1, 'This is a comment on the first news line', '2024-01-01 13:00:00', 1),
(2, 'Another comment on the first news line', '2024-01-01 14:00:00', 1),
(1, 'Comment on the second news line', '2024-01-02 15:00:00', 2),
(3, 'This is a comment on the third news line', '2024-01-03 17:00:00', 3),
(2, 'Another comment on the third news line', '2024-01-03 18:00:00', 3);
