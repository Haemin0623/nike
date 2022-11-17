--insert into product values (1, '대한민국 스우시', 카테고리번호, 39000, 
	'대한민국 스우시 티셔츠를 입고 국가대표팀을 응원하세요. 부드러운 니트 소재에 자랑스러운 그래픽을 더해 편안한 착용감을 선사하는 이 티셔츠와 함께라면 경기장에서 응원할 때도, 길거리에서 동료 팬들과 소통할 때도 응원하는 팀에 대한 자부심을 표현할 수 있습니다.'
	,'M');

--insert into product_detail values (1, 상품번호, '사이즈', '블랙', 재고);
--insert into product_photo values (100, 상품번호, '100.webp', 1, '블랙');

--select * from product;
--select * from product_detail;
--select * from product_photo;
-- 시작
insert into product values (100, '여성 크롭 풀오버', 2, 99000, 
	'포근함 혹은 시원함? 부드러운 후디가 크롭 기장과 박시한 핏을 선사하기 때문에 한 가지만 선택할 필요가 없습니다. 아이코닉한 윙스 재킷을 상징하는 디자인 라인이 마이클 조던의 헤리티지를 담아내고, 땀 발산 소재가 짐에서나 도시에서나 한결같은 쾌적함을 선사합니다.'
	,'F');
insert into product_detail values (100, 100, 'S', '블랙', 10);
insert into product_detail values (101, 100, 'M', '블랙', 3);
insert into product_detail values (102, 100, 'L', '블랙', 6);
insert into product_detail values (103, 100, 'XL', '블랙', 1);
insert into product_photo values (100, 100, '100.webp', 1, '블랙');


insert into product values (101, '스포츠웨어 에센셜 우븐 재킷', 3, 135000, 
	'쌀쌀한 날씨에 가벼운 레이어로 활용할 수 있는 이 재킷은 오버사이즈 배기 디자인 덕분에 한층 더 편안하며 레이어링하기도 쉽습니다. 재생 크링클 우븐 소재의 앞면 중앙에 새겨진 스우시 그래픽이 강렬한 인상을 심어줍니다. 이 제품은 100% 재생 폴리에스터 및 재생 나일론 섬유로 제작되었습니다.'
	,'F');
insert into product_detail values (104, 101, 'S', '핑크', 2);
insert into product_detail values (105, 101, 'M', '핑크', 10);
insert into product_detail values (106, 101, 'L', '핑크', 7);
insert into product_detail values (107, 101, 'XL', '핑크', 5);
insert into product_photo values (101, 101, '101.webp', 1, '핑크');

insert into product values (102, '나이키 드라이 핏 아카데미', 1, 29000, 
	'스크리머지부터 득점에 이르기까지, 이 반팔 탑을 입고 필드에서 손쉽게 움직여보세요. 옆면 트임과 길게 마감된 뒷면 밑단이 이동 중에도 커버력을 유지할 수 있게 해주며, 땀 발산 기술이 적용되어 연습이 열기를 더해가더라도 시원하고 쾌적한 느낌을 유지해줍니다.'
	,'F');
insert into product_detail values (108, 102, 'S', '핑크', 2);
insert into product_detail values (109, 102, 'M', '핑크', 10);
insert into product_detail values (110, 102, 'L', '핑크', 7);
insert into product_detail values (111, 102, 'XL', '핑크', 5);
insert into product_photo values (102, 102, '102.webp', 1, '핑크');

insert into product values (103, '스포츠웨어 에센셜 미드라이즈 팬츠', 4, 99000, 
	'가벼운 재생 크링클 우븐 소재로 제작된 나이키 스포츠웨어 에센셜 이지 우븐 팬츠는 넉넉한 핏으로 디자인되어 편안함 그 자체입니다. 다리의 스우시 로고 패널이 평소 즐겨 신는 스니커즈와 매치하기 좋은 시그니처 나이키 룩을 연출합니다. 이 제품은 100% 재생 폴리에스터 및 재생 나일론 섬유로 제작되었습니다.'
	,'F');
insert into product_detail values (112, 103, 'S', '핑크', 5);
insert into product_detail values (113, 103, 'M', '핑크', 6);
insert into product_detail values (114, 103, 'L', '핑크', 7);
insert into product_detail values (115, 103, 'XL', '핑크', 2);
insert into product_photo values (103, 103, '103.webp', 1, '핑크');

insert into product values (104, '스포츠웨어 에센셜 미드라이즈 팬츠', 4, 95000, 
	'나이키 드라이 핏 러닝 팬츠를 입고 편안하게 러닝을 즐겨보세요. 통기성이 좋은 땀 발산 소재는 매끄럽고 가벼워서 페이스를 높여도 한결같이 쾌적하고 시원합니다. 슬림 핏으로 날렵한 룩을 연출하며, 발목 주변 지퍼 덕분에 통기성이 좋고 팬츠를 간편하게 착용할 수 있습니다.'
	,'F');
insert into product_detail values (116, 104, 'S', '블루', 5);
insert into product_detail values (117, 104, 'M', '블루', 6);
insert into product_detail values (118, 104, 'L', '블루', 7);
insert into product_detail values (119, 104, 'XL', '블루', 2);
insert into product_photo values (104, 104, '104.webp', 1, '블루');

insert into product values (105, '나이키 드라이 핏 런 디비전 템포 럭스', 6, 59000, 
	'부드럽고 가벼운 소재와 풍부한 신축성을 갖춘 이 쇼츠는 러닝에 에너지를 불어넣을 수 있습니다. 땀 발산 기술이 적용된 가벼운 패널이 러닝 중 쾌적함을 유지해 줍니다.'
	,'F');
insert into product_detail values (117, 105, 'S', '블루', 5);
insert into product_photo values (105, 105, '105.webp', 1, '블루');

insert into product values (106, '나이키 드라이 핏 ADV 런 디비전', 6, 85000, 
	'런 디비전 머슬 탱크를 입고 도시의 명소와 소리, 구석구석을 가볍게 누벼보세요. 땀 발산 기능과 메쉬 소재 구조가 시원함과 쾌적함을 유지해주며 반사체 디테일을 더해 어떤 길에서도 문제없습니다. 몸체가 넉넉한 핏으로 장거리 러닝을 하는 동안 편안함을 선사합니다.'
	,'F');
insert into product_detail values (118, 106, 'S', '블루', 1);
insert into product_photo values (106, 106, '106.webp', 1, '블루');

insert into product values (107, '플러시 인조 퍼 재킷', 3, 219000, 
	'여유롭고 푹신한 재킷을 입고 한결 편안한 따뜻함을 느껴보세요. 외부의 인조 털과 매끄러운 우븐 안감으로 레이어링에 좋으며, 신축성 있는 커프스가 추위를 막아줍니다.'
	,'F');
insert into product_detail values (119, 107, 'S', '브라운', 7);
insert into product_photo values (107, 107, '107.webp', 1, '브라운');
