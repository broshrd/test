insert into venues(venue_name,location) values ('pps','bb');
select *
from venues;
update venues set venue_name='w',location='w'
              where venue_id=1;
delete from venues where venue_id=3;
--Attendee

select * from attendees ;
select * from attendees where attendee_id=1;
insert into attendees (attendee_name,email) values ('bo','bo.com');
update attendees set attendee_name='q',email='q.com'
                    where attendee_id=4;
delete from attendees where attendee_id=5;
--event
select * from events ;
select at.attendee_id,at.attendee_name,at.email from attendees at inner join
    event_attendee eat on at.attendee_id=eat.attendee_id where eat.event_id=1;
select * from events where event_id=1;

insert into events( event_name, event_date, venue_id) values ('mm','2024-05-06T09:08:06.915Z',1);
insert into event_attendee values (1 ,1);

delete from events where event_id=6;
update events set event_name='cc',event_date='2024-08-06T09:08:06.915Z',venue_id=2 where event_id=1;
select * from events ;
delete from event_attendee where event_id=5;
select * from event_attendee;
select * from events ;
delete from event_attendee where event_id = 1;