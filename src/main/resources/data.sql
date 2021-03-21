INSERT INTO format(broj_ucesnika, tip_takmicenja)
VALUES (250, 'GRAND_SLAM'),
       (180, 'MASTERS_1000'),
       (130, 'MASTERS_500');

INSERT INTO takmicenje(datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id)
VALUES ('2021-03-10', '2021-03-23', 'Sydney', 'Aus open', 1),
       ('2021-07-04', '2021-07-15', 'Paris', 'Paris Masters', 2),
       ('2021-05-11', '2021-05-21', 'Miami', 'Miami Masters', 2);

INSERT INTO prijava(datum_prijave, drzava_takmicara, kontakt_email, takmicenje_id)
VALUES ('2021-03-07', 'SRB', 'ndj@gmail.com', 1);