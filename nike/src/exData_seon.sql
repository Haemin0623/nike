--insert into product values (상품번호, '대한민국 스우시', 카테고리번호, 39000, 
--	'대한민국 스우시 티셔츠를 입고 국가대표팀을 응원하세요. 부드러운 니트 소재에 자랑스러운 그래픽을 더해 편안한 착용감을 선사하는 이 티셔츠와 함께라면 경기장에서 응원할 때도, 길거리에서 동료 팬들과 소통할 때도 응원하는 팀에 대한 자부심을 표현할 수 있습니다.'
--	,'M');

--insert into product_detail values (1, 상품번호, '사이즈', '블랙', 재고);
--insert into product_photo values (100, 상품번호, '100.webp', 1, '블랙');

--select * from product;
--select * from product_detail;
--select * from product_photo;

-- 시작 1
insert into product values (100, '여성 크롭 풀오버', 2, 99000, 
	'포근함 혹은 시원함? 부드러운 후디가 크롭 기장과 박시한 핏을 선사하기 때문에 한 가지만 선택할 필요가 없습니다. 아이코닉한 윙스 재킷을 상징하는 디자인 라인이 마이클 조던의 헤리티지를 담아내고, 땀 발산 소재가 짐에서나 도시에서나 한결같은 쾌적함을 선사합니다.'
	,'F');
insert into product_detail values (100, 100, 'S', '블랙', 10);
insert into product_photo values (100, 100, '100.webp', 1, '블랙');


insert into product values (101, '스포츠웨어 에센셜 우븐 재킷', 3, 135000, 
	'쌀쌀한 날씨에 가벼운 레이어로 활용할 수 있는 이 재킷은 오버사이즈 배기 디자인 덕분에 한층 더 편안하며 레이어링하기도 쉽습니다. 재생 크링클 우븐 소재의 앞면 중앙에 새겨진 스우시 그래픽이 강렬한 인상을 심어줍니다. 이 제품은 100% 재생 폴리에스터 및 재생 나일론 섬유로 제작되었습니다.'
	,'F');
insert into product_detail values (104, 101, 'S', '핑크', 2);
insert into product_photo values (101, 101, '101.webp', 1, '핑크');

insert into product values (102, '나이키 드라이 핏 아카데미', 1, 29000, 
	'스크리머지부터 득점에 이르기까지, 이 반팔 탑을 입고 필드에서 손쉽게 움직여보세요. 옆면 트임과 길게 마감된 뒷면 밑단이 이동 중에도 커버력을 유지할 수 있게 해주며, 땀 발산 기술이 적용되어 연습이 열기를 더해가더라도 시원하고 쾌적한 느낌을 유지해줍니다.'
	,'F');
insert into product_detail values (108, 102, 'S', '핑크', 2);
insert into product_photo values (102, 102, '102.webp', 1, '핑크');

insert into product values (103, '스포츠웨어 에센셜 미드라이즈 팬츠', 4, 99000, 
	'가벼운 재생 크링클 우븐 소재로 제작된 나이키 스포츠웨어 에센셜 이지 우븐 팬츠는 넉넉한 핏으로 디자인되어 편안함 그 자체입니다. 다리의 스우시 로고 패널이 평소 즐겨 신는 스니커즈와 매치하기 좋은 시그니처 나이키 룩을 연출합니다. 이 제품은 100% 재생 폴리에스터 및 재생 나일론 섬유로 제작되었습니다.'
	,'F');
insert into product_detail values (112, 103, 'S', '핑크', 5);
insert into product_photo values (103, 103, '103.webp', 1, '핑크');

insert into product values (104, '스포츠웨어 에센셜 미드라이즈 팬츠', 4, 95000, 
	'나이키 드라이 핏 러닝 팬츠를 입고 편안하게 러닝을 즐겨보세요. 통기성이 좋은 땀 발산 소재는 매끄럽고 가벼워서 페이스를 높여도 한결같이 쾌적하고 시원합니다. 슬림 핏으로 날렵한 룩을 연출하며, 발목 주변 지퍼 덕분에 통기성이 좋고 팬츠를 간편하게 착용할 수 있습니다.'
	,'F');
insert into product_detail values (116, 104, 'S', '블루', 5);
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

insert into product_photo values (17, 3, 'd1.webp', 1, '화이트');
insert into product_photo values (18, 3, 'd2.webp', 2, '화이트');
insert into product_photo values (19, 3, 'd3.webp', 2, '화이트');
insert into product_photo values (20, 3, 'd4.jfif', 2, '화이트');
insert into product_photo values (21, 3, 'd5.jfif', 2, '화이트');
insert into product_photo values (22, 3, 'd6.jfif', 2, '화이트');

-- 2
insert into product values (108, '나이키 스포츠웨어 비니', 8, 33000, 
	'여유롭고 푹신한 재킷을 입고 한결 편안한 따뜻함을 느껴보세요. 외부의 인조 털과 매끄러운 우븐 안감으로 레이어링에 좋으며, 신축성 있는 커프스가 추위를 막아줍니다.'
	,'U');
insert into product_detail values (120, 108, 'M', '핑크', 8);
insert into product_photo values (108, 108, '108.webp', 1, '핑크');

insert into product values (109, '나이키 스포츠웨어 비니', 8, 33000, 
	'모자'	,'U');
insert into product_detail values (121, 109, 'M', '브라운', 8);
insert into product_photo values (109, 109, '109.webp', 1, '브라운');

insert into product values (110, '오사카 나오미 플리스 버킷 햇', 8, 39000, 
	'모자' ,'U');
insert into product_detail values (121, 110, 'M', '화이트', 8);
insert into product_photo values (110, 110, '110.webp', 1, '화이트');

