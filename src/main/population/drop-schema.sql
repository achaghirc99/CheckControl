
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `answer` 
       drop 
       foreign key `FKqiviwk3b1rfidhy9cajsblq37`;

    alter table `application` 
       drop 
       foreign key `FKoa6p4s2oyy7tf80xwc4r04vh6`;

    alter table `application` 
       drop 
       foreign key `FKmbjdoxi3o93agxosoate4sxbt`;

    alter table `application` 
       drop 
       foreign key `FKbna4bqws0yovwmyoul7x2t6cm`;

    alter table `auditor` 
       drop 
       foreign key FK_clqcq9lyspxdxcp6o4f3vkelj;

    alter table `auditrecord` 
       drop 
       foreign key `FKditgyx355sc4ye86w7tj22cq6`;

    alter table `auditrecord` 
       drop 
       foreign key `FKa5p4w0gnuwmtb07juvrg8ptn6`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `commercialbanner` 
       drop 
       foreign key `FKnf4j37rlbxr90ggy307pd79y4`;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `credit_card` 
       drop 
       foreign key `FK31l5hvh7p1nx1aw6v649gw3rc`;

    alter table `duty` 
       drop 
       foreign key `FK3cc3garl37bl7gswreqwr7pj4`;

    alter table `employer` 
       drop 
       foreign key FK_na4dfobmeuxkwf6p75abmb2tr;

    alter table `job` 
       drop 
       foreign key `FKfqwyynnbcsq0htxho3vchpd2u`;

    alter table `job` 
       drop 
       foreign key `FK3rxjf8uh6fh2u990pe8i2at0e`;

    alter table `jobchallenge` 
       drop 
       foreign key `FK2ba5sve1u6cxenx14cbyjq49a`;

    alter table `jobchallenge` 
       drop 
       foreign key `FK6uj3477c3jha0hbatc4xqpeyl`;

    alter table `message` 
       drop 
       foreign key `FKn5adlx3oqjna7aupm8gwg3fuj`;

    alter table `message_thread` 
       drop 
       foreign key `FKr35u0eaupbx6b2w22e33u8s5u`;

    alter table `message_thread_authenticated` 
       drop 
       foreign key `FKq2vcidbbbhljef095pueqhpdk`;

    alter table `message_thread_authenticated` 
       drop 
       foreign key `FKga1oyn9oxkdor5spjyt2rlaur`;

    alter table `message_thread_message` 
       drop 
       foreign key `FKng9giq4eyafnmuev7jm3n8lyf`;

    alter table `message_thread_message` 
       drop 
       foreign key `FKp1bkunf5gyu1vtt1q3f2djagy`;

    alter table `noncommercialbanner` 
       drop 
       foreign key `FKrcem4cf2s7ir1wwyaux4p9ke8`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `requestauditor` 
       drop 
       foreign key `FKpn5tv9qj9g17wg89vpf4d4o22`;

    alter table `spamlist_spam` 
       drop 
       foreign key `FK3anop07gfx9hfevaaypwwv5y`;

    alter table `spamlist_spam` 
       drop 
       foreign key `FK99aij0v64cgb0qe4vxmq0c7s9`;

    alter table `sponsor` 
       drop 
       foreign key `FK28mvxtnmfjcwiw34vs8ryqkpa`;

    alter table `sponsor` 
       drop 
       foreign key FK_20xk0ev32hlg96kqynl6laie2;

    alter table `worker` 
       drop 
       foreign key FK_l5q1f33vs2drypmbdhpdgwfv3;

    drop table if exists `administrator`;

    drop table if exists `announcement`;

    drop table if exists `anonymous`;

    drop table if exists `answer`;

    drop table if exists `application`;

    drop table if exists `auditor`;

    drop table if exists `auditrecord`;

    drop table if exists `authenticated`;

    drop table if exists `chaghir_bulletin`;

    drop table if exists `challenge`;

    drop table if exists `commercialbanner`;

    drop table if exists `companyrecord`;

    drop table if exists `consumer`;

    drop table if exists `credit_card`;

    drop table if exists `descriptor`;

    drop table if exists `duty`;

    drop table if exists `employer`;

    drop table if exists `frias_bulletin`;

    drop table if exists `job`;

    drop table if exists `jobchallenge`;

    drop table if exists `message`;

    drop table if exists `message_thread`;

    drop table if exists `message_thread_authenticated`;

    drop table if exists `message_thread_message`;

    drop table if exists `noncommercialbanner`;

    drop table if exists `offer`;

    drop table if exists `provider`;

    drop table if exists `register`;

    drop table if exists `reneses_bulletin`;

    drop table if exists `requestauditor`;

    drop table if exists `requeststore`;

    drop table if exists `spam`;

    drop table if exists `spamlist`;

    drop table if exists `spamlist_spam`;

    drop table if exists `sponsor`;

    drop table if exists `user_account`;

    drop table if exists `worker`;

    drop table if exists `xxx4`;

    drop table if exists `hibernate_sequence`;

    drop table if exists `maciasportillobulletin`;
