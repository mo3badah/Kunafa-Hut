create table added
(
  type        varchar(20) null,
  name        varchar(20) not null,
  mediumName  varchar(20) null,
  mediumPrice double      null,
  bigName     varchar(20) null,
  bigPrice    double      null,
  constraint added_name_uindex
    unique (name)
);

alter table added
  add primary key (name);

create table orderdetails
(
  orderNo        bigint      not null,
  clientName     varchar(55) null,
  clientPhone    bigint      null,
  clientLocation varchar(55) null,
  comment        varchar(20) null,
  orderTime      timestamp   not null,
  cachierName    varchar(20) null,
  price          double      null,
  totDisc        double      null,
  totPrice       double      null,
  delivery       int         null,
  totNetPrice    int         null,
  constraint orderDetails_orderNo_uindex
    unique (orderNo)
);

alter table orderdetails
  add primary key (orderNo);

create table ordersdata
(
  orderNo  bigint      null,
  type     varchar(20) not null,
  name     varchar(20) not null,
  no       double      not null,
  quantity varchar(20) null,
  price    double      not null,
  disc     double      not null,
  netPrice double      not null
);

create table preorder
(
  rowNo    int auto_increment,
  type     varchar(20) not null,
  name     varchar(20) not null,
  no       double      not null,
  quantity varchar(20) null,
  price    double      not null,
  disc     double      not null,
  netPrice double      not null,
  constraint preorder_rowNo_uindex
    unique (rowNo)
);

alter table preorder
  add primary key (rowNo);

create table types
(
  id     varchar(20) not null,
  type   varchar(20) not null,
  name   varchar(20) null,
  big    double      null,
  medium double      null,
  constraint id
    unique (id)
);

alter table types
  add primary key (id);

create table user
(
  username    varchar(25)                         not null
    primary key,
  phone       int                                 null,
  password    varchar(32)                         not null,
  create_time timestamp default CURRENT_TIMESTAMP null
);