insert into product values (111, '오사카 나오미 플리스 버킷 햇', 8, 39000, 
	'모자'	,'U');
insert into product_detail values (122, 111, 'M', '블랙', 8);
insert into product_photo values (111, 111, '111.webp', 1, '블랙');

insert into product values (112, '오사카 나오미 플리스 버킷 햇', 8, 45000, 
	'모자'	,'U');
insert into product_detail values (123, 112, 'M', '블랙', 9);
insert into product_photo values (112, 112, '112.webp', 1, '블랙');

insert into product values (113, '오사카 나오미 플리스 버킷 햇', 8, 45000, 
	'모자'	,'U');
insert into product_detail values (124, 113, 'M', '블랙', 9);
insert into product_photo values (113, 113, '113.webp', 1, '블랙');

insert into product values (114, '남성 프렌치 테리 크루', 1, 69000, 
	'맨투맨'	,'M');
insert into product_detail values (125, 114, 'M', '그린', 1);
insert into product_photo values (114, 114, '114.webp', 1, '그린');

insert into product values (115, 'ACG 써마 핏 플리스 풀오버 후디', 2, 135000, 
	'후디'	,'M');
insert into product_detail values (126, 115, 'M', '그린', 1);
insert into product_photo values (115, 115, '115.webp', 1, '그린');

insert into product values (116, '나이키 써마 핏 리펠', 3, 159000, 
	'재킷'	,'M');
insert into product_detail values (127, 116, 'M', '그린', 7);
insert into product_photo values (116, 116, '116.webp', 1, '그린');

insert into product values (117, '패딩 처리된 플란넬 스케이트보딩 재킷', 3, 209000, 
	'재킷'	,'M');
insert into product_detail values (128, 117, 'M', '블루', 7);
insert into product_photo values (117, 117, '117.webp', 1, '블루');

insert into product values (118, '나이키 스포츠웨어 헤리티지86 퓨추라 워시드', 8, 29000, 
	'모자'	,'U');
insert into product_detail values (129, 118, 'M', '그린', 6);
insert into product_photo values (118, 118, '118.webp', 1, '그린');

insert into product values (119, '나이키 스포츠웨어 헤리티지86 퓨추라 워시드', 8, 29000, 
	'모자'	,'U');
insert into product_detail values (130, 119, 'M', '브라운', 6);
insert into product_photo values (119, 119, '119.webp', 1, '브라운');


insert into product values (120, '나이키 스포츠웨어 에센셜', 1, 59000, 
	'티','F');
insert into product_detail values (131, 120, 'S', '블랙', 10);
insert into product_photo values (120, 120, '120.webp', 1, '블랙');

insert into product values (121, '나이키 스포츠웨어 에센셜', 1, 59000, 
	'티','F');
insert into product_detail values (132, 121, 'S', '그레이', 10);
insert into product_photo values (121, 121, '121.webp', 1, '그레이');

insert into product values (122, '드라이 핏 남성 풀오버 트레이닝 후디', 2, 75000, 
	'티','M');
insert into product_detail values (133, 122, 'S', '그레이', 10);
insert into product_photo values (122, 122, '122.webp', 1, '그레이');

insert into product values (123, '조던 x Off-White™ 숏슬리브 탑', 1, 149000, 
	'티','M');
insert into product_detail values (134, 123, 'S', '그린', 10);
insert into product_photo values (123, 123, '123.webp', 1, '그린');

insert into product values (124, '르브론 풀오버 후디', 2, 75000, 
	'티','M');
insert into product_detail values (135, 124, 'XL', '블루', 10);
insert into product_photo values (124, 124, '124.webp', 1, '블루');

insert into product values (125, 'FFF 리펠 아카데미 AWF', 2, 89000, 
	'재킷','M');
insert into product_detail values (136, 125, 'XL', '블루', 10);
insert into product_photo values (125, 125, '125.webp', 1, '블루');

insert into product values (126, 'FC 바르셀로나 프렌치 테리 후디', 2, 79000, 
	'티','M');
insert into product_detail values (137, 126, 'XL', '블루', 10);
insert into product_photo values (126, 126, '126.webp', 1, '블루');

insert into product values (127, '잉글랜드 플리스 축구 팬츠', 4, 69000, 
	'바지','M');
insert into product_detail values (138, 127, 'XL', '블루', 10);
insert into product_photo values (127, 127, '127.webp', 1, '블루');

insert into product values (128, '나이키 스포츠웨어 서카 하프집 탑', 2, 119000, 
	'티','M');
insert into product_detail values (139, 128, 'XL', '블루', 10);
insert into product_photo values (128, 128, '128.webp', 1, '블루');

insert into product values (129, '나이키 드라이 핏 런 디비전 라이즈 365', 1, 75000, 
	'티','M');
insert into product_detail values (140, 129, 'XL', '블루', 10);
insert into product_photo values (129, 129, '129.webp', 1, '블루');

insert into product values (130, '나이키 스포츠웨어 풀집 리버서블 재킷', 1, 139000, 
	'티','M');
insert into product_detail values (141, 130, 'XL', '블루', 10);
insert into product_photo values (130, 130, '130.webp', 1, '블루');

insert into product values (131, '나이키 코트 레거시', 10, 139000, 
	'티','M');
insert into product_detail values (142, 131, 'XL', '그린', 10);
insert into product_photo values (131, 131, '131.webp', 1, '그린');

insert into product values (132, '나이키 에어 써마 핏 코듀로이', 10, 229000, 
	'티','F');
insert into product_detail values (143, 132, 'XL', '브라운', 10);
insert into product_photo values (132, 132, '132.webp', 1, '브라운');