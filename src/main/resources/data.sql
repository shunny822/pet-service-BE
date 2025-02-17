insert into authority (name)
values ('일반 사용자'), ('펫시터'), ('관리자');

insert into member (email, password, name, phone_number, authority_id, deleted, suspended)
values ('email@naver.com', 'q0e89w7rq0ew978r09q8w7er', 'suhyun', '010-0000-0000', 1, false, false);

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