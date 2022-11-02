-- 회원
drop table member cascade constraints;
select * from member;

create table member (
	email			varchar2(50)		not null	primary key,
	name			varchar2(30)		not null,
	password		varchar2(100)		not null,
	member_gender	char(1) 			not null,
	birthday		date 				not null,
	member_tel		varchar2(15)		not null,
	reg_date		date				not null,
	member_del		char(1)	default 'N'	not null,

	constraint check_gender check(member_gender in ('M', 'F')),
	constraint check_del check(member_del in ('N', 'Y'))
);
alter table member
modify (
	member_tel varchar2(15)	
);

-- 배송지
drop table address cascade constraints;

create table address (
	addr_no			number(4)		not	null 	primary key,
	email			varchar2(50)	not	null,
	addr_name		varchar2(20)	not	null,
	tel				number(15)		not	null,	
	roadaddress		varchar2(100)	not	null,	
	jibunaddress	varchar2(100)	not	null,	
	zonecode		number(5)		not	null,	
	detailaddress	varchar2(100)	not	null,

	constraint fk_address_email foreign key(email) references member(email)
);

-- 분류
drop table category cascade constraints;

create table category (
	category_no	number(4)	not null	primary key,
	large		varchar2(20)	not null,
	small		varchar2(20)	not null
);


-- 상품
drop table product cascade constraints;

create table product (
	product_no		number(4)		not	null	primary key,
	product_name	varchar2(100)	not	null,	
	category_no		number(4)		not	null,
	price			number(10)		not	null,	
	detail			varchar2(2000)	not	null,	
	gender			char(1)			not	null,	-- M / F / U

	constraint fk_product_category_no foreign key(category_no) references category(category_no)	
);

-- 컬러
drop table color cascade constraints;

create table color (
	color	varchar2(20)	not null	primary key
);

-- 상품 상세
drop table product_detail cascade constraints;

create table product_detail (
	product_detail_no	number(4)		not	null	primary key,
	product_no			number(4)		not null,
	product_size		varchar2(20)	not null,
	color				varchar2(20)	not null,
	stock	
			number(4)		not null,

	constraint fk_product_detail_product_no foreign key(product_no) references product(product_no),
	constraint fk_product_detail_color foreign key(color) references color(color)
);

-- 상품 사진
drop table product_photo cascade constraints;

create table product_photo (
	photo_no		number(4)		not	null	primary key,
	product_no		number(4)		not null,
	product_photo	varchar2(100)	not null,
	batch			number(1)		not null,				-- 1(썸네일) / 2(머리) / 3(몸통)
	color			varchar2(20)	not null,

	constraint fk_product_photo_product_no foreign key(product_no) references product(product_no),
	constraint fk_product_photo_color foreign key(color) references color(color)
);

-- 특징
drop table product_feature cascade constraints;

create table product_feature (
	feature_no	number(4)		not null	primary key,
	product_no	number(4)		not	null,
	feature		varchar2(300)	not	null,

	constraint fk_product_feature_product_no foreign key(product_no) references product(product_no)
);

-- 위시리스트
drop table wish cascade constraints;

create table wish (
	wish_no		number(4)		not null	primary key,
	product_no	number(4)		not null,
	email		varchar2(50)	not null,

	constraint fk_wish_email foreign key(email) references member(email),
	constraint fk_wish_product_no foreign key(product_no) references product(product_no)
);

-- 장바구니
drop table cart cascade constraints;

create table cart (
	cart_no					number(4)		not	null	primary key,
	email					varchar2(50)	not	null,
	product_detail_no		number(4)		not	null,
	cart_quantity			number(4)		not	null,

	constraint fk_cart_email foreign key(email) references member(email),
	constraint fk_cart_product_detail_no foreign key(product_detail_no) references product_detail(product_detail_no)
);

-- 문의
drop table QnA cascade constraints;

create table QnA (
	qna_no			number(4)			not	null	primary key,
	email			varchar2(50)		not	null,
	product_no		number(4)			not	null,
	qna_type		varchar2(20)		not	null,	-- 배송, 결제, 상품 ,기타 ...
	notice_subject	varchar2(100)		not	null,
	content			varchar2(2000)		not	null,
	reg_date		date				not	null,
	qna_status		varchar2(30)		not null,
	qna_del			char(1)	default 'N'	not	null,

	constraint fk_QnA_email foreign key(email) references member(email),
	constraint fk_QnA_product_no foreign key(product_no) references product(product_no)
);

-- 리뷰
drop table review cascade constraints;

create table review (
	review_no	number(4)		not	null	primary key,
	product_no	number(4)		not null,
	email		varchar2(50)	not	null,
	content		varchar2(2000)	not	null,
	star		number(1)		not	null,
	review_date	date			not	null,
	review_del	char(1)			not	null,

	constraint fk_review_email foreign key(email) references member(email),
	constraint fk_review_product_no foreign key(product_no) references product(product_no)
);

-- 리뷰 사진
drop table review_photo cascade constraints;

create table review_photo (
	review_photo_no	number(4)		not	null	primary key,
	review_no		number(4)		not	null,
	review_photo	varchar2(100)	not	null,

	constraint fk_review_photo_review_no foreign key(review_no) references review(review_no)
);

-- 주문
drop table user_order cascade constraints;

create table user_order (
	order_no	number(4)		not	null	primary key,
	email		varchar2(50)	not	null,
	order_date	date			not	null,	
	addr_no		number(4)		not	null,
	status		varchar2(20)	not	null,

	constraint fk_user_order_email foreign key(email) references member(email),
	constraint fk_user_order_addr_no foreign key(addr_no) references address(addr_no)
);

-- 주문 상세
drop table user_order_detail cascade constraints;

create table user_order_detail (
	order_detail_no	number(4)				not	null	primary key,
	order_no		number(4)				not null,
	product_no		number(4)				not	null,
	order_quantity	number(4)				not	null,
	refund_chk		char(1)		default 'N'	not	null,	-- N(default, 신청안함) / A(환불진행중) / Y(환불완료) / D(환불거절) / T(환불할수없음, 2주지남)

	constraint fk_user_order_detail_order_no foreign key(order_no) references user_order(order_no),
	constraint fk_user_order_detail_product_no foreign key(product_no) references product(product_no)
);

-- 환불
drop table refund cascade constraints;

create table refund (
	refund_no		number(4)		not	null	primary key,
	order_detail_no	number(4)		not	null,
	reason			varchar2(300)	not	null,	
	refund_photo	varchar2(100)	not	null,

	constraint fk_refund_order_detail_no foreign key(order_detail_no) references user_order_detail(order_detail_no)
);

-- 매장
drop table store cascade constraints;

create table store (
	store_no	number(4)		not null	primary key,
	store_name	varchar2(50)	not	null,	
	store_addr	varchar2(300)	not	null,	
	store_close	varchar2(30)	not	null,	
	store_open	varchar2(30)	not	null,	
	store_tel	number(15)		not	null	
);

-- 공지사항
drop table notice cascade constraints;

create table notice (
	notice_no		number(4)				not	null	primary key,
	notice_type		varchar2(20)			not	null,	
	notice_subject	varchar2(100)			not	null,	
	content			varchar2(2000)			not	null,	
	reg_date		date					not	null,	
	read_count		number(6)				not	null,	
	del				char(1)		default 'N'	not	null
);
