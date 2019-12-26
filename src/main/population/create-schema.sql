
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `more_info` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `application` (
       `id` integer not null,
        `version` integer not null,
        `justification` varchar(255),
        `moment` datetime(6),
        `qualifications` varchar(255),
        `reference_number` varchar(255),
        `skills` varchar(255),
        `statement` varchar(255),
        `status` integer,
        `job_id` integer not null,
        `worker_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `responsibility_statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditrecord` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `moment` datetime(6),
        `status` integer,
        `title` varchar(255),
        `auditor_id` integer not null,
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `chaghir_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `languages` varchar(255),
        `moment` datetime(6),
        `name` varchar(255),
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `bronze_goal` varchar(255),
        `bronze_reward_amount` double precision,
        `bronze_reward_currency` varchar(255),
        `deadline` datetime(6),
        `description` varchar(255),
        `gold_goal` varchar(255),
        `gold_reward_amount` double precision,
        `gold_reward_currency` varchar(255),
        `silver_goal` varchar(255),
        `silver_reward_amount` double precision,
        `silver_reward_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercialbanner` (
       `id` integer not null,
        `version` integer not null,
        `credit_card` varchar(255),
        `picture` varchar(255),
        `slogan` varchar(255),
        `target_url` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `companyrecord` (
       `id` integer not null,
        `version` integer not null,
        `ceo` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `evaluation` integer,
        `incorporated` bit,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `credit_card` (
       `id` integer not null,
        `version` integer not null,
        `credit_card_number` varchar(255),
        `cvc` varchar(255),
        `month` varchar(255),
        `name` varchar(255),
        `year` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `descriptor` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `duty` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `duty_title` varchar(255),
        `percentage` double precision,
        `descriptor_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `employer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `frias_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `author` varchar(255),
        `email` varchar(255),
        `location` varchar(255),
        `text` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `job` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `final_mode` bit not null,
        `more_info` varchar(255),
        `reference` varchar(255),
        `salary_amount` double precision,
        `salary_currency` varchar(255),
        `status` integer,
        `title` varchar(255),
        `descriptor_id` integer,
        `employer_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `accepted` bit,
        `body` varchar(255),
        `moment` datetime(6),
        `tags` varchar(255),
        `title` varchar(255),
        `message_thread_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message_thread` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `title` varchar(255),
        `creator_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message_thread_authenticated` (
       `id` integer not null,
        `version` integer not null,
        `messagethread_id` integer,
        `user_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message_thread_message` (
       `message_thread_id` integer not null,
        `message_id` integer not null
    ) engine=InnoDB;

    create table `noncommercialbanner` (
       `id` integer not null,
        `version` integer not null,
        `optional_jingle` varchar(255),
        `picture` varchar(255),
        `slogan` varchar(255),
        `target_url` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `be_careful` bit not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `register` (
       `id` integer not null,
        `version` integer not null,
        `assessment` integer,
        `investment_statement` varchar(255),
        `name` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `reneses_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `name` varchar(255),
        `nationality` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `requestauditor` (
       `id` integer not null,
        `version` integer not null,
        `accepted` bit not null,
        `reference` varchar(255),
        `status` integer,
        `user_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `requeststore` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `spam` (
       `id` integer not null,
        `version` integer not null,
        `spam_word` varchar(255),
        `threshold` double precision,
        primary key (`id`)
    ) engine=InnoDB;

    create table `spamlist` (
       `id` integer not null,
        `version` integer not null,
        `threshold` double precision,
        primary key (`id`)
    ) engine=InnoDB;

    create table `spamlist_spam` (
       `spamlist_id` integer not null,
        `spam_list_id` integer not null
    ) engine=InnoDB;

    create table `sponsor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `organisation_name` varchar(255),
        `credit_card_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `qualifications` varchar(255),
        `skills` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );

    create table `maciasportillobulletin` (
       `id` integer not null,
        `version` integer not null,
        `city` varchar(255),
        `hobbies` varchar(255),
        `moment` datetime(6),
        `name` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    alter table `application` 
       add constraint UK_rf84q38qr35ymh5nn0dcxfdue unique (`reference_number`);

    alter table `credit_card` 
       add constraint UK_4cr95y27s8ti6otoyflmma6oy unique (`sponsor_id`);

    alter table `credit_card` 
       add constraint `UK9vj3ioxk1h0wvlpcytul1jlho` unique (`credit_card_number`);

    alter table `job` 
       add constraint UK_7jmfdvs0b0jx7i33qxgv22h7b unique (`reference`);

    alter table `message_thread_message` 
       add constraint UK_o8pn8p2cwmh1e0br783hyhfog unique (`message_id`);
create index IDXcp4664f36sgqsd0ihmirt0w0 on `offer` (`ticker`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);
create index IDX98uhitjm9562xrxxrb6iw1t3s on `offer` (`deadline`, `reward_amount`);

    alter table `offer` 
       add constraint UK_iex7e8fs0fh89yxpcnm1orjkm unique (`ticker`);
create index IDXjku4alklr49l9cj5jch1kagnn on `requeststore` (`deadline`);
create index IDXbtmrobfclj179qsaxi9n9lmld on `requeststore` (`deadline`, `reward_amount`);
create index IDX7mpr4u7oxcyr0nrl5osmj05uh on `requeststore` (`ticker`);

    alter table `requeststore` 
       add constraint UK_9sfeyr6twwvu5txdxr44e0wul unique (`ticker`);

    alter table `spamlist_spam` 
       add constraint UK_jur3qbbyht6003wx55ijx55e1 unique (`spam_list_id`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `application` 
       add constraint `FKoa6p4s2oyy7tf80xwc4r04vh6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `application` 
       add constraint `FKmbjdoxi3o93agxosoate4sxbt` 
       foreign key (`worker_id`) 
       references `worker` (`id`);

    alter table `auditor` 
       add constraint FK_clqcq9lyspxdxcp6o4f3vkelj 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `auditrecord` 
       add constraint `FKditgyx355sc4ye86w7tj22cq6` 
       foreign key (`auditor_id`) 
       references `auditor` (`id`);

    alter table `auditrecord` 
       add constraint `FKa5p4w0gnuwmtb07juvrg8ptn6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `commercialbanner` 
       add constraint `FKnf4j37rlbxr90ggy307pd79y4` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `credit_card` 
       add constraint `FK31l5hvh7p1nx1aw6v649gw3rc` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `duty` 
       add constraint `FK3cc3garl37bl7gswreqwr7pj4` 
       foreign key (`descriptor_id`) 
       references `descriptor` (`id`);

    alter table `employer` 
       add constraint FK_na4dfobmeuxkwf6p75abmb2tr 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `job` 
       add constraint `FKfqwyynnbcsq0htxho3vchpd2u` 
       foreign key (`descriptor_id`) 
       references `descriptor` (`id`);

    alter table `job` 
       add constraint `FK3rxjf8uh6fh2u990pe8i2at0e` 
       foreign key (`employer_id`) 
       references `employer` (`id`);

    alter table `message` 
       add constraint `FKn5adlx3oqjna7aupm8gwg3fuj` 
       foreign key (`message_thread_id`) 
       references `message_thread` (`id`);

    alter table `message_thread` 
       add constraint `FKr35u0eaupbx6b2w22e33u8s5u` 
       foreign key (`creator_id`) 
       references `user_account` (`id`);

    alter table `message_thread_authenticated` 
       add constraint `FKq2vcidbbbhljef095pueqhpdk` 
       foreign key (`messagethread_id`) 
       references `message_thread` (`id`);

    alter table `message_thread_authenticated` 
       add constraint `FKga1oyn9oxkdor5spjyt2rlaur` 
       foreign key (`user_id`) 
       references `user_account` (`id`);

    alter table `message_thread_message` 
       add constraint `FKng9giq4eyafnmuev7jm3n8lyf` 
       foreign key (`message_id`) 
       references `message` (`id`);

    alter table `message_thread_message` 
       add constraint `FKp1bkunf5gyu1vtt1q3f2djagy` 
       foreign key (`message_thread_id`) 
       references `message_thread` (`id`);

    alter table `noncommercialbanner` 
       add constraint `FKrcem4cf2s7ir1wwyaux4p9ke8` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `requestauditor` 
       add constraint `FKpn5tv9qj9g17wg89vpf4d4o22` 
       foreign key (`user_id`) 
       references `authenticated` (`id`);

    alter table `spamlist_spam` 
       add constraint `FK3anop07gfx9hfevaaypwwv5y` 
       foreign key (`spam_list_id`) 
       references `spam` (`id`);

    alter table `spamlist_spam` 
       add constraint `FK99aij0v64cgb0qe4vxmq0c7s9` 
       foreign key (`spamlist_id`) 
       references `spamlist` (`id`);

    alter table `sponsor` 
       add constraint `FK28mvxtnmfjcwiw34vs8ryqkpa` 
       foreign key (`credit_card_id`) 
       references `credit_card` (`id`);

    alter table `sponsor` 
       add constraint FK_20xk0ev32hlg96kqynl6laie2 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
