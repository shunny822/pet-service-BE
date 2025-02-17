insert into authority (name)
values ('일반 사용자'), ('펫시터'), ('관리자');

insert into member (email, password, name, phone_number, authority_id, deleted, suspended)
values ('email@naver.com', 'q0e89w7rq0ew978r09q8w7er', 'suhyun', '010-0000-0000', 1, false, false),
        ('e22mail@naver.com', 'q0e89w7rq0ew978r09q8w7er', 'doodoo', '010-0000-0000', 1, false, false);

insert into day_of_the_week (day_name)
values ('월요일'),
       ('화요일'),
       ('수요일'),
       ('목요일'),
       ('금요일'),
       ('토요일'),
       ('일요일');

insert into code_group (id, classification)
values (1000, '강아지'),
       (2000, '고양이'),
       (3000, '새'),
       (4000, '도마뱀'),
       (5000, '뱀'),
       (6000, '설치류');

insert into pet_service (type)
values ('산책'),
       ('밥 주기'),
       ('목욕'),
       ('놀아주기');

insert into pet_sitter (address, start_time, end_time, price_per_hour, active, id)
values ('서울특별시 관악구', '09:00:00', '18:00:00', 20000, true, 1),
       ('서울특별시 강남구', '10:00:00', '16:00:00', 20000, true, 2);

insert into possible_day (pet_sitter_id, day_of_the_week_id)
values (1, 1),
       (1, 3),
       (1, 5),
       (2, 2),
       (2, 4);

insert into possible_pet_type (pet_sitter_id, code_group_id)
values (1, 1000),
       (1, 2000),
       (2, 3000);

insert into providing_service(pet_sitter_id, pet_service_id)
values (1, 1),
       (1, 2),
       (2, 4);