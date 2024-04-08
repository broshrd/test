CREATE DATABASE event_attendee;

create table attendees(
     attendee_id serial primary key ,
     attendee_name varchar(50),
     email varchar(50)
);
create table venues(
    venue_id serial primary key ,
    venue_name varchar(100),
    location varchar(200)
);
create table events(
    event_id serial primary key ,
    event_name varchar(150),
    event_date date,
    venue_id int,
    constraint venue_id_fk foreign key (venue_id) references venues(venue_id)on DELETE cascade ON UPDATE cascade
);
create table event_attendee(
    event_attendee_id int,
    event_id int,
    attendee_id int,
    constraint event_id_fk foreign key (event_id) references events(event_id)
                           On delete cascade on update cascade,
    constraint attendee_id_fk foreign key (attendee_id) references attendees(attendee_id)
                           on delete cascade on update cascade,
    primary key (event_id,attendee_id)
);

select * from venues where venue_id=1;